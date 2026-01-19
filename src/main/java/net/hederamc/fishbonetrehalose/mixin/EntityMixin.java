package net.hederamc.fishbonetrehalose.mixin;

import java.util.Set;
import net.hederamc.fishbonetrehalose.api.EntityApi;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin implements EntityApi{
    @Shadow private double xOld;
    @Shadow private double yOld;
    @Shadow private double zOld;
    @Shadow private Vec3 position;
    @Shadow private Set<String> tags;

    @Redirect(
        method = "startRiding(Lnet/minecraft/world/entity/Entity;ZZ)Z",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/EntityType;canSerialize()Z"
        )
    )
    private boolean startRiding_canSerialize(EntityType<?> entityType) {
        return true;
    }

    @Inject(
        method = "addPassenger(Lnet/minecraft/world/entity/Entity;)V",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/entity/Entity;passengers:Lcom/google/common/collect/ImmutableList;",
            opcode = Opcodes.PUTFIELD,
            shift = At.Shift.AFTER
        )
    )
    private void sendPassengerAdditionPacket(Entity passenger, CallbackInfo ci) {
        Entity entity = (Entity)(Object)this;
        if (entity instanceof ServerPlayer) {
            ((ServerPlayer)entity).connection.send(new ClientboundSetPassengersPacket(entity));
        }
    }

    @Inject(
        method = "removePassenger(Lnet/minecraft/world/entity/Entity;)V",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/world/entity/Entity;boardingCooldown:I",
            opcode = Opcodes.PUTFIELD,
            shift = At.Shift.AFTER
        )
    )
    private void sendPassengerRemovePacket(Entity passenger, CallbackInfo ci) {
        Entity entity = (Entity)(Object)this;
        if (entity instanceof ServerPlayer) {
            ((ServerPlayer)entity).connection.send(new ClientboundSetPassengersPacket(entity));
        }
    }

    @Override
    public double getX(float partialTickTime) {
        return Mth.lerp(partialTickTime, this.xOld, this.position.x);
    }

    @Override
    public double getY(float partialTickTime) {
        return Mth.lerp(partialTickTime, this.yOld, this.position.y);
    }

    @Override
    public double getZ(float partialTickTime) {
        return Mth.lerp(partialTickTime, this.zOld, this.position.z);
    }

    @Override
    public Set<String> getTags() {
        return this.tags;
    }

    @Override
    public boolean hasTag(String tag) {
        return this.tags.contains(tag);
    }
}
