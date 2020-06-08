package io.github.shiryu.aquaannouncement.bukkit.announcement.type;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.bukkit.announcement.BukkitAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.send.SendableAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.wrapper.TitleWrapper;
import org.jetbrains.annotations.NotNull;

public class TitleAnnouncement extends BukkitAnnouncement<TitleWrapper> {

    public TitleAnnouncement(int id, @NotNull SendableAnnouncement base, @NotNull TitleWrapper value) {
        super(id, AnnouncementType.TITLE, base, value);
    }
}
