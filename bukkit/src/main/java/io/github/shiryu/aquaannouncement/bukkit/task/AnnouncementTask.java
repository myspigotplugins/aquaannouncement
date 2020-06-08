package io.github.shiryu.aquaannouncement.bukkit.task;

import io.github.shiryu.aquaannouncement.api.AquaAnnouncementAPI;
import io.github.shiryu.aquaannouncement.bukkit.AquaAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.BukkitAnnouncement;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class AnnouncementTask extends BukkitRunnable {

    private BukkitAnnouncement current;

    public AnnouncementTask(@NotNull final BukkitAnnouncement announcement){
        this.current = announcement;

        int timer = AquaAnnouncement.getInstance().getConfig().getInt("ANNOUNCEMENT_INTERVAL") * 20;

        runTaskTimer(
                AquaAnnouncement.getInstance(),
                timer * 20L,
                timer * 20L
        );
    }


    @Override
    public void run() {
        if (Bukkit.getOnlinePlayers().size() < AquaAnnouncement.getInstance().getConfig().getInt("PLAYER_LIMIT")) return;

        this.current.sendAll();

        if (AquaAnnouncementAPI.getInstance().getNextAnnouncement(this.current) != null) this.current = (BukkitAnnouncement) AquaAnnouncementAPI.getInstance().getNextAnnouncement(this.current);
    }
}
