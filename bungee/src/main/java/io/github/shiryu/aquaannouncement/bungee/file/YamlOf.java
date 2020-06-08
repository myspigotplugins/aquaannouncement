package io.github.shiryu.aquaannouncement.bungee.file;

import net.md_5.bungee.api.plugin.Plugin;

public class YamlOf extends YamlEnvelope{

    public YamlOf(Plugin plugin, String name, String path) { super(plugin, name, path); }

    public YamlOf(Plugin plugin, String name) { super(plugin, name, ""); }
}
