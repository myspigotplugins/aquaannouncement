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

public class TitleWrapper extends BukkitWrapper {

    private String title;
    private String subtitle;

    public TitleWrapper(@NotNull final String title, @NotNull final String subtitle){
        super("");

        this.title = title;
        this.subtitle = subtitle;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    @NotNull
    public String getSubtitle() {
        return subtitle;
    }

    public void setTitle(@NotNull final String title) {
        this.title = title;
    }

    public void setSubtitle(@NotNull final String subtitle) {
        this.subtitle = subtitle;
    }

    private WrapperPlayServerTitle createFrom(@NotNull final EnumWrappers.TitleAction action, @NotNull final String text){
        final WrapperPlayServerTitle packet = new WrapperPlayServerTitle();

        packet.setAction(action);
        packet.setTitle(WrappedChatComponent.fromText(text));

        return packet;
    }

    @Override
    public void send(@NotNull Player player) {
        if (AquaAnnouncement.getInstance().isPlaceholderAPI()){
            this.title = PlaceholderAPI.setPlaceholders(player, this.title);
            this.subtitle = PlaceholderAPI.setPlaceholders(player, this.subtitle);
        }

        createFrom(EnumWrappers.TitleAction.TITLE, new Colored(this.title).value()).sendPacket(player);

        createFrom(EnumWrappers.TitleAction.SUBTITLE, new Colored(this.subtitle).value()).sendPacket(player);
    }

    @Override
    public void sendPlayers(Player... players) {
        if (players.length == 0) return;

        for (Player player : players) send(player);
    }

    @Override
    public void sendAll() {
        createFrom(EnumWrappers.TitleAction.TITLE, new Colored(this.title).value()).broadcastPacket();

        createFrom(EnumWrappers.TitleAction.SUBTITLE, new Colored(this.subtitle).value()).broadcastPacket();
    }
}
