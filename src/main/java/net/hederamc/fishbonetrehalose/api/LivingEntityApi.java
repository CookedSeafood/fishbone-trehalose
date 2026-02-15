package net.hederamc.fishbonetrehalose.api;

import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.List;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.scores.ScoreHolder;

public interface LivingEntityApi {
    default List<Entry<Holder<Enchantment>>> getEnchantments(ResourceKey<Enchantment> key) {
        throw new UnsupportedOperationException();
    }

    default List<Entry<Holder<Enchantment>>> getEnchantments() {
        throw new UnsupportedOperationException();
    }

    default boolean isDead() {
        throw new UnsupportedOperationException();
    }

    default void setDead(boolean dead) {
        throw new UnsupportedOperationException();
    }

    default float getYBodyRot(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default float getYHeadRot(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    default ScoreHolder getScoreHolder() {
        throw new UnsupportedOperationException();
    }
}
