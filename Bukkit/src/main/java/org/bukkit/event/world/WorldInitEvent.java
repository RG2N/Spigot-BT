package org.bukkit.event.world;

import org.bukkit.World;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a World is initializing
 */
public class WorldInitEvent extends WorldEvent {
    private static final HandlerList handlers = new HandlerList();

    public WorldInitEvent(@NotNull final World world) {
        super(world);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
