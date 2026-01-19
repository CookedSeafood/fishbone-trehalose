package net.hederamc.fishbonetrehalose.mixin;

import net.hederamc.fishbonetrehalose.api.CustomDataApi;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.component.CustomData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CustomData.class)
public abstract class CustomDataMixin implements CustomDataApi {
    @Override
    public CustomData merge(CustomData other) {
        return CustomData.of(this.copyTag().merge(other.copyTag()));
    }

    @Shadow
    public abstract CompoundTag copyTag();
}
