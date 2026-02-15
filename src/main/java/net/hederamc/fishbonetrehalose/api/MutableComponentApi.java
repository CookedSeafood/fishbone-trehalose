package net.hederamc.fishbonetrehalose.api;

import net.minecraft.network.chat.Component;

public interface MutableComponentApi {
    default Component deepCopy() {
        throw new UnsupportedOperationException();
    }
}
