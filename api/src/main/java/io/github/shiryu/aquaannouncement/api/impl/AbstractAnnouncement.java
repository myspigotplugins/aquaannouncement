package io.github.shiryu.aquaannouncement.api.impl;

import io.github.shiryu.aquaannouncement.api.IAnnouncement;
import io.github.shiryu.aquaannouncement.api.enums.AnnouncementType;
import io.github.shiryu.aquaannouncement.api.enums.SendType;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractAnnouncement<P> implements IAnnouncement<P> {

    protected final int id;
    protected final AnnouncementType announcementType;
    protected final SendType sendType;

    public AbstractAnnouncement(final int id, @NotNull final AnnouncementType announcementType, @NotNull final SendType sendType){
        this.id = id;
        this.announcementType = announcementType;
        this.sendType = sendType;
    }

    @Override
    public int getId() {
        return id;
    }

    @NotNull
    @Override
    public AnnouncementType getAnnouncementType() {
        return announcementType;
    }

    @NotNull
    @Override
    public SendType getSendType() {
        return sendType;
    }


}
