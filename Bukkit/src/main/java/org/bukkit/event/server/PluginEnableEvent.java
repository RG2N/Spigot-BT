package org.bukkit.event.server;

import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a plugin is enabled.
 */
public class PluginEnableEvent extends PluginEvent {
    private static final HandlerList handlers = new HandlerList();

    public PluginEnableEvent(@NotNull final Plugin plugin) {
        super(plugin);
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
