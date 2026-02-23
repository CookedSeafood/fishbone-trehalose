package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.CustomDataHolder;
import net.hederamc.fishbonetrehalose.api.RarityHolder;
import net.minecraft.core.component.DataComponentHolder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.CustomData;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements RarityHolder, CustomDataHolder, DataComponentHolder {
    @Override
    public void setRarity(Rarity rarity) {
        this.set(DataComponents.RARITY, rarity);
    }

    @Nullable
    @Override
    public CustomData getCustomData() {
        return this.get(DataComponents.CUSTOM_DATA);
    }

    @Override
    public void setCustomData(CustomData customData) {
        this.set(DataComponents.CUSTOM_DATA, customData);
    }

    @Nullable
    @Shadow
    public abstract <T> T set(DataComponentType<T> type, @Nullable T value);
}
