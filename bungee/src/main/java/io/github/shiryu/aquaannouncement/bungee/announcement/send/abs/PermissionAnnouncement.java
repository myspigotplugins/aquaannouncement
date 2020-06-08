package io.github.shiryu.aquaannouncement.bungee.announcement.send.abs;

import io.github.shiryu.aquaannouncement.api.enums.SendType;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.BungeeAnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.SendableAnnouncement;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;


public class PermissionAnnouncement extends SendableAnnouncement {

    private final String permission;

    public PermissionAnnouncement(@NotNull BungeeAnnouncementType bungeeAnnouncementType, @NotNull final String permission, @NotNull final Predicate<ProxiedPlayer> bungee) {
        super(p -> p.hasPermission(permission) && bungee.test(p), SendType.PERMISSION, bungeeAnnouncementType);

        this.permission = permission;
    }
}
