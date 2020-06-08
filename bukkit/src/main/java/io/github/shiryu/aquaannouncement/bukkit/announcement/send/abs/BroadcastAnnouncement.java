package io.github.shiryu.aquaannouncement.bukkit.announcement.send.abs;

import io.github.shiryu.aquaannouncement.api.enums.SendType;
import io.github.shiryu.aquaannouncement.bukkit.announcement.send.SendableAnnouncement;

public class BroadcastAnnouncement extends SendableAnnouncement {

    public BroadcastAnnouncement() {
        super(SendType.BROADCAST, (p -> true));
    }
}
