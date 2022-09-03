package fr.harrysto.vb.objects.gui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.lwjgl.opengl.GL11;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.objects.gui.button.ButtonNextPage;
import fr.harrysto.vb.objects.gui.button.ButtonValidate;
import fr.harrysto.vb.util.Reference;
import fr.harrysto.vb.util.network.MessageMoney;
import fr.harrysto.vb.util.network.MessageMoneyUpdate;
import fr.harrysto.vb.util.network.MessagePlayer;
import ibxm.Player;
import net.java.games.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.network.ServerStatusResponse.Players;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import scala.swing.event.KeyTyped;

public class BankGUI extends GuiScreen {
	
	int guiWidth = 175;
	int guiHeight = 228;
	
	public static int money;
	public static int deposit = 0;
	public static int retrait = 0;	
	int ButtonValidateWidth = 13;
	int ButtonValienteHeight = 12;
		
	boolean Clicked1 = false;
	boolean Clicked2 = false;
	
	GuiButtonImage button1;
	GuiButtonImage button2;
	GuiButtonImage button3;
	GuiButtonImage button4;
	GuiButtonImage button5;
	GuiButtonImage button6;
	GuiButtonImage button7;
	
	
	
	GuiTextField textBox;
	
	private int state;
	
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		// Packet
			// END
	
		
		int GuiX = (width - guiWidth) / 30;
		int GuiY = (height - guiHeight) / 2;
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/bookbank1.png"));
		drawTexturedModalRect(GuiX, GuiY, 0, 0, guiWidth, guiHeight);
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.fontRenderer.drawString(MessageMoney.Handler.moneyOLD + " Vb", GuiX + 80, GuiY + 68, 0x000000);
		// Dépôt
		this.fontRenderer.drawString(deposit + " Vb", GuiX + 80, GuiY + 100, 0x000000);
		// Retrait
		this.fontRenderer.drawString(retrait + " Vb", GuiX + 80, GuiY + 145, 0x000000);
	}

	
	@Override
	public void initGui() {
		
		EntityPlayer p = Minecraft.getMinecraft().player;
	
		
		// GuiX / GuiY
		int GuiX = (width - guiWidth) / 30;
		int GuiY = (height - guiHeight) / 2;
		
		// Text
		
		// Button Validate/ChangePage
		buttonList.clear();
		buttonList.add(button1 = new ButtonValidate(0, GuiX + 85, GuiY + 200, 12, 13, 180, 36, 0, 0));
		
		// Button deposit
		buttonList.add(button1 = new ButtonValidate(2, GuiX + 75, GuiY + 115, 14, 16, 226, 1, 0, 0));
		buttonList.add(button1 = new ButtonValidate(3, GuiX + 90, GuiY + 114, 14, 16, 210, 1, 0, 0));
		
		// Button Retrait
		buttonList.add(button1 = new ButtonValidate(4, GuiX + 75, GuiY + 160, 14, 16, 226, 1, 0, 0));
		buttonList.add(button1 = new ButtonValidate(5, GuiX + 90, GuiY + 160, 14, 16, 210, 1, 0, 0));
		
		// Button change cat�gorie
		buttonList.add(button1 = new ButtonValidate(6, GuiX + 20, GuiY + 27, 65, 19, 181, 183, 0, 0));
		buttonList.add(button1 = new ButtonValidate(7, GuiX + 90, GuiY + 31, 73, 11, 181, 112, 0, 0));
		
		// Button close
		buttonList.add(button1 = new ButtonValidate(8, GuiX + 150, GuiY + 10, 13, 14, 197, 36, 0, 0));
		
		super.initGui();
		
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
		if(button.id == 0) {
			if(retrait == 0) {
				if(Minecraft.getMinecraft().player.inventory.getCurrentItem().getItem() == ItemInit.VALION_BRONZE && Minecraft.getMinecraft().player.inventory.getCurrentItem().getCount() <= deposit) {
					System.out.println("error");
				} else {
					if(Minecraft.getMinecraft().player.inventory.getCurrentItem().getItem() == ItemInit.VALION_BRONZE && Minecraft.getMinecraft().player.inventory.getCurrentItem().getCount() >= deposit) {
					Minecraft.getMinecraft().player.inventory.getCurrentItem().setCount(Minecraft.getMinecraft().player.inventory.getCurrentItem().getCount() - deposit);
					MessageMoneyUpdate.newMoney = MessageMoney.Handler.moneyOLD + deposit;
					EntityPlayer player = Minecraft.getMinecraft().player;				
					main.NETWORKUPDATE.sendToServer(new MessageMoneyUpdate(MessageMoneyUpdate.newMoney, player.getDisplayNameString()));
					main.NETWORK.sendToServer(new MessagePlayer(player.getDisplayNameString()));
					updateScreen();
					}
				}
			}
			if(deposit == 0) {
				// retrait
				if(MessageMoney.Handler.moneyOLD >= retrait) {
				Minecraft.getMinecraft().player.addItemStackToInventory(new ItemStack(ItemInit.VALION_BRONZE, retrait));
				MessageMoneyUpdate.newMoney = MessageMoney.Handler.moneyOLD - retrait;
				EntityPlayer player = Minecraft.getMinecraft().player;
				main.NETWORKUPDATE.sendToServer(new MessageMoneyUpdate(MessageMoneyUpdate.newMoney, player.getDisplayNameString()));
				main.NETWORK.sendToServer(new MessagePlayer(player.getDisplayNameString()));
				updateScreen();
				}
				
			}
			
			if(retrait > 0 && deposit > 0) {

				updateScreen();
			}
		}
		
		if(button.id == 2) {
			deposit = deposit + 1;
			updateScreen();
		}
		
		if(button.id == 3) {
			if(deposit == 0) {
				updateScreen();
			} else {
				deposit = deposit - 1;
				updateScreen();
			}
		}
		
		if(button.id == 4) {
			retrait = retrait + 1;
			updateScreen();
		}
		
		if(button.id == 5) {
			if(retrait == 0) {
				updateScreen();
			} else {
				retrait = retrait - 1;
				updateScreen();
			}
		}
		
		if(button.id == 7) {
			Minecraft.getMinecraft().displayGuiScreen(new ConvertGUI());
		}
		
		if(button.id == 8) {
			Minecraft.getMinecraft().player.closeScreen();
		}
		
		super.actionPerformed(button);
	}
	
	@Override
	protected void keyTyped(char c, int key) throws IOException {
		super.keyTyped(c, key);
	}
	
	
	@Override
	protected void mouseClicked(int x, int y, int button) throws IOException {
		super.mouseClicked(x, y, button);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		System.out.println("[ValientBank] Sent Packed for saving account");
	}
	

	

}
