package io.github.shiryu.aquaannouncement.bungee.announcement.type;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.BungeeAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.SendableAnnouncement;
import org.jetbrains.annotations.NotNull;

public class TextAnnouncement extends BungeeAnnouncement<String> {

    public TextAnnouncement(int id, @NotNull SendableAnnouncement base, @NotNull String value) {
        super(id, AnnouncementType.TEXT, base, value);
    }
}
