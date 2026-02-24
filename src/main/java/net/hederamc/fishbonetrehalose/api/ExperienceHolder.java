package net.hederamc.fishbonetrehalose.api;

public interface ExperienceHolder {
    default int getExperience() {
        throw new UnsupportedOperationException();
    }

    default void setExperience(int experience) {
        throw new UnsupportedOperationException();
    }

    default int getExperienceLevel() {
        throw new UnsupportedOperationException();
    }

    default void setExperienceLevel(int level) {
        throw new UnsupportedOperationException();
    }
}
