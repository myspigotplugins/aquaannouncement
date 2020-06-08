package io.github.shiryu.aquaannouncement.bungee.wrapper;

import io.github.shiryu.aquaannouncement.bungee.announcement.BungeeWrapper;
import io.github.shiryu.aquaannouncement.bungee.util.Colored;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

public class ActionBarWrapper extends BungeeWrapper {

    public ActionBarWrapper(@NotNull String text) {
        super(text);
    }

    @Override
    public void send(@NotNull ProxiedPlayer player) {
        player.sendMessage(
                ChatMessageType.ACTION_BAR,
                new TextComponent(new Colored(text).value())
        );
    }
}
