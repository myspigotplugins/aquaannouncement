package io.github.shiryu.aquaannouncement.bukkit.announcement.send;

import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.api.enums.SendType;
import io.github.shiryu.aquaannouncement.bukkit.AquaAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.BukkitAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.BukkitWrapper;
import io.github.shiryu.aquaannouncement.bukkit.util.Colored;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public abstract class SendableAnnouncement {

    private final Predicate<Player> control;
    private final SendType sendType;

    public SendableAnnouncement(@NotNull SendType sendType, @NotNull final Predicate<Player> control) {
        this.sendType = sendType;
        this.control = control;
    }

    public <T> void send(@NotNull final AnnouncementType announcementType, @NotNull final Player player, @NotNull final T value){
        if (!control.test(player)) return;

        BukkitWrapper wrapper = null;

        switch (announcementType){
            case TEXT:
                String text = (String) value;

                if (AquaAnnouncement.getInstance().isPlaceholderAPI()){
                    text = PlaceholderAPI.setPlaceholders(player, text);
                }

                player.sendMessage(
                        new Colored(
                                AquaAnnouncement.getInstance().getConfig().getString("ANNOUNCE_PREFIX") + text
                        ).value()
                );
                break;
            default:
                wrapper = (BukkitWrapper) value;
                break;
        }

        if (wrapper != null) wrapper.send(player);
    }

    @NotNull
    public Predicate<Player> getControl() {
        return control;
    }

    @NotNull
    public SendType getSendType() {
        return sendType;
    }
}
