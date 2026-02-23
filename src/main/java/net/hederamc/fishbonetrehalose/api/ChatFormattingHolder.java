package net.hederamc.fishbonetrehalose.api;

import net.minecraft.ChatFormatting;

public interface ChatFormattingHolder {
    default ChatFormatting getFormatting() {
        throw new UnsupportedOperationException();
    }

    default void setFormatting(ChatFormatting formatting) {
        throw new UnsupportedOperationException();
    }
}
