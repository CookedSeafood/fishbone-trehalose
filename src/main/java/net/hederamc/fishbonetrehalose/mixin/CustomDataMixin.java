package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.CompoundTagHolder;
import net.hederamc.fishbonetrehalose.api.CustomDataApi;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.component.CustomData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CustomData.class)
public abstract class CustomDataMixin implements CompoundTagHolder, CustomDataApi {
    @Shadow private CompoundTag tag;

    @Override
    public CompoundTag getTag() {
        return this.tag;
    }

    @Override
    public CustomData merge(CustomData other) {
        this.tag.merge(other.getTag());
        return ((CustomData)(Object)this);
    }
}
