package io.github.shiryu.aquaannouncement.bukkit.announcement;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.api.impl.AbstractAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.send.SendableAnnouncement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BukkitAnnouncement<T> extends AbstractAnnouncement<Player> {

    protected SendableAnnouncement base;
    protected T value;

    public BukkitAnnouncement(final int id, @NotNull final AnnouncementType announcementType, @NotNull final SendableAnnouncement base, @NotNull final T value) {
        super(id, announcementType, base.getSendType());

        this.base = base;
        this.value = value;
    }

    @NotNull
    public T getValue() {
        return value;
    }

    @NotNull
    public SendableAnnouncement getBase() {
        return base;
    }

    @Override
    public void sendPlayers(Player... players) {
        if (players.length == 0) return;

        for (Player player : players) this.base.send(announcementType, player, value);
    }

    @Override
    public void sendAll() {
        Bukkit.getOnlinePlayers().forEach(player -> this.base.send(announcementType, player, value));
    }
}
