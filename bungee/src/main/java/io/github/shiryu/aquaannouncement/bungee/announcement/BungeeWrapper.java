package io.github.shiryu.aquaannouncement.bungee.announcement;

import io.github.shiryu.aquaannouncement.api.wrapper.Wrapper;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

public abstract class BungeeWrapper implements Wrapper<ProxiedPlayer> {

    protected String text;

    public BungeeWrapper(@NotNull final String text) {
        this.text = text;
    }

    @NotNull
    public String getText() {
        return text;
    }

    @Override
    public void sendPlayers(ProxiedPlayer... players) {
        if (players.length == 0) return;

        for (ProxiedPlayer player : players) send(player);
    }

    @Override
    public void sendAll() {
        ProxyServer.getInstance().getPlayers().forEach(player -> send(player));
    }
}
