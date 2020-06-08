package io.github.shiryu.aquaannouncement.bungee.util;

import io.github.shiryu.aquaannouncement.api.wrapper.Scalar;
import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

public class Colored implements Scalar<String> {

    private final String text;

    public Colored(@NotNull final String text){
        this.text = ChatColor.translateAlternateColorCodes('&', text);
    }

    @NotNull
    @Override
    public String value() {
        return this.text;
    }
}
