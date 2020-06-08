package io.github.shiryu.aquaannouncement.bungee.announcement.type;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.BungeeAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.SendableAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.wrapper.ActionBarWrapper;
import org.jetbrains.annotations.NotNull;

public class ActionBarAnnouncement extends BungeeAnnouncement<ActionBarWrapper> {

    public ActionBarAnnouncement(int id, @NotNull SendableAnnouncement base, @NotNull ActionBarWrapper value) {
        super(id, AnnouncementType.ACTION_BAR, base, value);
    }
}
