package io.github.shiryu.aquaannouncement.bungee.file;

import net.md_5.bungee.config.Configuration;
import org.jetbrains.annotations.NotNull;

public interface IYaml {

    @NotNull
    String getName();

    @NotNull
    String getPath();

    @NotNull
    Configuration getSection(String path);

    @NotNull
    <T> T getOrSet(String paramString, T def);

    void set(@NotNull final String path, @NotNull final Object object);

    void save();

    void load();
}
