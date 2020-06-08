package io.github.shiryu.aquaannouncement.api.wrapper;

import org.jetbrains.annotations.NotNull;

public interface Wrapper<P> {

    void send(@NotNull final P player);

    void sendPlayers(final P... players);

    void sendAll();
}
