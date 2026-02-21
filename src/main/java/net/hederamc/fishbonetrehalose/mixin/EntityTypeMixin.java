package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.IdHolder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityType.class)
public abstract class EntityTypeMixin implements IdHolder {
    @Override
    public Identifier id() {
        return BuiltInRegistries.ENTITY_TYPE.getKey(((EntityType<?>)(Object)this));
    }
}
