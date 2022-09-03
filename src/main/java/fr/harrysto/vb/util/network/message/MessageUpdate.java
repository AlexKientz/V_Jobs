package fr.harrysto.vb.util.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

// Check Message

public class MessageUpdate implements IMessage{

    String playerVariable;

    public MessageUpdate() {}

    public MessageUpdate(String player) {
        this.playerVariable = player;
        System.out.println(playerVariable + player);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        playerVariable = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, playerVariable);
    }

    public static class Handler implements IMessageHandler<MessageUpdate, IMessage>{

        public static String InPlayer;

        @Override
        public IMessage onMessage(MessageUpdate message, MessageContext ctx) {
            System.out.println("Ce n'est pas censé arrivé !!!");

            return null;
        }
    }

}
