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

public class MessageMoney implements IMessage{
	
	private static int money;
	
	public static int write;
	
	public MessageMoney() {}
	
	public MessageMoney(int money) {
		this.money = money;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		money = ByteBufUtils.readVarInt(buf, 5);
	}
	
	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeVarInt(buf, write, 5);
	}
	
	public static class Handler implements IMessageHandler<MessageMoney, IMessage>{
		
		public static int money;
		
		public static int moneyOLD;
		
		@Override
		public IMessage onMessage(MessageMoney message, MessageContext ctx) {
			System.out.println(message.money);
			money = message.money;
			moneyOLD = message.money;
			System.out.println(moneyOLD + "test");
			return null;
		}
	}

}
