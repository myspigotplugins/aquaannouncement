package io.github.shiryu.aquaannouncement.bukkit.announcement;

import io.github.shiryu.aquaannouncement.api.wrapper.Wrapper;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class BukkitWrapper implements Wrapper<Player> {

    protected String text;

    public BukkitWrapper(@NotNull final String text) {
        this.text = text;
    }

    @NotNull
    public String getText() {
        return text;
    }
}
