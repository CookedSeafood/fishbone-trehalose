package net.hederamc.fishbonetrehalose.api;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.bossevents.CustomBossEvent;
import net.minecraft.util.RandomSource;

public interface CustomBossEventsApi {
    default CustomBossEvent getOrCreate(RandomSource random, Identifier id, Component displayName) {
        throw new UnsupportedOperationException();
    }

    default boolean containsKey(Identifier id) {
        throw new UnsupportedOperationException();
    }

    default void remove(Identifier id) {
        throw new UnsupportedOperationException();
    }
}
