package net.hederamc.fishbonetrehalose.util;

import java.util.Arrays;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import org.jspecify.annotations.Nullable;

public final class Rarities {
    private Rarities() {
    }

    @Nullable
    public static Rarity byName(String name) {
        return Arrays.stream(Rarity.values())
                .filter(rarity -> rarity.getSerializedName().equals(name))
                .findAny()
                .orElse(null);
    }

    @Nullable
    public static Rarity byFormatting(ChatFormatting formatting) {
        return Arrays.stream(Rarity.values())
                .filter(rarity -> rarity.getFormatting().equals(formatting))
                .findAny()
                .orElse(null);
    }
}
