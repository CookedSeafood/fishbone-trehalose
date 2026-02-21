package net.hederamc.fishbonetrehalose.mixin;

import java.util.Set;
import net.hederamc.fishbonetrehalose.api.CustomDataHolder;
import net.hederamc.fishbonetrehalose.api.EntityTypeHolder;
import net.hederamc.fishbonetrehalose.api.NetworkIdHolder;
import net.hederamc.fishbonetrehalose.api.PosHolder;
import net.hederamc.fishbonetrehalose.api.TagsHolder;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin implements EntityTypeHolder, NetworkIdHolder, PosHolder, TagsHolder, CustomDataHolder{
    @Shadow private EntityType<?> type;
    @Shadow private int id;
    @Shadow private double xo;
    @Shadow private double yo;
    @Shadow private double zo;
    @Shadow private Vec3 position;
    @Shadow private Set<String> tags;
    @Shadow private CustomData customData;

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
    public EntityType<?> type() {
        return this.type;
    }

    @Override
    public int getNetworkId() {
        return this.id;
    }

    @Override
    public void setNetworkId(int id) {
        this.id = id;
    }

    @Override
    public double getX(float partialTickTime) {
        return Mth.lerp(partialTickTime, this.xo, this.position.x);
    }

    @Override
    public double getY(float partialTickTime) {
        return Mth.lerp(partialTickTime, this.yo, this.position.y);
    }

    @Override
    public double getZ(float partialTickTime) {
        return Mth.lerp(partialTickTime, this.zo, this.position.z);
    }

    @Override
    public Vec3 getPos(float partialTickTime) {
        double x = Mth.lerp(partialTickTime, this.xo, this.position.x);
        double y = Mth.lerp(partialTickTime, this.yo, this.position.y);
        double z = Mth.lerp(partialTickTime, this.zo, this.position.z);
        return new Vec3(x, y, z);
    }

    @Override
    public void setX(double x) {
        this.setPos(x, this.position.y, this.position.z);
    }

    @Override
    public void setY(double y) {
        this.setPos(this.position.x, y, this.position.z);
    }

    @Override
    public void setZ(double z) {
        this.setPos(this.position.x, this.position.y, z);
    }

    @Override
    public Set<String> tags() {
        return this.tags;
    }

    @Override
    public boolean hasTag(String tag) {
        return this.tags.contains(tag);
    }

    @Nullable
    @Override
    public CustomData getCustomData() {
        return this.customData != CustomData.EMPTY ? this.customData : null;
    }

    @Override
    public CustomData getCustomDataOrEmpty() {
        return this.customData;
    }

    @Override
    public void setCustomData(CustomData customData) {
        this.customData = customData;
    }
}
