package net.hederamc.fishbonetrehalose.mixin;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import net.hederamc.fishbonetrehalose.api.Text;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MutableComponent.class)
public abstract class MutableComponentMixin implements Component, Text {
    @Shadow private ComponentContents contents;
    @Shadow private List<Component> siblings;
    @Shadow private Style style;
    @Shadow private FormattedCharSequence visualOrderText;
    @Shadow private Language decomposedWith;

    @Override
    @SuppressWarnings("unchecked")
    public List<Text> getTexts() {
        return (List<Text>) (List<?>) this.siblings;
    }

    @Override
    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public MutableComponent copy() {
        return new MutableComponent(this.contents, new ArrayList<>(this.siblings), this.style);
    }

    @Override
    public MutableComponent deepCopy() {
        return new MutableComponent(
                this.contents,
                this.siblings.stream()
                        .map(MutableComponent.class::cast)
                        .map(Text.class::cast)
                        .map(mutableText -> mutableText.deepCopy())
                        .map(MutableComponent.class::cast)
                        .collect(Collectors.toList()),
                this.style);
    }

    @Override
    public String getString() {
        return Component.super.getString();
    }

    @Override
    @Shadow
    public abstract ComponentContents getContents();

    @Override
    @Shadow
    public abstract Style getStyle();

    @Override
    @Shadow
    public abstract MutableComponent withStyle(Style style);

    @Override
    @Shadow
    public abstract MutableComponent withStyle(UnaryOperator<Style> updater);

    @Override
    @Shadow
    public abstract FormattedCharSequence getVisualOrderText();
}
