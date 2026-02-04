package net.hederamc.fishbonetrehalose.mixin;

import java.util.Map;
import net.hederamc.fishbonetrehalose.api.CustomBossEventsApi;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.bossevents.CustomBossEvent;
import net.minecraft.server.bossevents.CustomBossEvents;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CustomBossEvents.class)
public abstract class CustomBossEventsMixin implements CustomBossEventsApi {
    @Shadow
    private Map<Identifier, CustomBossEvent> events;

    @Override
    public CustomBossEvent getOrCreate(RandomSource random, Identifier id, Component displayName) {
        CustomBossEvent event = this.get(id);
        if (event == null) {
            event = this.create(random, id, displayName);
        }

        return event;
    }

    @Override
    public boolean containsKey(Identifier id) {
        return this.events.containsKey(id);
    }

    @Override
    public void remove(Identifier id) {
        this.events.remove(id);
    }

    @Shadow
    public abstract CustomBossEvent get(Identifier id);

    @Shadow
    public abstract CustomBossEvent create(RandomSource random, Identifier id, Component displayName);
}
