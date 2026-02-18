package net.hederamc.fishbonetrehalose.api;

import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

public interface EnchantmentsHolder {
    default List<Entry<Holder<Enchantment>>> getEnchantments(ResourceKey<Enchantment> key) {
        throw new UnsupportedOperationException();
    }

    default List<Entry<Holder<Enchantment>>> getEnchantments() {
        throw new UnsupportedOperationException();
    }
}
