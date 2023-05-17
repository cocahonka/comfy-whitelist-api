package com.cocahonka.comfywhitelist.api;

import org.jetbrains.annotations.NotNull;

/**
 * ComfyWhitelistAPI provides access to key components of the ComfyWhitelist plugin.
 */
public interface ComfyWhitelistAPI {

    /**
     * Gets the Storage instance used by the ComfyWhitelist plugin.
     *
     * @return The Storage instance.
     */
    @NotNull
    Storage getStorage();

    /**
     * Gets the WhitelistManager instance used by the ComfyWhitelist plugin.
     *
     * @return The WhitelistManager instance.
     */
    @NotNull
    WhitelistManager getStateManager();
}

