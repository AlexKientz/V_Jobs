package fr.harrysto.vb.util.network.message;

import fr.harrysto.vb.main;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageAdd implements IMessage{

    public String player;
    public String message;

    public MessageAdd() {}

    public MessageAdd(String player, String message) {
        this.player = player;
        this.message = message;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        player = ByteBufUtils.readUTF8String(buf);
        message = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, player);
        ByteBufUtils.writeUTF8String(buf, message);
    }

    public static class Handler implements IMessageHandler<MessageAdd, IMessage>{

        @Override
        public IMessage onMessage(MessageAdd message, MessageContext ctx) {

            return null;
        }
    }

}
