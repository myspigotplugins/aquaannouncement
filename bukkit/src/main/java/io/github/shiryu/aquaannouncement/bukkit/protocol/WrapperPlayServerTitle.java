package io.github.shiryu.aquaannouncement.bukkit.protocol;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import org.jetbrains.annotations.NotNull;

import static com.comphenix.protocol.wrappers.EnumWrappers.TitleAction;

public class WrapperPlayServerTitle extends AbstractPacket {

    private static final PacketType TYPE = PacketType.Play.Server.TITLE;

    public WrapperPlayServerTitle(){
        super(new PacketContainer(TYPE), TYPE);

        handle.getModifier().writeDefaults();
    }

    public WrapperPlayServerTitle(@NotNull final PacketContainer packet){
        super(packet, TYPE);
    }

    /**
     * Retrieve Action.
     *
     * @return The current Action
     */
    @NotNull
    public TitleAction getAction() {
        return handle.getTitleActions().read(0);
    }

    /**
     * Set Action.
     *
     * @param value - new value.
     */
    public void setAction(@NotNull final TitleAction value) {
        handle.getTitleActions().write(0, value);
    }

    /**
     * Retrieve 0 (TITLE).
     * <p>
     * Notes: chat
     *
     * @return The current 0 (TITLE)
     */
    @NotNull
    public WrappedChatComponent getTitle() {
        return handle.getChatComponents().read(0);
    }

    /**
     * Set 0 (TITLE).
     *
     * @param value - new value.
     */
    public void setTitle(@NotNull final WrappedChatComponent value) {
        handle.getChatComponents().write(0, value);
    }

    /**
     * Retrieve 2 (TIMES).
     * <p>
     * Notes: int
     *
     * @return The current 2 (TIMES)
     */
    public int getFadeIn() {
        return handle.getIntegers().read(0);
    }


    /**
     * Retrieve Stay.
     *
     * @return The current Stay
     */
    public int getStay() {
        return handle.getIntegers().read(1);
    }

    /**
     * Retrieve Fade Out.
     *
     * @return The current Fade Out
     */
    public int getFadeOut() {
        return handle.getIntegers().read(2);
    }

    /**
     * Set Stay.
     *
     * @param value - new value.
     */
    public void setStay(final int value) {
        handle.getIntegers().write(1, value);
    }

    /**
     * Set 2 (TIMES).
     *
     * @param value - new value.
     */
    public void setFadeIn(int value) {
        handle.getIntegers().write(0, value);
    }

    /**
     * Set Fade Out.
     *
     * @param value - new value.
     */
    public void setFadeOut(final int value) {
        handle.getIntegers().write(2, value);
    }
}
