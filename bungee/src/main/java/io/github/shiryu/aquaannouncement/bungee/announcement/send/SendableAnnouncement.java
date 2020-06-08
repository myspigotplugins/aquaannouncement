package io.github.shiryu.aquaannouncement.bungee.announcement.send;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.api.enums.SendType;
import io.github.shiryu.aquaannouncement.bungee.announcement.BungeeAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.BungeeWrapper;
import io.github.shiryu.aquaannouncement.bungee.util.Colored;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public abstract class SendableAnnouncement {

    private final Predicate<ProxiedPlayer> control;
    private final SendType sendType;
    private final BungeeAnnouncementType bungeeAnnouncementType;

    public SendableAnnouncement(@NotNull final Predicate<ProxiedPlayer> control, @NotNull final SendType sendType, @NotNull final BungeeAnnouncementType bungeeAnnouncementType){
        this.control = control;
        this.sendType = sendType;
        this.bungeeAnnouncementType = bungeeAnnouncementType;
    }

    @NotNull
    public Predicate<ProxiedPlayer> getControl() {
        return control;
    }

    @NotNull
    public SendType getSendType() {
        return sendType;
    }

    @NotNull
    public BungeeAnnouncementType getBungeeAnnouncementType() {
        return bungeeAnnouncementType;
    }

    public <T> void send(@NotNull AnnouncementType announcementType, @NotNull ProxiedPlayer player, @NotNull T value) {
        if (!control.test(player)) return;

        BungeeWrapper wrapper = null;

        switch (announcementType){
            case TEXT:
                String text = (String) value;

                player.sendMessage(
                        new Colored(
                                text
                        ).value()
                );
                break;
            default:
                wrapper = (BungeeWrapper) value;
                break;
        }

        if (wrapper != null) wrapper.send(player);
    }
}
