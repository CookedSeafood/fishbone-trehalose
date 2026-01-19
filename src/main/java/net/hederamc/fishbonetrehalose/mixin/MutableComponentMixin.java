package net.hederamc.fishbonetrehalose.mixin;

import java.util.List;
import java.util.stream.Collectors;
import net.hederamc.fishbonetrehalose.api.MutableComponentApi;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MutableComponent.class)
public abstract class MutableComponentMixin implements MutableComponentApi {
    @Override
    public Component deepCopy() {
        return new MutableComponent(
            this.getContents(),
            this.getSiblings().stream()
                .map(MutableComponent.class::cast)
                .map(mutableText -> mutableText.deepCopy())
                .collect(Collectors.toList()),
            this.getStyle()
        );
    }

    @Shadow
    public abstract ComponentContents getContents();

    @Shadow
    public abstract List<Component> getSiblings();

    @Shadow
    public abstract Style getStyle();
}
