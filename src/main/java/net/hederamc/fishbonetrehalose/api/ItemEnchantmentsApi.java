package net.hederamc.fishbonetrehalose.api;

public interface ItemEnchantmentsApi {
    default int getLevel(String enchantment) {
        return 0;
    }
}
