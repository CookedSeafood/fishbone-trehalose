package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.item.component.CustomData;

public interface ItemStackApi {
    default CustomData getCustomData() {
        throw new UnsupportedOperationException();
    }

    default CustomData getOrCreateCustomData() {
        throw new UnsupportedOperationException();
    }

    default void setCustomData(CustomData customData) {
        throw new UnsupportedOperationException();
    }
}
