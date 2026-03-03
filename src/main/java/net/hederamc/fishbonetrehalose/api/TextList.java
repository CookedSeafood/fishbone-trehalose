package net.hederamc.fishbonetrehalose.api;

import com.mojang.brigadier.Message;
import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;
import net.hederamc.fishbonetrehalose.util.MutableComponentUtil;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;

public interface TextList extends Message, FormattedText {
    @Override
    default String getString() {
        return FormattedText.super.getString();
    }

    default Text toText() {
        return this.isEmpty() ? Text.fromEmpty()
                : ((Text) Text.fromString(this.getString())).withStyle(this.getFirstStyle());
    }

    default TextList append(String string) {
        return string.isEmpty() ? this : this.append(Text.fromString(string));
    }

    default TextList append(Text text) {
        this.add(text);
        return this;
    }

    default Style getFirstStyle() {
        return this.getTexts().getFirst().getStyle();
    }

    default void setStyle(Style style) {
        for (Text text : this.getTexts()) {
            text.setStyle(style);
        }
    }

    default TextList withStyle(Style style) {
        this.setStyle(style);
        return this;
    }

    default TextList withStyle(UnaryOperator<Style> updater) {
        for (Text text : this.getTexts()) {
            text.setStyle(updater.apply(text.getStyle()));
        }

        return this;
    }

    default FormattedCharSequence getVisualOrderText() {
        throw new UnsupportedOperationException();
    }

    default List<Text> getTexts() {
        throw new UnsupportedOperationException();
    }

    default int size() {
        return this.getTexts().size();
    }

    default boolean isEmpty() {
        return this.getTexts().isEmpty();
    }

    default boolean add(Text text) {
        return this.getTexts().add(text);
    }

    default void clear() {
        this.getTexts().clear();
    }

    @Override
    default <T> Optional<T> visit(ContentConsumer<T> output) {
        for (Text text : this.getTexts()) {
            Optional<T> result = text.getContents().visit(output);
            if (result.isPresent()) {
                return result;
            }
        }

        return Optional.empty();
    }

    @Override
    default <T> Optional<T> visit(StyledContentConsumer<T> output, Style parentStyle) {
        for (Text text : this.getTexts()) {
            Optional<T> result = text.getContents().visit(output, parentStyle);
            if (result.isPresent()) {
                return result;
            }
        }

        return Optional.empty();
    }

    default boolean equals(TextList list) {
        return this == list ? true : this.getTexts().equals(list.getTexts());
    }

    default TextList copy() {
        throw new UnsupportedOperationException();
    }

    default TextList deepCopy() {
        throw new UnsupportedOperationException();
    }

    // ========== static methods ==========

    static MutableComponent fromEmpty() {
        return MutableComponentUtil.fromEmpty();
    }

    static MutableComponent fromList(List<Text> list) {
        return MutableComponentUtil.fromList(list);
    }
}
