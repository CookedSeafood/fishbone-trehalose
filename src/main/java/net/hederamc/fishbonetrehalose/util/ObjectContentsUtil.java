package net.hederamc.fishbonetrehalose.util;

import net.minecraft.network.chat.contents.ObjectContents;
import net.minecraft.network.chat.contents.objects.ObjectInfo;

public final class ObjectContentsUtil {
    private ObjectContentsUtil() {
    }

    public static ObjectContents fromInfo(ObjectInfo info) {
        return new ObjectContents(info);
    }
}
