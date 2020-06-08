package io.github.shiryu.aquaannouncement.bungee;

import com.google.common.base.Strings;
import io.github.shiryu.aquaannouncement.api.AquaAnnouncementAPI;
import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.api.enums.SendType;
import io.github.shiryu.aquaannouncement.bungee.announcement.BungeeAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.BungeeAnnouncementType;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.SendableAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.BroadcastAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.PermissionAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.global.GlobalBroadcastAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.global.GlobalPermissionAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.server.ServerBroadcastAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.send.abs.server.ServerPermissionAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.type.ActionBarAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.type.TextAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.announcement.type.TitleAnnouncement;
import io.github.shiryu.aquaannouncement.bungee.file.IYaml;
import io.github.shiryu.aquaannouncement.bungee.file.YamlOf;
import io.github.shiryu.aquaannouncement.bungee.task.AnnouncementTask;
import io.github.shiryu.aquaannouncement.bungee.wrapper.ActionBarWrapper;
import io.github.shiryu.aquaannouncement.bungee.wrapper.TitleWrapper;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import org.jetbrains.annotations.NotNull;

public class AquaAnnouncement extends Plugin {

    private static AquaAnnouncement instance;

    private IYaml configs;
    private IYaml announcements;

    @Override
    public void onEnable(){
        if (instance != null) throw new IllegalStateException("[AquaAnnouncement] cannot be enable twice!");

        instance = this;

        loadFiles();
        loadAnnouncements();

        final BungeeAnnouncement defAnnounce = (BungeeAnnouncement) AquaAnnouncementAPI.getInstance().findAnnouncement(0);

        if (defAnnounce != null) new AnnouncementTask(this, defAnnounce);
    }

    private void loadFiles(){
        if (configs == null){
            configs = new YamlOf(this, "config.yml");
        }else{
            configs.load();
        }

        if (announcements == null){
            announcements = new YamlOf(this, "announcements.yml");
        }else{
            announcements.load();
        }

        configs.load();
        announcements.load();
    }

    private void loadAnnouncements(){
        final Configuration announcements = this.configs.getSection("announcements");

        int count = 0;

        if (announcements.getKeys() != null){
            for (String server : announcements.getKeys()){
                final Configuration configuration = this.configs.getSection("announcements." + server);

                if (configuration != null){
                    for (String key : configuration.getKeys()){
                        final int id = configuration.getInt(key + ".id");

                        final AnnouncementType announcementType = AnnouncementType.valueOf(configuration.getString(key + ".announcementType"));
                        final SendType sendType = SendType.valueOf(configuration.getString(key + ".sendType"));
                        final BungeeAnnouncementType bungeeAnnouncementType = BungeeAnnouncementType.valueOf(configuration.getString(key + ".bungee"));

                        SendableAnnouncement base = null;
                        BungeeAnnouncement announcement = null;

                        switch (bungeeAnnouncementType){
                            case GLOBAL:
                                switch (sendType){
                                    case BROADCAST:
                                        base = new GlobalBroadcastAnnouncement();
                                        break;
                                    case PERMISSION:
                                        base = new GlobalPermissionAnnouncement(configuration.getString(key + ".permission"));
                                        break;
                                }
                            case SERVER:
                                switch (sendType){
                                    case BROADCAST:
                                        base = new ServerBroadcastAnnouncement(configuration.getString(key + ".server"));
                                        break;
                                    case PERMISSION:
                                        base = new ServerPermissionAnnouncement(configuration.getString(key + ".permission"), configuration.getString(key + ".server"));
                                        break;
                                }
                        }

                        switch (announcementType){
                            case TEXT:
                                announcement = new TextAnnouncement(id, base, configuration.getString(key + "." + "text"));
                                break;
                            case TITLE:
                                announcement = new TitleAnnouncement(id, base, new TitleWrapper(configuration.getString(key + "." + "title"), configuration.getString(key + "." + "subtitle")));
                                break;
                            case ACTION_BAR:
                                announcement = new ActionBarAnnouncement(id, base, new ActionBarWrapper(configuration.getString(key + "." + "actionbar")));
                                break;
                        }

                        if (announcement != null){
                            AquaAnnouncementAPI.getInstance().addAnnouncement(announcement);
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println("[AquaAnnouncement] " + count + " announcement has been loaded");

    }

    @NotNull
    public IYaml getConfigs() {
        return configs;
    }

    @NotNull
    public IYaml getAnnouncements() {
        return announcements;
    }

    public static AquaAnnouncement getInstance() {
        return instance;
    }
}
