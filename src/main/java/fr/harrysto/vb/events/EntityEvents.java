package fr.harrysto.vb.events;

import fr.harrysto.vb.init.BlockInit;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.objects.gui.MessageGUI;
import fr.harrysto.vb.util.network.message.MessageUpdate;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;

import fr.harrysto.vb.main;
import fr.harrysto.vb.objects.gui.BankGUI;
import fr.harrysto.vb.objects.gui.lockpick.lockgui;
import fr.harrysto.vb.util.Reference;
import fr.harrysto.vb.util.network.MessagePlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.KeyboardInputEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

@EventBusSubscriber(modid = Reference.MODID)
public class EntityEvents {

	@SubscribeEvent
	public void OpenBank(PlayerInteractEvent.EntityInteract event) {

		if (event.getTarget().getName().equals("entity.BankNPC.name")) {
			Minecraft.getMinecraft().displayGuiScreen(new BankGUI());

			EntityPlayer player = event.getEntityPlayer();

			main.NETWORK.sendToServer(new MessagePlayer(player.getDisplayNameString()));
		}

	}

	@SubscribeEvent
	public void OpenTable(PlayerInteractEvent.RightClickBlock event) {
		if (event.getWorld().getBlockState(event.getPos()) == BlockInit.TABLE.getDefaultState()) {
			EntityPlayer player = event.getEntityPlayer();
			Minecraft.getMinecraft().displayGuiScreen(new MessageGUI());
			main.updateMessage.sendToServer(new MessageUpdate(player.getDisplayNameString()));
		}
	}
}