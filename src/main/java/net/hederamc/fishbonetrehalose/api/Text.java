package net.hederamc.fishbonetrehalose.api;

import java.util.Optional;
import java.util.function.UnaryOperator;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;

public interface Text extends FormattedText {
    default ComponentContents getContents() {
        throw new UnsupportedOperationException();
    }

    default Style getStyle() {
        throw new UnsupportedOperationException();
    }

    default void setStyle(Style style) {
        throw new UnsupportedOperationException();
    }

    default Text withStyle(Style style) {
        this.setStyle(style);
        return this;
    }

    default Text withStyle(UnaryOperator<Style> updater) {
        return this.withStyle(updater.apply(this.getStyle()));
    }

    default FormattedCharSequence getVisualOrderText() {
        throw new UnsupportedOperationException();
    }

    @Override
    default <T> Optional<T> visit(ContentConsumer<T> output) {
        return this.getContents().visit(output);
    }

    @Override
    default <T> Optional<T> visit(StyledContentConsumer<T> output, Style parentStyle) {
        Style selfStyle = this.getStyle().applyTo(parentStyle);
        return this.getContents().visit(output, selfStyle);
    }

    default boolean equals(Text text) {
        return this == text ? true : this.getContents().equals(text.getContents()) && this.getStyle().equals(text.getStyle());
    }

    default <T extends Text> T copy() {
        throw new UnsupportedOperationException();
    }

    default <T extends Text> T deepCopy() {
        throw new UnsupportedOperationException();
    }
}
