package io.github.shiryu.aquaannouncement.bungee.announcement;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.api.impl.AbstractAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.AquaAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.SendableAnnouncement;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

public class BungeeAnnouncement<T> extends AbstractAnnouncement<ProxiedPlayer> {

    protected SendableAnnouncement base;
    protected T value;

    public BungeeAnnouncement(final int id, @NotNull final AnnouncementType announcementType, @NotNull final SendableAnnouncement base, @NotNull final T value){
        super(id, announcementType, base.getSendType());

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
    public void sendPlayers(ProxiedPlayer... players) {
        if (players.length == 0) return;

        for (ProxiedPlayer player : players) this.base.send(announcementType, player, value);
    }

    @Override
    public void sendAll() {
        AquaAnnouncement.getInstance().getProxy().getPlayers().forEach(player -> this.base.send(announcementType, player, value));
    }
}
