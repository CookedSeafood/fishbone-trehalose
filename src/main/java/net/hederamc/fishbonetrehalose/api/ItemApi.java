package net.hederamc.fishbonetrehalose.api;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public interface ItemApi {
    default Holder.Reference<Item> getRegistryHolder() {
        throw new UnsupportedOperationException();
    }

    default Identifier getId() {
        throw new UnsupportedOperationException();
    }

    default DataComponentMap getComponents() {
        throw new UnsupportedOperationException();
    }
}
