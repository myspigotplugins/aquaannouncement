package io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.server;

import io.github.shiryu.aquaannouncement.bungee.announcement.send.BungeeAnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.PermissionAnnouncement;
import org.jetbrains.annotations.NotNull;

public class ServerPermissionAnnouncement extends PermissionAnnouncement {

    private final String server;

    public ServerPermissionAnnouncement(@NotNull final String permission, @NotNull final String server) {
        super(BungeeAnnouncementType.SERVER, permission, p -> p.getServer().getInfo().getName() == server);

        this.server = server;
    }
}
