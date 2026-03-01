package net.hederamc.fishbonetrehalose.util;

import net.minecraft.network.chat.contents.PlainTextContents;

public final class PlainTextContentsUtil {
    private PlainTextContentsUtil() {
    }

    public static PlainTextContents fromString(String string) {
        return string.isEmpty() ? PlainTextContents.EMPTY : new PlainTextContents.LiteralContents(string);
    }
}
