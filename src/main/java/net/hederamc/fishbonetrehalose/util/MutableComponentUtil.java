package net.hederamc.fishbonetrehalose.util;

import com.mojang.brigadier.Message;
import com.mojang.datafixers.util.Either;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.commands.arguments.NbtPathArgument.NbtPath;
import net.minecraft.commands.arguments.selector.EntitySelector;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.contents.NbtContents;
import net.minecraft.network.chat.contents.PlainTextContents;
import net.minecraft.network.chat.contents.ScoreContents;
import net.minecraft.network.chat.contents.SelectorContents;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.network.chat.contents.data.DataSource;
import net.minecraft.network.chat.contents.objects.ObjectInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.util.CompilableString;
import net.minecraft.world.level.ChunkPos;
import org.jspecify.annotations.Nullable;

public final class MutableComponentUtil {
    private MutableComponentUtil() {
    }

    public static MutableComponent fromContents(ComponentContents contents) {
        return new MutableComponent(contents, new ArrayList<>(), Style.EMPTY);
    }

    public static MutableComponent fromEmpty() {
        return fromContents(PlainTextContents.EMPTY);
    }

    public static MutableComponent fromString(String string) {
        return fromContents(PlainTextContentsUtil.fromString(string));
    }

    public static MutableComponent fromTranslatable(String key) {
        return fromContents(TranslatableContentsUtil.fromKey(key));
    }

    public static MutableComponent fromTranslatable(String key, Object... args) {
        return fromContents(new TranslatableContents(key, null, args));
    }

    public static MutableComponent fromTranslatableEscape(String key, Object... args) {
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (!TranslatableContents.isAllowedPrimitiveArgument(arg) && !(arg instanceof Component)) {
                args[i] = String.valueOf(arg);
            }
        }

        return fromTranslatable(key, args);
    }

    public static MutableComponent fromTranslatableWithFallback(String key, @Nullable String fallback) {
        return fromContents(new TranslatableContents(key, fallback, TranslatableContents.NO_ARGS));
    }

    public static MutableComponent fromTranslatableWithFallback(String key, @Nullable String fallback, Object... args) {
        return fromContents(new TranslatableContents(key, fallback, args));
    }

    public static MutableComponent fromKeybind(String name) {
        return fromContents(KeybindContentsUtil.fromName(name));
    }

    public static MutableComponent fromNbt(CompilableString<NbtPath> nbtPath, boolean interpreting, boolean plain,
            Optional<Component> separator, DataSource dataSource) {
        return fromContents(new NbtContents(nbtPath, interpreting, plain, separator, dataSource));
    }

    public static MutableComponent fromScore(CompilableString<EntitySelector> pattern, String objective) {
        return fromContents(new ScoreContents(Either.left(pattern), objective));
    }

    public static MutableComponent fromScore(String name, String objective) {
        return fromContents(new ScoreContents(Either.right(name), objective));
    }

    public static MutableComponent fromSelector(CompilableString<EntitySelector> pattern, Optional<Component> separator) {
        return fromContents(new SelectorContents(pattern, separator));
    }

    public static MutableComponent fromObject(ObjectInfo info) {
        return fromContents(ObjectContentsUtil.fromInfo(info));
    }

    public static MutableComponent fromDate(Date date) {
        return fromString(date.toString());
    }

    public static MutableComponent fromMessage(Message message) {
        return message instanceof MutableComponent component ? component : fromString(message.getString());
    }

    public static MutableComponent fromUuid(UUID uuid) {
        return fromString(uuid.toString());
    }

    public static MutableComponent fromId(Identifier id) {
        return fromString(id.toString());
    }

    public static MutableComponent fromChunkPos(ChunkPos chunkPos) {
        return fromString(chunkPos.toString());
    }

    public static MutableComponent fromUri(URI uri) {
        return fromString(uri.toString());
    }
}
