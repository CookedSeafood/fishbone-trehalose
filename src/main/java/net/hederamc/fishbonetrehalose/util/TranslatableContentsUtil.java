package net.hederamc.fishbonetrehalose.util;

import net.minecraft.network.chat.contents.TranslatableContents;

public final class TranslatableContentsUtil {
    private TranslatableContentsUtil() {
    }

    public static TranslatableContents fromKey(String key) {
        return new TranslatableContents(key, null, TranslatableContents.NO_ARGS);
    }
}
