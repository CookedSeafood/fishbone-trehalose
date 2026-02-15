package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.ItemApi;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.class)
public abstract class ItemMixin implements ItemApi {
    @Shadow private Holder.Reference<Item> builtInRegistryHolder;

    @Override
    public Holder.Reference<Item> getRegistryHolder() {
        return this.builtInRegistryHolder;
    }

    @Override
    public Identifier getId() {
        return this.builtInRegistryHolder.unwrapKey().get().identifier();
    }

    @Override
    public DataComponentMap getComponents() {
        return this.builtInRegistryHolder.components();
    }
}
