package com.cocahonka.comfywhitelist.api;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Storage provides an abstraction for accessing and manipulating whitelist data.
 * Implementations of this interface can store the data in different sources, such as files or databases.
 */
public interface Storage {
    /**
     * Adds a player to the whitelist.
     *
     * @param username The username of the player to be added.
     * @return true if the player was successfully added, false otherwise.
     */
    boolean addPlayer(@NotNull String username);

    /**
     * Removes a player from the whitelist.
     *
     * @param username The username of the player to be removed.
     * @return true if the player was successfully removed, false otherwise.
     */
    boolean removePlayer(@NotNull String username);

    /**
     * Removes all players from the whitelist. This method is useful if you need to completely clear
     * the whitelist and start populating it from scratch.
     *
     * @return true if the operation was successful, false otherwise.
     */
    boolean clear();

    /**
     * Checks if a player is in the whitelist.
     *
     * @param username The username of the player to check.
     * @return true if the player is in the whitelist, false otherwise.
     */
    boolean isPlayerWhitelisted(@NotNull String username);

    /**
     * Retrieves all whitelisted players.
     *
     * @return A set of usernames of all players in the whitelist.
     */
    @NotNull
    Set<String> getAllWhitelistedPlayers();

    /**
     * Loads whitelist data from the data source.
     *
     * @return true if the data was successfully loaded, false otherwise.
     */
    boolean load();

    /**
     * Saves the current whitelist data to the data source.
     *
     * @return true if the data was successfully saved, false otherwise.
     */
    boolean save();

}
