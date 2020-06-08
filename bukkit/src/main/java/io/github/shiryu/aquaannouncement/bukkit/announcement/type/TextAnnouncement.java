package io.github.shiryu.aquaannouncement.bukkit.announcement.type;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.bukkit.announcement.BukkitAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.send.SendableAnnouncement;
import org.jetbrains.annotations.NotNull;

public class TextAnnouncement extends BukkitAnnouncement<String> {

    public TextAnnouncement(int id, @NotNull SendableAnnouncement base, @NotNull String value) {
        super(id, AnnouncementType.TEXT, base, value);
    }
}
