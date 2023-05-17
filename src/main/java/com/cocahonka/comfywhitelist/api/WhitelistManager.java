package com.cocahonka.comfywhitelist.api;

/**
 * WhitelistManager provides methods for managing the state of the whitelist.
 */
public interface WhitelistManager {

    /**
     * Enables the whitelist.
     */
    void enableWhitelist();

    /**
     * Disables the whitelist.
     */
    void disableWhitelist();

    /**
     * Checks if the whitelist is enabled.
     *
     * @return true if the whitelist is enabled, false otherwise.
     */
    boolean isWhitelistEnabled();

}
