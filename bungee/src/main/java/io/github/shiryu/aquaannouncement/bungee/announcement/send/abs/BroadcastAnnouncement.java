package io.github.shiryu.aquaannouncement.bungee.announcement.send.abs;

import io.github.shiryu.aquaannouncement.api.enums.SendType;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.BungeeAnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.SendableAnnouncement;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class BroadcastAnnouncement extends SendableAnnouncement {

    public BroadcastAnnouncement(@NotNull BungeeAnnouncementType bungeeAnnouncementType, @NotNull final Predicate<ProxiedPlayer> bungee) {
        super(p -> bungee.test(p), SendType.BROADCAST, bungeeAnnouncementType);
    }
}
