package io.github.shiryu.aquaannouncement.api;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.api.enums.SendType;
import org.jetbrains.annotations.NotNull;

public interface IAnnouncement<P> {

    int getId();

    @NotNull
    AnnouncementType getAnnouncementType();

    @NotNull
    SendType getSendType();

    void sendPlayers(final P... players);

    void sendAll();
}
