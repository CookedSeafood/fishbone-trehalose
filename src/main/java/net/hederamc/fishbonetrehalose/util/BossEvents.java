package net.hederamc.fishbonetrehalose.util;

import java.util.Arrays;
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
            return Arrays.stream(BossBarColor.values())
                    .filter(color -> color.getName().equals(name))
                    .findAny()
                    .orElse(null);
        }

        @Nullable
        public static BossBarColor byFormatting(ChatFormatting formatting) {
            return Arrays.stream(BossBarColor.values())
                    .filter(color -> color.getFormatting().equals(formatting))
                    .findAny()
                    .orElse(null);
        }
    }

    public final class BossBarOverlays {
        private BossBarOverlays() {
        }

        @Nullable
        public static BossBarOverlay byName(String name) {
            return Arrays.stream(BossBarOverlay.values())
                    .filter(style -> style.getName().equals(name))
                    .findAny()
                    .orElse(null);
        }
    }
}
