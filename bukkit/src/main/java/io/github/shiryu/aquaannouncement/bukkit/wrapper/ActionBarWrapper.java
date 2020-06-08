package io.github.shiryu.aquaannouncement.bukkit.wrapper;

import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import io.github.shiryu.aquaannouncement.bukkit.AquaAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.BukkitWrapper;
import io.github.shiryu.aquaannouncement.bukkit.protocol.WrapperPlayServerTitle;
import io.github.shiryu.aquaannouncement.bukkit.util.Colored;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ActionBarWrapper extends BukkitWrapper {

    public ActionBarWrapper(@NotNull String text) {
        super(text);
    }

    private WrapperPlayServerTitle createPacket(){
        final WrapperPlayServerTitle packet = new WrapperPlayServerTitle();

        packet.setAction(EnumWrappers.TitleAction.ACTIONBAR);
        packet.setTitle(WrappedChatComponent.fromText(new Colored(text).value()));

        return packet;
    }

    @Override
    public void send(@NotNull Player player) {
        if (AquaAnnouncement.getInstance().isPlaceholderAPI()) text = PlaceholderAPI.setPlaceholders(player, text);

        createPacket().sendPacket(player);
    }

    @Override
    public void sendPlayers(Player... players) {
        if (players.length == 0) return;

        for (Player player : players) send(player);
    }

    @Override
    public void sendAll() {
        createPacket().broadcastPacket();
    }
}
