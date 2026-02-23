package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.item.Rarity;

public interface RarityHolder {
    default Rarity getRarity() {
        throw new UnsupportedOperationException();
    }

    default void setRarity(Rarity rarity) {
        throw new UnsupportedOperationException();
    }
}
