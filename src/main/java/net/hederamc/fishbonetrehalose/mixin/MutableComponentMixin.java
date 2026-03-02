package net.hederamc.fishbonetrehalose.mixin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import net.hederamc.fishbonetrehalose.api.Text;
import net.hederamc.fishbonetrehalose.api.TextList;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(MutableComponent.class)
public abstract class MutableComponentMixin implements Component, Text, TextList {
    @Shadow private ComponentContents contents;
    @Shadow private List<Component> siblings;
    @Shadow private Style style;
    @Shadow private FormattedCharSequence visualOrderText;
    @Shadow private Language decomposedWith;

    // Text ----------------------------------------------------------------------

    @Override
    public void setStyle(Style style) {
        this.style = style;
    }

    // TextList ------------------------------------------------------------------

    @Override
    @SuppressWarnings("unchecked")
    public List<Text> getTexts() {
        return (List<Text>) (List<?>) this.siblings;
    }

    @Override
    @SuppressWarnings("unchecked")
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

    // General -------------------------------------------------------------------

    @Override
    @SuppressWarnings("unchecked")
    public MutableComponent copy() {
        return new MutableComponent(this.contents, new ArrayList<>(this.siblings), this.style);
    }

    @Override
    public <T> Optional<T> visit(ContentConsumer<T> output) {
        return Component.super.visit(output);
    }

    @Override
    public <T> Optional<T> visit(StyledContentConsumer<T> output, Style parentStyle) {
        return Component.super.visit(output, parentStyle);
    }

    @Override
    @Shadow
    public abstract ComponentContents getContents();

    @Override
    @Shadow
    public abstract Style getStyle();

    @Override
    @Shadow
    public abstract FormattedCharSequence getVisualOrderText();
}
