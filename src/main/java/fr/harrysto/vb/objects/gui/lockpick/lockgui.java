package fr.harrysto.vb.objects.gui.lockpick;

import java.io.IOException;
import java.util.Random;

import net.minecraft.util.text.TextComponentString;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import fr.harrysto.vb.objects.gui.button.ButtonValidate;
import fr.harrysto.vb.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class lockgui extends GuiScreen{
	
	int guiWidth = 250;
	int guiHeight = 250;
	
	boolean Clicked1 = false;
	boolean Clicked2 = false;
	
	GuiButtonImage button1;
	
	private int state;
	
	public static int x;
	public static int y;
	
	public static int rotate = 0;
	
	public static String texture = "textures/gui/circlelockpick.png";
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		int GuiX = (int) ((width - guiWidth) / 2);
		int GuiY = (height - guiHeight) / 2;
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glRotatef(+360, 0F, 0F, 0F);
		rotate();
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, texture));
		
		drawTexturedModalRect(GuiX, GuiY, 0, 0, guiWidth, guiHeight);
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.fontRenderer.drawString(x + ":" + y, GuiX + 80, GuiY + 220, 0xFFFFFF);
		this.fontRenderer.drawString(mouseX + ":" + mouseY, GuiX + 130, GuiY + 220, 0xFFFFFF);
		buttonList.clear();
		
		
		if(x == mouseX && y == mouseY) {
			buttonList.add(button1 = new FakeButtonCenter(1, mouseX, mouseY, 15, 15, 121, 101, 0, 25));
		
		} else {
			buttonList.clear();
			buttonList.add(button1 = new FakeButtonCenterClair(2, mouseX, mouseY, 15, 15, 157, 148, 0, 25));
			
		}
		
		if(mouseX > x + 3 || mouseX < x - 3 || mouseY > y + 3 || mouseY < y - 3) {
		} else {
			buttonList.clear();
			buttonList.add(button1 = new FakeButtonCenter(1, mouseX, mouseY, 15, 15, 121, 101, 0, 25));
		}
		
		
		updateScreen();
	
		
	}
	
	@Override
	public void initGui() {
		
		EntityPlayer p = Minecraft.getMinecraft().player;
		rotate = 0;
		int GuiX = (int) ((width - guiWidth) / 1.6);
		int GuiY = (height - guiHeight) / 1;
		
		double r = 159 * Math.sqrt(Math.random());
		double theta = Math.random() * 2 * Math.PI;
		
		
		x = (int) (136 + r * Math.cos(theta));
		y = (int) (134 + r * Math.sin(theta));
		
		int maxWeight = 270;
		int minWeight = 170;
		int maxHeight = 174;
		int minHeight = 83;
		
		
		if(x < minWeight || x > maxWeight || y < minHeight || y > maxHeight ) {
			Minecraft.getMinecraft().displayGuiScreen(new lockgui());
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException{

		if(button.id == 2) {
			rotate = 0;
			Minecraft.getMinecraft().displayGuiScreen(new lockgui());
		}
		if(rotate == 10){
			Minecraft.getMinecraft().displayGuiScreen(null);
			Minecraft.getMinecraft().player.sendMessage(new TextComponentString("[Valient] Crochetage terminé."));
		}
		
		if(button.id == 1) {
			rotate = rotate + 1;
			x = x + 2;
			y = y + 2;
		}
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
	}
	
	public void rotate() {
		if(rotate == 0) {
			texture = "textures/gui/circlelockpick.png";
		}
		if(rotate == 1) {
			texture = "textures/gui/circlelockpick1.png";
		}
		if(rotate == 2) {
			texture = "textures/gui/circlelockpick2.png";
		}
		if(rotate == 4) {
			texture = "textures/gui/circlelockpick4.png";
		}
		if(rotate == 5) {
			texture = "textures/gui/circlelockpick5.png";
		}
		if(rotate == 6) {
			texture = "textures/gui/circlelockpick6.png";
		}
		if(rotate == 7) {
			texture = "textures/gui/circlelockpick7.png";
		}
		if(rotate == 8) {
			texture = "textures/gui/circlelockpick8.png";
		}
		if(rotate == 9) {
			texture = "textures/gui/circlelockpick9.png";
		}
		if(rotate == 10) {
			texture = "textures/gui/circlelockpick10.png";
		}
		
	}
	
	public void checkClaimed() {
		// on vera plus tard !
	}
	

}
