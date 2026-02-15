package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.ItemStackApi;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements ItemStackApi {
    @Nullable
    @Override
    public CustomData getCustomData() {
        return ((ItemStack)(Object)this).get(DataComponents.CUSTOM_DATA);
    }

    @Override
    public CustomData getOrCreateCustomData() {
        CustomData customData = this.getCustomData();

        if (customData == null) {
            customData = new CustomData(new CompoundTag());
            this.setCustomData(customData);
        }

        return customData;
    }

    @Override
    public void setCustomData(CustomData customData) {
        this.set(DataComponents.CUSTOM_DATA, customData);
    }

    @Nullable
    @Shadow
    public abstract <T> T set(DataComponentType<T> type, @Nullable T value);
}
