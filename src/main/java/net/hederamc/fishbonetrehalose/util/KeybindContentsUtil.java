package net.hederamc.fishbonetrehalose.util;

import net.minecraft.network.chat.contents.KeybindContents;

public final class KeybindContentsUtil {
    private KeybindContentsUtil() {
    }

    public static KeybindContents fromName(String name) {
        return new KeybindContents(name);
    }
}
