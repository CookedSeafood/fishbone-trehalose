package net.hederamc.fishbonetrehalose.util;

import com.mojang.brigadier.Message;
import java.net.URI;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import net.hederamc.fishbonetrehalose.api.Text;
import net.minecraft.commands.arguments.NbtPathArgument.NbtPath;
import net.minecraft.commands.arguments.selector.EntitySelector;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.contents.data.DataSource;
import net.minecraft.network.chat.contents.objects.ObjectInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.util.CompilableString;
import net.minecraft.world.level.ChunkPos;
import org.jspecify.annotations.Nullable;

public final class Texts {
    private Texts() {
    }

    public static Text fromContents(ComponentContents contents) {
        return MutableComponentUtil.fromContents(contents);
    }

    public static Text fromEmpty() {
        return MutableComponentUtil.fromEmpty();
    }

    public static Text fromString(String string) {
        return MutableComponentUtil.fromString(string);
    }

    public static Text fromTranslatable(String key) {
        return MutableComponentUtil.fromTranslatable(key);
    }

    public static Text fromTranslatable(String key, Object... args) {
        return MutableComponentUtil.fromTranslatable(key, args);
    }

    public static Text fromTranslatableEscape(String key, Object... args) {
        return MutableComponentUtil.fromTranslatableEscape(key, args);
    }

    public static Text fromTranslatableWithFallback(String key, @Nullable String fallback) {
        return MutableComponentUtil.fromTranslatableWithFallback(key, fallback);
    }

    public static Text fromTranslatableWithFallback(String key, @Nullable String fallback, Object... args) {
        return MutableComponentUtil.fromTranslatableWithFallback(key, fallback, args);
    }

    public static Text fromKeybind(String name) {
        return MutableComponentUtil.fromKeybind(name);
    }

    public static Text fromNbt(CompilableString<NbtPath> nbtPath, boolean interpreting, boolean plain,
            Optional<Component> separator, DataSource dataSource) {
        return MutableComponentUtil.fromNbt(nbtPath, interpreting, plain, separator, dataSource);
    }

    public static Text fromScore(CompilableString<EntitySelector> pattern, String objective) {
        return MutableComponentUtil.fromScore(pattern, objective);
    }

    public static Text fromScore(String name, String objective) {
        return MutableComponentUtil.fromScore(name, objective);
    }

    public static Text fromSelector(CompilableString<EntitySelector> pattern, Optional<Component> separator) {
        return MutableComponentUtil.fromSelector(pattern, separator);
    }

    public static Text fromObject(ObjectInfo info) {
        return MutableComponentUtil.fromObject(info);
    }

    public static Text fromDate(Date date) {
        return MutableComponentUtil.fromDate(date);
    }

    public static Text fromMessage(Message message) {
        return MutableComponentUtil.fromMessage(message);
    }

    public static Text fromUuid(UUID uuid) {
        return MutableComponentUtil.fromUuid(uuid);
    }

    public static Text fromId(Identifier id) {
        return MutableComponentUtil.fromId(id);
    }

    public static Text fromChunkPos(ChunkPos chunkPos) {
        return MutableComponentUtil.fromChunkPos(chunkPos);
    }

    public static Text fromUri(URI uri) {
        return MutableComponentUtil.fromUri(uri);
    }
}
