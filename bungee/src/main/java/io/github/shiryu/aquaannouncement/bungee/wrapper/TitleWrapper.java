package io.github.shiryu.aquaannouncement.bungee.wrapper;

import io.github.shiryu.aquaannouncement.bungee.announcement.BungeeWrapper;
import io.github.shiryu.aquaannouncement.bungee.util.Colored;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

public class TitleWrapper extends BungeeWrapper {

    private String title,subtitle;

    public TitleWrapper(@NotNull final String title, @NotNull final String subtitle) {
        super("");

        this.title = title;
        this.subtitle = subtitle;
    }

    @Override
    public void send(@NotNull ProxiedPlayer player) {
        ProxyServer.getInstance().createTitle()
                .title(new TextComponent(new Colored(this.title).value()))
                .subTitle(new TextComponent(new Colored(this.subtitle).value()))
                .send(player);
    }
}
