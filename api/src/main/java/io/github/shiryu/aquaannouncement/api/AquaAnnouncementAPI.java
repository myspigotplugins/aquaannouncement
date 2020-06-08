package io.github.shiryu.aquaannouncement.api;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class AquaAnnouncementAPI {

    private static AquaAnnouncementAPI instance;

    private final List<IAnnouncement> ANNOUNCEMENTS = new ArrayList<>();

    private AquaAnnouncementAPI(){

    }

    public <P> IAnnouncement<P> findAnnouncement(final int id){
        return ANNOUNCEMENTS.stream()
                .filter(a -> a.getId() == id)
                .findAny()
                .orElse(null);
    }

    public <P> IAnnouncement<P> getNextAnnouncement(@NotNull final IAnnouncement<P> announcement){
        return findAnnouncement(announcement.getId() + 1);
    }

    public <P> void addAnnouncement(@NotNull final IAnnouncement<P> announcement){
        this.ANNOUNCEMENTS.add(announcement);
    }

    public static synchronized AquaAnnouncementAPI getInstance(){
        if (instance == null) instance = new AquaAnnouncementAPI();

        return instance;
    }
}
