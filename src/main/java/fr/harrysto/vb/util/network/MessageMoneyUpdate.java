package fr.harrysto.vb.util.network;

import fr.harrysto.vb.main;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import scala.reflect.runtime.ThreadLocalStorage.MyThreadLocalStorage;

public class MessageMoneyUpdate implements IMessage{
		
	public static int newMoney;
	
	public static int state;
	
	public static String player;
	
	public MessageMoneyUpdate() {}
	
	public MessageMoneyUpdate(int moneyOLD, String player) {
		this.state = moneyOLD;
		this.player = player;
		System.out.println("Classe appelé");
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		state = ByteBufUtils.readVarInt(buf, 5);
		player = ByteBufUtils.readUTF8String(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, newMoney, 5);
		ByteBufUtils.writeUTF8String(buf, player);
	}
	
	public static class Handler implements IMessageHandler<MessageMoneyUpdate, IMessage>{
		
		public static int money;
		
		@Override
		public IMessage onMessage(MessageMoneyUpdate message, MessageContext ctx) {
			
			return null;
		}
	}

}
