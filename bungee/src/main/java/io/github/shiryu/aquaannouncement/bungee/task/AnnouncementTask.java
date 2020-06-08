package io.github.shiryu.aquaannouncement.bungee.task;

import io.github.shiryu.aquaannouncement.api.AquaAnnouncementAPI;
import io.github.shiryu.aquaannouncement.bungee.AquaAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.BungeeAnnouncement;
import net.md_5.bungee.api.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class AnnouncementTask {

    private final Plugin plugin;

    private BungeeAnnouncement current;

    public AnnouncementTask(@NotNull final Plugin plugin, @NotNull final BungeeAnnouncement current){
        this.plugin = plugin;
        this.current = current;

        plugin.getProxy().getScheduler().schedule(
                plugin,
                () ->{
                    if (plugin.getProxy().getPlayers().size() < AquaAnnouncement.getInstance().getConfigs().getOrSet("PLAYER_LIMIT", 3)) return;

                    this.current.sendAll();

                    if (AquaAnnouncementAPI.getInstance().getNextAnnouncement(this.current) != null) this.current = (BungeeAnnouncement) AquaAnnouncementAPI.getInstance().getNextAnnouncement(this.current);
                },
                AquaAnnouncement.getInstance().getConfigs().getOrSet("ANNOUNCEMENT_INTERVAL", 300),
                TimeUnit.SECONDS
        );
    }
}
