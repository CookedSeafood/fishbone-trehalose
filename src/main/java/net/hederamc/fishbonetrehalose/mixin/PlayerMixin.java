package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.ExperienceHolder;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Player.class)
public abstract class PlayerMixin implements ExperienceHolder {
    @Shadow public int totalExperience;

    @Override
    public int getExperience() {
        return this.totalExperience;
    }
}
