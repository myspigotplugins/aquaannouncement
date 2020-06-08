package io.github.shiryu.aquaannouncement.bukkit;

import io.github.shiryu.aquaannouncement.api.AquaAnnouncementAPI;
import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.api.enums.SendType;
import io.github.shiryu.aquaannouncement.bukkit.announcement.BukkitAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.send.SendableAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.send.abs.BroadcastAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.send.abs.PermissionAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.type.ActionBarAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.type.TextAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.announcement.type.TitleAnnouncement;
import io.github.shiryu.aquaannouncement.bukkit.task.AnnouncementTask;
import io.github.shiryu.aquaannouncement.bukkit.util.FileHelper;
import io.github.shiryu.aquaannouncement.bukkit.wrapper.ActionBarWrapper;
import io.github.shiryu.aquaannouncement.bukkit.wrapper.TitleWrapper;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class AquaAnnouncement extends JavaPlugin {

    private static AquaAnnouncement instance;

    private boolean placeholderAPI = false;

    @Override
    public void onEnable(){
        if (instance != null) throw new IllegalStateException("[AquaAnnouncement] cannot be enable twice!");

        instance = this;

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) placeholderAPI = true;

        loadAnnouncements();

        final BukkitAnnouncement defAnnounce = (BukkitAnnouncement) AquaAnnouncementAPI.getInstance().findAnnouncement(0);

        if (defAnnounce != null) new AnnouncementTask(defAnnounce);
    }

    private void loadAnnouncements(){
        final FileConfiguration configuration = getConfig();

        int count = 0;

        if (configuration.get("announcements") == null) configuration.createSection("announcements");

        final ConfigurationSection section = configuration.getConfigurationSection("announcements");

        if (section.getKeys(false) != null){
            for (String key : section.getKeys(false)){
                final int id = section.getInt(key + "." + "id");
                final AnnouncementType type = AnnouncementType.valueOf(section.getString(key + "." + "announcementType"));
                final SendType sendType = SendType.valueOf(section.getString(key + "." + "sendType"));

                SendableAnnouncement base = null;
                BukkitAnnouncement announcement = null;

                switch (sendType){
                    case BROADCAST:
                        base = new BroadcastAnnouncement();
                        break;
                    case PERMISSION:
                        base = new PermissionAnnouncement(section.getString(key + "." + "permission"));
                        break;
                }

                if (base != null){
                    switch (type){
                        case TEXT:
                            announcement = new TextAnnouncement(id, base, section.getString(key + "." + "text"));
                            break;
                        case TITLE:
                            announcement = new TitleAnnouncement(id, base, new TitleWrapper(section.getString(key + "." + "title"), configuration.getString(key + "." + "subtitle")));
                            break;
                        case ACTION_BAR:
                            announcement = new ActionBarAnnouncement(id, base, new ActionBarWrapper(section.getString(key + "." + "actionbar")));
                            break;
                    }
                }

                if (announcement != null){
                    AquaAnnouncementAPI.getInstance().addAnnouncement(announcement);
                    count++;
                }
            }
        }

        System.out.println("[AquaAnnouncement] " + count + " announcement has been loaded");
    }


    @NotNull
    public boolean isPlaceholderAPI() {
        return placeholderAPI;
    }


    public static AquaAnnouncement getInstance() {
        return instance;
    }
}
