package net.hederamc.fishbonetrehalose.api;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.bossevents.CustomBossEvent;

public interface CustomBossEventsApi {
    default CustomBossEvent getOrCreate(Identifier id, Component displayName) {
        return null;
    }

    default boolean containsKey(Identifier id) {
        return false;
    }

    default void remove(Identifier id) {
    }
}
