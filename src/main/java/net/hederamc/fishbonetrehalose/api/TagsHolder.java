package net.hederamc.fishbonetrehalose.api;

import java.util.Set;

public interface TagsHolder {
    default Set<String> getTags() {
        throw new UnsupportedOperationException();
    }

    default boolean hasTag(String tag) {
        throw new UnsupportedOperationException();
    }

    default boolean addTag(String tag) {
        throw new UnsupportedOperationException();
    }

    default boolean removeTag(String tag) {
        throw new UnsupportedOperationException();
    }
}
