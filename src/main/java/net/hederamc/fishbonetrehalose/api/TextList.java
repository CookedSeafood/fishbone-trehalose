package net.hederamc.fishbonetrehalose.api;

import com.mojang.brigadier.Message;
import java.util.List;
import java.util.Optional;
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

    default List<Text> getTexts() {
        throw new UnsupportedOperationException();
    }

    default TextList append(String string) {
        return string.isEmpty() ? this : this.append(Text.fromString(string));
    }

    default TextList append(Text text) {
        this.getTexts().add(text);
        return this;
    }

    default FormattedCharSequence getVisualOrderText() {
        throw new UnsupportedOperationException();
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

    default <T extends TextList> T copy() {
        throw new UnsupportedOperationException();
    }

    default <T extends TextList> T deepCopy() {
        throw new UnsupportedOperationException();
    }

    // ========== static methods ==========

    static MutableComponent fromEmpty() {
        return MutableComponentUtil.fromEmpty();
    }
}
