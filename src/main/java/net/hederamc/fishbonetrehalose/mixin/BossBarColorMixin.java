package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.ChatFormattingHolder;
import net.minecraft.world.BossEvent.BossBarColor;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BossBarColor.class)
public abstract class BossBarColorMixin implements ChatFormattingHolder {
}
