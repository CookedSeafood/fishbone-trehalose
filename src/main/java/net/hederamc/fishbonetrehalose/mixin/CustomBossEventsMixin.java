package net.hederamc.fishbonetrehalose.mixin;

import java.util.Map;
import net.hederamc.fishbonetrehalose.api.CustomBossEventHolder;
import net.minecraft.resources.Identifier;
import net.minecraft.server.bossevents.CustomBossEvent;
import net.minecraft.server.bossevents.CustomBossEvents;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CustomBossEvents.class)
public abstract class CustomBossEventsMixin implements CustomBossEventHolder {
    @Shadow private Map<Identifier, CustomBossEvent> events;

    @Override
    public boolean contains(Identifier id) {
        return this.events.containsKey(id);
    }

    @Nullable
    @Override
    public CustomBossEvent remove(Identifier id) {
        CustomBossEvent event = this.events.remove(id);

        if (event == null) {
            return null;
        }

        ((CustomBossEvents)(Object)this).setDirty();
        return event;
    }
}
