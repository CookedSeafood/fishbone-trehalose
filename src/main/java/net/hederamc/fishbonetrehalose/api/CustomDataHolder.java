package net.hederamc.fishbonetrehalose.api;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.component.CustomData;
import org.jspecify.annotations.Nullable;

public interface CustomDataHolder {
    @Nullable
    default CustomData getCustomData() {
        throw new UnsupportedOperationException();
    }

    default CustomData getCustomDataOrEmpty() {
        CustomData customData = this.getCustomData();

        if (customData == null) {
            return CustomData.EMPTY;
        }

        return customData;
    }

    default CustomData getOrCreateCustomData() {
        CustomData customData = this.getCustomData();

        if (customData == null) {
            customData = new CustomData(new CompoundTag());
            this.setCustomData(customData);
        }

        return customData;
    }

    default void setCustomData(CustomData customData) {
        throw new UnsupportedOperationException();
    }
}
