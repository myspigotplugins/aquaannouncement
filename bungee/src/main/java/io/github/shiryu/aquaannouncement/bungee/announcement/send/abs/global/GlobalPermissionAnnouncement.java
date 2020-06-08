package io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.global;

import io.github.shiryu.aquaannouncement.bungee.announcement.send.BungeeAnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.PermissionAnnouncement;
import org.jetbrains.annotations.NotNull;

public class GlobalPermissionAnnouncement extends PermissionAnnouncement {

    public GlobalPermissionAnnouncement(String permission) {
        super(BungeeAnnouncementType.GLOBAL, permission, p -> true);
    }
}
