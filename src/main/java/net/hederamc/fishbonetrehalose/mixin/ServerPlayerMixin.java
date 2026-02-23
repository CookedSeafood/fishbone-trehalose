package net.hederamc.fishbonetrehalose.mixin;

import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends PlayerMixin {
    @Override
    public void setExperience(int experience) {
        this.setExperiencePoints(experience);
    }

    @Shadow
    public abstract void setExperiencePoints(int amount);
}
