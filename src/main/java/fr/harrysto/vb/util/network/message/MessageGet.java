package fr.harrysto.vb.util.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.lwjgl.Sys;

public class MessageGet implements IMessage{

    public static String message;

    public MessageGet() {}

    public MessageGet(String player, String message) {
        this.message = message;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        message = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, message);
    }

    public static class Handler implements IMessageHandler<MessageGet, IMessage>{


        @Override
        public IMessage onMessage(MessageGet message, MessageContext ctx) {
            System.out.println(message.message);
            return null;
        }
    }

}
