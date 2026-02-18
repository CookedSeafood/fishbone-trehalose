package net.hederamc.fishbonetrehalose.util;

import java.util.Arrays;
import net.minecraft.ChatFormatting;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;

public final class BossEvents {
    private BossEvents() {
    }

    public final class BossBarColors {
        private BossBarColors() {
        }

        public static String getName(ChatFormatting format) {
            return Arrays.stream(BossBarColor.values())
                    .filter(color -> color.getFormatting().equals(format))
                    .map(color -> color.getName())
                    .findAny()
                    .orElse("");
        }

        public static ChatFormatting getFormatting(String name) {
            return Arrays.stream(BossBarColor.values())
                    .filter(color -> color.getName().equals(name))
                    .map(color -> color.getFormatting())
                    .findAny()
                    .orElse(ChatFormatting.RESET);
        }

        public static BossBarColor byName(String name) {
            return Arrays.stream(BossBarColor.values())
                    .filter(color -> color.getName().equals(name))
                    .findAny()
                    .get();
        }

        public static BossBarColor byFormatting(ChatFormatting format) {
            return Arrays.stream(BossBarColor.values())
                    .filter(color -> color.getFormatting().equals(format))
                    .findAny()
                    .get();
        }
    }

    public final class BossBarOverlays {
        private BossBarOverlays() {
        }

        public static BossBarOverlay byName(String name) {
            return Arrays.stream(BossBarOverlay.values())
                    .filter(style -> style.getName().equals(name))
                    .findAny()
                    .get();
        }
    }
}
