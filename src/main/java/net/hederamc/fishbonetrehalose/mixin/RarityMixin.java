package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.ChatFormattingHolder;
import net.hederamc.fishbonetrehalose.api.NetworkIdHolder;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Rarity.class)
public abstract class RarityMixin implements NetworkIdHolder, ChatFormattingHolder {
    @Shadow private int id;
    @Shadow private ChatFormatting color;

    @Override
    public int getNetworkId() {
        return this.id;
    }

    @Override
    public ChatFormatting getFormatting() {
        return this.color;
    }
}
