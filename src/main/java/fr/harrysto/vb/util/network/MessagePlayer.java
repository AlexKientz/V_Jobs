package fr.harrysto.vb.util.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessagePlayer implements IMessage{
	
	private static String player;
	
	public MessagePlayer() {}
	
	public MessagePlayer(String player) {
		this.player = player;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		player = ByteBufUtils.readUTF8String(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, player);
	}
	
	public static class Handler implements IMessageHandler<MessagePlayer, IMessage>{
		
		public static String Player;
		
		@Override
		public IMessage onMessage(MessagePlayer message, MessageContext ctx) {
			System.out.println(message.player);
			return null;
		}
	}

}
