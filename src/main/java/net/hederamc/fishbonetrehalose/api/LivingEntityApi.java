package net.hederamc.fishbonetrehalose.api;

import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.scores.ScoreHolder;

public interface LivingEntityApi {
    default List<Entry<Holder<Enchantment>>> getEnchantments(ResourceKey<Enchantment> key) {
        return null;
    }

    default List<Entry<Holder<Enchantment>>> getEnchantments() {
        return null;
    }

    default void setDead(boolean dead) {
    }

    default float getYBodyRot(float partialTickTime) {
        return 0.0f;
    }

    default float getYHeadRot(float partialTickTime) {
        return 0.0f;
    }

    default ScoreHolder getScoreHolder() {
        return null;
    }
}
