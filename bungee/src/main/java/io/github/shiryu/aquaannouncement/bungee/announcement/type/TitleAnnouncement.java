package io.github.shiryu.aquaannouncement.bungee.announcement.type;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.BungeeAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.SendableAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.wrapper.TitleWrapper;
import org.jetbrains.annotations.NotNull;

public class TitleAnnouncement extends BungeeAnnouncement<TitleWrapper> {

    public TitleAnnouncement(int id, @NotNull SendableAnnouncement base, @NotNull TitleWrapper value) {
        super(id, AnnouncementType.TITLE, base, value);
    }
}
