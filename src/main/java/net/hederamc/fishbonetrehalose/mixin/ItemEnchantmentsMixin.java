package net.hederamc.fishbonetrehalose.mixin;

import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.Optional;
import java.util.Set;
import net.hederamc.fishbonetrehalose.api.ItemEnchantmentsApi;
import net.minecraft.core.Holder;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ItemEnchantments.class)
public abstract class ItemEnchantmentsMixin implements ItemEnchantmentsApi {
    @Override
    public int getLevel(String enchantment) {
        Optional<Entry<Holder<Enchantment>>> matchedEnchantment = this.entrySet()
            .stream()
            .filter(presentedEnchantment -> presentedEnchantment.getKey().getRegisteredName().equals(enchantment))
            .findAny();
        return matchedEnchantment.isPresent() ? matchedEnchantment.get().getIntValue() : 0;
    }

    @Shadow
    public abstract Set<Entry<Holder<Enchantment>>> entrySet();
}
