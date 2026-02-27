package net.hederamc.fishbonetrehalose.util;

import net.minecraft.ChatFormatting;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;
import org.jspecify.annotations.Nullable;

public final class BossEvents {
    private BossEvents() {
    }

    public final class BossBarColors {
        private BossBarColors() {
        }

        @Nullable
        public static BossBarColor byName(String name) {
            for (BossBarColor color : BossBarColor.values()) {
                if (color.getName().equals(name)) {
                    return color;
                }
            }

            return null;
        }

        @Nullable
        public static BossBarColor byFormatting(ChatFormatting formatting) {
            for (BossBarColor color : BossBarColor.values()) {
                if (color.getFormatting().equals(formatting)) {
                    return color;
                }
            }

            return null;
        }
    }

    public final class BossBarOverlays {
        private BossBarOverlays() {
        }

        @Nullable
        public static BossBarOverlay byName(String name) {
            for (BossBarOverlay overlay : BossBarOverlay.values()) {
                if (overlay.getName().equals(name)) {
                    return overlay;
                }
            }

            return null;
        }
    }
}
