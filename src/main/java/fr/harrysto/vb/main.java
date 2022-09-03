package fr.harrysto.vb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.harrysto.vb.util.network.message.MessageAdd;
import fr.harrysto.vb.util.network.message.MessageGet;
import fr.harrysto.vb.util.network.message.MessageSend;
import fr.harrysto.vb.util.network.message.MessageUpdate;
import fr.harrysto.vb.util.tabs.ValientTabs2;
import fr.harrysto.vb.util.tabs.ValientTabs3;
import org.lwjgl.input.Keyboard;

import fr.harrysto.vb.events.EntityEvents;
import fr.harrysto.vb.objects.gui.lockpick.lockgui;
import fr.harrysto.vb.proxy.CommonProxy;
import fr.harrysto.vb.util.Reference;
import fr.harrysto.vb.util.handlers.RegistryHandler;
import fr.harrysto.vb.util.network.MessageMoney;
import fr.harrysto.vb.util.network.MessageMoneyUpdate;
import fr.harrysto.vb.util.network.MessagePlayer;
import fr.harrysto.vb.util.tabs.ValientTabs;
import fr.harrysto.vb.util.tabs.ValientTabs1;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.client.config.GuiConfigEntries.ChatColorEntry;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleChannelHandlerWrapper;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import scala.sys.CreatorImpl;
import software.bernie.geckolib3.GeckoLib;
import sun.nio.ch.Net;


@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class main {
	
	public int port;

	@Instance
	public static main instance;

	public static CreativeTabs VALIENT_TAB = new ValientTabs("valient");
	public static CreativeTabs VALIENT_BLOCK = new ValientTabs2("block");
	public static CreativeTabs VALIENT_WEAPON = new ValientTabs1("weapon");
	public static CreativeTabs VALIENT_BUCHERON = new ValientTabs3("Bucheron");
	
	public static SimpleNetworkWrapper NETWORK;
	public static SimpleNetworkWrapper NETWORKINT;
	public static SimpleNetworkWrapper NETWORKUPDATE;
	public static SimpleNetworkWrapper getMessage;
	public static SimpleNetworkWrapper addMessage;

	public static SimpleNetworkWrapper updateMessage;
	public static SimpleNetworkWrapper sendMessage;

	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {		
		// BANK
		NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
		NETWORKINT = NetworkRegistry.INSTANCE.newSimpleChannel("moneyint");
		NETWORKUPDATE = NetworkRegistry.INSTANCE.newSimpleChannel("moneyupdate");
		updateMessage = NetworkRegistry.INSTANCE.newSimpleChannel("updatemessage");
		getMessage = NetworkRegistry.INSTANCE.newSimpleChannel("getmessage");
		addMessage = NetworkRegistry.INSTANCE.newSimpleChannel("addmessage");
		sendMessage = NetworkRegistry.INSTANCE.newSimpleChannel("sendMessage");
		NETWORK.registerMessage(MessagePlayer.Handler.class, MessagePlayer.class, 0, Side.CLIENT);
		NETWORKINT.registerMessage(MessageMoney.Handler.class, MessageMoney.class, 0, Side.CLIENT);
		NETWORKUPDATE.registerMessage(MessageMoneyUpdate.Handler.class, MessageMoneyUpdate.class, 0, Side.CLIENT);
		updateMessage.registerMessage(MessageUpdate.Handler.class, MessageUpdate.class, 0, Side.CLIENT);
		getMessage.registerMessage(MessageGet.Handler.class, MessageGet.class, 0, Side.CLIENT);
		addMessage.registerMessage(MessageAdd.Handler.class, MessageAdd.class, 0, Side.CLIENT);
		sendMessage.registerMessage(MessageSend.Handler.class, MessageSend.class, 0, Side.CLIENT);

		// SYNC
		MessageMoney.Handler.moneyOLD = 0;
		
		OBJLoader.INSTANCE.addDomain(Reference.MODID);
		proxy.preInit();
		RegistryHandler.preInitRegistries();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent e) {
		RegistryHandler.initRegistries();
		MinecraftForge.EVENT_BUS.register(new EntityEvents());
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e) {
	}
	

}
