package net.hederamc.fishbonetrehalose.util;

import com.mojang.brigadier.Message;
import java.net.URI;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.commands.arguments.NbtPathArgument.NbtPath;
import net.minecraft.commands.arguments.selector.EntitySelector;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.data.DataSource;
import net.minecraft.network.chat.contents.objects.ObjectInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.util.CompilableString;
import net.minecraft.world.level.ChunkPos;
import org.jspecify.annotations.Nullable;

public final class Text {
    private Text() {
    }

    public static MutableComponent fromContents(ComponentContents contents) {
        return MutableComponentUtil.fromContents(contents);
    }

    public static MutableComponent fromEmpty() {
        return MutableComponentUtil.fromEmpty();
    }

    public static MutableComponent fromString(String string) {
        return MutableComponentUtil.fromString(string);
    }

    public static MutableComponent fromTranslatable(String key) {
        return MutableComponentUtil.fromTranslatable(key);
    }

    public static MutableComponent fromTranslatable(String key, Object... args) {
        return MutableComponentUtil.fromTranslatable(key, args);
    }

    public static MutableComponent fromTranslatableEscape(String key, Object... args) {
        return MutableComponentUtil.fromTranslatableEscape(key, args);
    }

    public static MutableComponent fromTranslatableWithFallback(String key, @Nullable String fallback) {
        return MutableComponentUtil.fromTranslatableWithFallback(key, fallback);
    }

    public static MutableComponent fromTranslatableWithFallback(String key, @Nullable String fallback, Object... args) {
        return MutableComponentUtil.fromTranslatableWithFallback(key, fallback, args);
    }

    public static MutableComponent fromKeybind(String name) {
        return MutableComponentUtil.fromKeybind(name);
    }

    public static MutableComponent fromNbt(CompilableString<NbtPath> nbtPath, boolean interpreting, boolean plain,
            Optional<Component> separator, DataSource dataSource) {
        return MutableComponentUtil.fromNbt(nbtPath, interpreting, plain, separator, dataSource);
    }

    public static MutableComponent fromScore(CompilableString<EntitySelector> pattern, String objective) {
        return MutableComponentUtil.fromScore(pattern, objective);
    }

    public static MutableComponent fromScore(String name, String objective) {
        return MutableComponentUtil.fromScore(name, objective);
    }

    public static MutableComponent fromSelector(CompilableString<EntitySelector> pattern, Optional<Component> separator) {
        return MutableComponentUtil.fromSelector(pattern, separator);
    }

    public static MutableComponent fromObject(ObjectInfo info) {
        return MutableComponentUtil.fromObject(info);
    }

    public static MutableComponent fromDate(Date date) {
        return MutableComponentUtil.fromDate(date);
    }

    public static MutableComponent fromMessage(Message message) {
        return MutableComponentUtil.fromMessage(message);
    }

    public static MutableComponent fromUuid(UUID uuid) {
        return MutableComponentUtil.fromUuid(uuid);
    }

    public static MutableComponent fromId(Identifier id) {
        return MutableComponentUtil.fromId(id);
    }

    public static MutableComponent fromChunkPos(ChunkPos chunkPos) {
        return MutableComponentUtil.fromChunkPos(chunkPos);
    }

    public static MutableComponent fromUri(URI uri) {
        return MutableComponentUtil.fromUri(uri);
    }
}
