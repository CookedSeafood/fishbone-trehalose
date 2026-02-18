package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.IdHolder;
import net.minecraft.core.Holder.Reference;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Reference.class)
public abstract class ReferenceMixin<T> implements IdHolder {
    @Override
    public Identifier id() {
        return this.key().identifier();
    }

    @Shadow
    public abstract ResourceKey<T> key();
}
