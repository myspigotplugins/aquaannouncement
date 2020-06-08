package io.github.shiryu.aquaannouncement.bungee.file;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class YamlEnvelope implements IYaml {

    private final Plugin plugin;
    private final String fileName;
    private final String filePath;
    private final String resourcePath;
    private File file;
    private Configuration configuration;

    public YamlEnvelope(Plugin plugin, String fileName, String filePath) {
        this.plugin = plugin;

        if (!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdirs();

        this.fileName = fileName.endsWith(".yml") ? fileName : (fileName + ".yml");
        this.resourcePath = filePath.equals("") ? "" : (filePath + "/");
        this


                .filePath = filePath.equals("") ? (plugin.getDataFolder().getAbsolutePath() + "\\") : (plugin.getDataFolder().getAbsolutePath() + "\\" + filePath + "\\");

        this.file = new File(this.filePath, this.fileName);

        try {
            this.configuration = ConfigurationProvider.getProvider(net.md_5.bungee.config.YamlConfiguration.class).load(this.file);
        } catch (Exception e) {
            this.configuration = null;
        }

        if (this.file.exists())
            return;
        init();
        copy();
    }


    public void copy() {
        InputStream in = this.plugin.getResourceAsStream(this.resourcePath + this.fileName);
        try {
            OutputStream out = new FileOutputStream(this.file);
            byte[] buf = new byte[63];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception exception) {}
    }

    public void init() {
        File __file = new File(this.filePath);
        while (!__file.exists()) {
            __file.mkdir();
            __file = __file.getParentFile();
        }
    }


    public String getName() { return this.fileName; }

    public String getPath() { return this.filePath; }

    public Configuration getSection(String path) { return this.configuration.getSection(path); }

    public <T> T getOrSet(String path, T object) { return (T)this.configuration.get(path, object); }

    public void set(String path, Object object) {
        this.configuration.set(path, object);
        save();
        load();
    }


    public void save() {
        try {
            ConfigurationProvider.getProvider(net.md_5.bungee.config.YamlConfiguration.class).save(this.configuration, new File(this.filePath, this.fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void load() {
        try {
            this.configuration = ConfigurationProvider.getProvider(net.md_5.bungee.config.YamlConfiguration.class).load(new File(this.filePath, this.fileName));
        } catch (Exception e) {
            this.configuration = null;
        }
    }
}
