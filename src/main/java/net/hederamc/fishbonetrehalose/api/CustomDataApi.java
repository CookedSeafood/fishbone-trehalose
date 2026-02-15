package net.hederamc.fishbonetrehalose.api;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.component.CustomData;

public interface CustomDataApi {
    default CompoundTag getTag() {
        throw new UnsupportedOperationException();
    }

    default CustomData merge(CustomData other) {
        throw new UnsupportedOperationException();
    }
}
