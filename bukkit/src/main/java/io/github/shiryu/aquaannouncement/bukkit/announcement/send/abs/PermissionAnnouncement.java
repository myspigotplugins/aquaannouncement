package io.github.shiryu.aquaannouncement.bukkit.announcement.send.abs;

import io.github.shiryu.aquaannouncement.api.enums.SendType;
import io.github.shiryu.aquaannouncement.bukkit.announcement.send.SendableAnnouncement;
import org.jetbrains.annotations.NotNull;

public class PermissionAnnouncement extends SendableAnnouncement {

    private final String permission;

    public PermissionAnnouncement(@NotNull final String permission) {
        super(SendType.PERMISSION, player -> player.hasPermission(permission));

        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
