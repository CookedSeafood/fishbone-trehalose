package net.hederamc.fishbonetrehalose.api;

import net.minecraft.resources.Identifier;

public interface IdHolder {
    default Identifier id() {
        throw new UnsupportedOperationException();
    }
}
