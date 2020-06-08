package io.github.shiryu.aquaannouncement.bukkit.announcement.type;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.bukkit.announcement.BukkitAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.send.SendableAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.wrapper.ActionBarWrapper;
import org.jetbrains.annotations.NotNull;

public class ActionBarAnnouncement extends BukkitAnnouncement<ActionBarWrapper> {

    public ActionBarAnnouncement(int id, @NotNull SendableAnnouncement base, @NotNull ActionBarWrapper value) {
        super(id, AnnouncementType.ACTION_BAR, base, value);
    }
}
