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
    @Shadow private ComponentContents contents;
    @Shadow private List<Component> siblings;
    @Shadow private Style style;

    @Override
    public Component deepCopy() {
        return new MutableComponent(
            this.contents,
            this.siblings.stream()
                .map(MutableComponent.class::cast)
                .map(mutableText -> mutableText.deepCopy())
                .collect(Collectors.toList()),
            this.style
        );
    }
}
