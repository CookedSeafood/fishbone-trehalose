package net.hederamc.fishbonetrehalose.api;

import net.minecraft.world.item.component.CustomData;

public interface CustomDataApi {
    default CustomData merge(CustomData other) {
        return null;
    }
}
