package io.github.shiryu.aquaannouncement.bukkit.util;

import io.github.shiryu.aquaannouncement.api.wrapper.Scalar;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class Colored implements Scalar<String> {

    private final String text;

    public Colored(@NotNull final String text){
        this.text = ChatColor.translateAlternateColorCodes('&', text);
    }

    @NotNull
    @Override
    public String value() {
        return text;
    }
}
