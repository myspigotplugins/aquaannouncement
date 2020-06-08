package io.github.shiryu.aquaannouncement.bukkit.protocol;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class AbstractPacket {

    protected PacketContainer handle;

    protected AbstractPacket(@NotNull final PacketContainer handle, @NotNull final PacketType type){
        if (handle == null) throw new IllegalArgumentException("Packet HANDLE cannot be null.");

        if (!Objects.equals(handle.getType(), type))
            throw new IllegalArgumentException(handle.getHandle()
                    + " is not a packet of type " + type);

        this.handle = handle;
    }

    @NotNull
    public PacketContainer getHandle() {
        return handle;
    }

    public void sendPacket(@NotNull final Player player) {
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player,
                    handle);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Cannot send packet.", e);
        }
    }

    public void broadcastPacket(){
        ProtocolLibrary.getProtocolManager().broadcastServerPacket(this.handle);
    }

    public void receivePacket(@NotNull final Player sender) {
        try {
            ProtocolLibrary.getProtocolManager().recieveClientPacket(sender,
                    this.handle);
        } catch (Exception e) {
            throw new RuntimeException("Cannot recieve packet.", e);
        }
    }
}
