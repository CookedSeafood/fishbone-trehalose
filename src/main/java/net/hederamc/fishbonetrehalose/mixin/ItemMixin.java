package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.IdHolder;
import net.minecraft.core.Holder.Reference;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Item.class)
public abstract class ItemMixin implements IdHolder {
    @Shadow private Reference<Item> builtInRegistryHolder;

    @Override
    public Identifier getId() {
        return this.builtInRegistryHolder.getId();
    }
}
