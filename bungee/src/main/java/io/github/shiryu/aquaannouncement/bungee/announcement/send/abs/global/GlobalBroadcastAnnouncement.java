package io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.global;

import io.github.shiryu.aquaannouncement.bungee.announcement.send.BungeeAnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.BroadcastAnnouncement;

public class GlobalBroadcastAnnouncement extends BroadcastAnnouncement {

    public GlobalBroadcastAnnouncement() {
        super(BungeeAnnouncementType.GLOBAL, p -> true);
    }
}
