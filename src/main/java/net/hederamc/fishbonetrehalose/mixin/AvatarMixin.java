package net.hederamc.fishbonetrehalose.mixin;

import net.minecraft.world.entity.Avatar;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Avatar.class)
public abstract class AvatarMixin extends LivingEntityMixin {
}
