package net.hederamc.fishbonetrehalose.api;

import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public interface ItemApi {
    default Identifier getId() {
        return null;
    }

    default Holder.Reference<Item> getRegistryHolder() {
        return null;
    }
}
