package net.hederamc.fishbonetrehalose.api;

import com.mojang.brigadier.Message;
import java.net.URI;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.function.UnaryOperator;
import net.hederamc.fishbonetrehalose.util.MutableComponentUtil;
import net.minecraft.commands.arguments.NbtPathArgument.NbtPath;
import net.minecraft.commands.arguments.selector.EntitySelector;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.contents.data.DataSource;
import net.minecraft.network.chat.contents.objects.ObjectInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.util.CompilableString;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.ChunkPos;
import org.jspecify.annotations.Nullable;

public interface Text extends Message, FormattedText {
    @Override
    default String getString() {
        return FormattedText.super.getString();
    }

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
        return this == text ? true
                : this.getContents().equals(text.getContents()) && this.getStyle().equals(text.getStyle());
    }

    default <T extends Text> T copy() {
        throw new UnsupportedOperationException();
    }

    default <T extends Text> T deepCopy() {
        throw new UnsupportedOperationException();
    }

    // ========== static methods ==========

    static MutableComponent literal(String string) {
        return MutableComponentUtil.literal(string);
    }

    static MutableComponent fromContents(ComponentContents contents) {
        return MutableComponentUtil.fromContents(contents);
    }

    static MutableComponent fromEmpty() {
        return MutableComponentUtil.fromEmpty();
    }

    static MutableComponent fromString(String string) {
        return MutableComponentUtil.fromString(string);
    }

    static MutableComponent fromTranslatable(String key) {
        return MutableComponentUtil.fromTranslatable(key);
    }

    static MutableComponent fromTranslatable(String key, Object... args) {
        return MutableComponentUtil.fromTranslatable(key, args);
    }

    static MutableComponent fromTranslatableEscape(String key, Object... args) {
        return MutableComponentUtil.fromTranslatableEscape(key, args);
    }

    static MutableComponent fromTranslatableWithFallback(String key, @Nullable String fallback) {
        return MutableComponentUtil.fromTranslatableWithFallback(key, fallback);
    }

    static MutableComponent fromTranslatableWithFallback(String key, @Nullable String fallback, Object... args) {
        return MutableComponentUtil.fromTranslatableWithFallback(key, fallback, args);
    }

    static MutableComponent fromKeybind(String name) {
        return MutableComponentUtil.fromKeybind(name);
    }

    static MutableComponent fromNbt(CompilableString<NbtPath> nbtPath, boolean interpreting, boolean plain,
            Optional<Component> separator, DataSource dataSource) {
        return MutableComponentUtil.fromNbt(nbtPath, interpreting, plain, separator, dataSource);
    }

    static MutableComponent fromScore(CompilableString<EntitySelector> pattern, String objective) {
        return MutableComponentUtil.fromScore(pattern, objective);
    }

    static MutableComponent fromScore(String name, String objective) {
        return MutableComponentUtil.fromScore(name, objective);
    }

    static MutableComponent fromSelector(CompilableString<EntitySelector> pattern, Optional<Component> separator) {
        return MutableComponentUtil.fromSelector(pattern, separator);
    }

    static MutableComponent fromObject(ObjectInfo info) {
        return MutableComponentUtil.fromObject(info);
    }

    static MutableComponent fromDate(Date date) {
        return MutableComponentUtil.fromDate(date);
    }

    static MutableComponent fromMessage(Message message) {
        return MutableComponentUtil.fromMessage(message);
    }

    static MutableComponent fromUuid(UUID uuid) {
        return MutableComponentUtil.fromUuid(uuid);
    }

    static MutableComponent fromId(Identifier id) {
        return MutableComponentUtil.fromId(id);
    }

    static MutableComponent fromChunkPos(ChunkPos chunkPos) {
        return MutableComponentUtil.fromChunkPos(chunkPos);
    }

    static MutableComponent fromUri(URI uri) {
        return MutableComponentUtil.fromUri(uri);
    }
}
