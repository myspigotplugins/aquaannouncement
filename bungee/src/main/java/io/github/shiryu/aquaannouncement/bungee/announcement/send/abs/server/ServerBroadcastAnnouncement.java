package io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.server;

import io.github.shiryu.aquaannouncement.bungee.announcement.send.BungeeAnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.BroadcastAnnouncement;
import org.jetbrains.annotations.NotNull;

public class ServerBroadcastAnnouncement extends BroadcastAnnouncement {

    private final String server;

    public ServerBroadcastAnnouncement(@NotNull final String server) {
        super(BungeeAnnouncementType.SERVER, p -> p.getServer().getInfo().getName() == server);

        this.server = server;
    }

    public String getServer() {
        return server;
    }
}
