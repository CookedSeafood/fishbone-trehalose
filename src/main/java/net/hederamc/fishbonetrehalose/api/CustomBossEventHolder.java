package net.hederamc.fishbonetrehalose.api;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.bossevents.CustomBossEvent;
import net.minecraft.util.RandomSource;
import org.jspecify.annotations.Nullable;

public interface CustomBossEventHolder {
    default boolean contains(Identifier id) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    default CustomBossEvent get(Identifier id) {
        throw new UnsupportedOperationException();
    }

    default CustomBossEvent create(RandomSource random, Identifier id, Component name) {
        throw new UnsupportedOperationException();
    }

    default CustomBossEvent getOrCreate(RandomSource random, Identifier id, Component displayName) {
        CustomBossEvent event = this.get(id);

        if (event == null) {
            event = this.create(random, id, displayName);
        }

        return event;
    }

    @Nullable
    default CustomBossEvent remove(Identifier id) {
        throw new UnsupportedOperationException();
    }

    default void remove(CustomBossEvent event) {
        throw new UnsupportedOperationException();
    }
}
