package net.hederamc.fishbonetrehalose.util;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import org.jspecify.annotations.Nullable;

public final class Rarities {
    private Rarities() {
    }

    @Nullable
    public static Rarity byName(String name) {
        for (Rarity rarity : Rarity.values()) {
            if (rarity.getSerializedName().equals(name)) {
                return rarity;
            }
        }

        return null;
    }

    @Nullable
    public static Rarity byFormatting(ChatFormatting formatting) {
        for (Rarity rarity : Rarity.values()) {
            if (rarity.getFormatting().equals(formatting)) {
                return rarity;
            }
        }

        return null;
    }
}
