package fr.harrysto.vb.util.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSend implements IMessage{

    public String player;
    public String message;
    public String playerfamilly;
    public String signature;

    public MessageSend() {}

    public MessageSend(String playername, String playerfamilly, String message, String signature) {
        this.player = playername;
        this.message = message;
        this.playerfamilly = playerfamilly;
        this.signature = signature;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        player = ByteBufUtils.readUTF8String(buf);
        playerfamilly = ByteBufUtils.readUTF8String(buf);
        message = ByteBufUtils.readUTF8String(buf);
        signature = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, player);
        ByteBufUtils.writeUTF8String(buf, message);
        ByteBufUtils.writeUTF8String(buf, playerfamilly);
        ByteBufUtils.writeUTF8String(buf, signature);
    }

    public static class Handler implements IMessageHandler<MessageSend, IMessage>{

        @Override
        public IMessage onMessage(MessageSend message, MessageContext ctx) {

            return null;
        }
    }

}
