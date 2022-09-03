package fr.harrysto.vb.objects.gui;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.lwjgl.opengl.GL11;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.objects.gui.button.ButtonConvert;
import fr.harrysto.vb.objects.gui.button.ButtonValidate;
import fr.harrysto.vb.objects.gui.lockpick.lockgui;
import fr.harrysto.vb.util.Reference;
import fr.harrysto.vb.util.network.MessageMoney;
import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

public class ConvertGUI extends GuiScreen {
	
	int guiWidth = 175;
	int guiHeight = 228;
	
	public int SelectedBronze;
	public int SelectedArgent;
	public int SelectedOr;
	public int SelectedMythril;
	
	public String String1 = "";
	public String String2 = "";
	
	public int Int1 = 0;
	public int Int2 = 0;
	
	public int selected;
	
	
	GuiButtonImage button1, button2;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		// Packet
			// END
	
		
		int GuiX = (width - guiWidth) / 30;
		int GuiY = (height - guiHeight) / 2;
		GL11.glColor4f(1, 1, 1, 1);
		drawDefaultBackground();
		mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/bookbank2.png"));
		drawTexturedModalRect(GuiX, GuiY, 0, 0, guiWidth, guiHeight);
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.fontRenderer.drawString(MessageMoney.Handler.moneyOLD + " Vb", GuiX + 80, GuiY + 68, 0x000000);
		// Convert Text
		this.fontRenderer.drawString(String1, GuiX + 42, GuiY + 150, 0x000000);
		this.fontRenderer.drawString(String2, GuiX + 132, GuiY + 150, 0x000000);
		this.fontRenderer.drawString("-->", GuiX + 86, GuiY + 140, 0x000000);
		// Convert Number
		this.fontRenderer.drawString(Int1 + "", GuiX + 42, GuiY + 130, 0x000000);
		this.fontRenderer.drawString(Int2 + "", GuiX + 132, GuiY + 130, 0x000000);
		//this.fontRenderer.drawString("-->", GuiX + 87, GuiY + 130, 0x000000);
	}
	
	@Override
	public void initGui() {
		int GuiX = (width - guiWidth) / 30;
		int GuiY = (height - guiHeight) / 2; 
		
		buttonList.clear();

				// Button close
				buttonList.add(button1 = new ButtonConvert(0, GuiX + 149, GuiY + 10, 15, 14, 196, 36, 0, 0));
		buttonList.add(button1 = new ButtonConvert(1, GuiX + 25, GuiY + 33, 56, 9, 181, 101, 0, 0));

		// Button Convert
		buttonList.add(button1 = new ButtonConvert(5, GuiX + 125, GuiY + 200, 12, 11, 211, 4, 0, 0));
		buttonList.add(button1 = new ButtonConvert(6, GuiX + 45, GuiY + 200, 11, 11, 227, 4, 0, 0));

		// Button Choose
		buttonList.add(button1 = new ButtonConvert(7, GuiX + 40, GuiY + 170, 17, 17, 180, 128, 17, 0));
		buttonList.add(button1 = new ButtonConvert(8, GuiX + 70, GuiY + 170, 17, 17, 200, 128, 17, 0));
		buttonList.add(button1 = new ButtonConvert(9, GuiX + 100, GuiY + 170, 17, 17, 180, 163, 17, 0));
		buttonList.add(button1 = new ButtonConvert(10, GuiX + 130, GuiY + 170, 17, 17, 200, 163, 17, 0));

		// Button Validate
		buttonList.add(button1 = new ButtonConvert(11, GuiX + 85, GuiY + 199, 15, 14, 179, 35, 0, 0));
		
		super.initGui();
	}
	
	@Override
	public void actionPerformed(GuiButton button) throws IOException{
		
		EntityPlayerSP player = Minecraft.getMinecraft().player;

		if(button.id == 0) {
			player.closeScreen();
		}
		
		if(button.id == 1) {
			Minecraft.getMinecraft().displayGuiScreen(new BankGUI());
		}
		
		if(button.id == 7 || button.id == 8 || button.id == 9 || button.id == 10) {
			if(selected == 0) {
				if(button.id == 7) {
					String1 = "VB";
					selected = 1;
					SelectedBronze = 1;
					updateScreen();
				}
				if(button.id == 8) {
					String1 = "VA";
					selected = 1;
					SelectedArgent = 1;
					updateScreen();
				}
				if(button.id == 9) {
					String1 = "VO";
					selected = 1;
					SelectedOr = 1;
					updateScreen();
				}
				if(button.id == 10) {
					String1 = "VM";
					selected = 1;
					SelectedMythril = 1;
					updateScreen();
				}
			}
			if(selected == 1) {
				if(button.id == 7) {
					if(SelectedBronze != 1) {
						String2 = "VB";
						selected = 0;
						SelectedBronze = 0;
						updateScreen();
					}
				}
				if(button.id == 8) {
					if(SelectedArgent != 1) {
						String2 = "VA";
						selected = 0;
						SelectedArgent = 0;
						updateScreen();
					}
				}
				if(button.id == 9) {
					if(SelectedOr != 1) {
						String2 = "VO";
						selected = 0;
						SelectedArgent = 0;
						updateScreen();
					}
				}
				if(button.id == 10) {
					if(SelectedMythril != 1) {
						String2 = "VM";
						selected = 0;
						SelectedMythril = 0;
						updateScreen();
					}
				}
			}
			
		}
		
		if(button.id == 5) {
				Int1 = Int1 - 1;
				if(String1.equals("VB")) {
					if(String2.equals("VA")) {
						Int2 = Int1 / 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VO")) {
						Int2 = Int1 / 100;	
						System.out.println(Int2);
					}
					if(String2.equals("VM")) {
						Int2 = Int1 / 1000;	
						System.out.println(Int2);
					}
					
				}
				
				if(String1.equals("VA")) {
					if(String2.equals("VB")) {
						Int2 = Int1 * 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VO")) {
						Int2 = Int1 / 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VM")) {
						Int2 = Int1 / 100;	
						System.out.println(Int2);
					}
					
				}
				
				if(String1.equals("VM")) {
					if(String2.equals("VB")) {
						Int2 = Int1 * 1000;	
						System.out.println(Int2);
					}
					if(String2.equals("VO")) {
						Int2 = Int1 * 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VA")) {
						Int2 = Int1 * 100;	
						System.out.println(Int2);
					}
					
				}
				
				if(String1.equals("VO")) {
					if(String2.equals("VB")) {
						Int2 = Int1 * 100;	
						System.out.println(Int2);
					}
					if(String2.equals("VA")) {
						Int2 = Int1 * 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VM")) {
						Int2 = Int1 / 10;	
						System.out.println(Int2);
					}
					
				}
		}
		
		if(button.id == 6) {
				Int1 = Int1 + 1;
				if(String1.equals("VB")) {
					if(String2.equals("VA")) {
						Int2 = Int1 / 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VO")) {
						Int2 = Int1 / 100;	
						System.out.println(Int2);
					}
					if(String2.equals("VM")) {
						Int2 = Int1 / 1000;	
						System.out.println(Int2);
					}
					
				}
				
				if(String1.equals("VA")) {
					if(String2.equals("VB")) {
						Int2 = Int1 * 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VO")) {
						Int2 = Int1 / 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VM")) {
						Int2 = Int1 / 100;	
						System.out.println(Int2);
					}
					
				}
				
				if(String1.equals("VM")) {
					if(String2.equals("VB")) {
						Int2 = Int1 * 1000;	
						System.out.println(Int2);
					}
					if(String2.equals("VO")) {
						Int2 = Int1 * 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VA")) {
						Int2 = Int1 * 100;	
						System.out.println(Int2);
					}
					
				}
				
				if(String1.equals("VO")) {
					if(String2.equals("VB")) {
						Int2 = Int1 * 100;	
						System.out.println(Int2);
					}
					if(String2.equals("VA")) {
						Int2 = Int1 * 10;	
						System.out.println(Int2);
					}
					if(String2.equals("VM")) {
						Int2 = Int1 / 10;	
						System.out.println(Int2);
					}
					
				}
		}
		
		if(button.id == 11) {
			if(String1.equals("VB")) {
				if(player.inventory.hasItemStack(new ItemStack(ItemInit.VALION_BRONZE))) {
					int count = 0;
					for(int i = 0; i < player.inventory.getSizeInventory(); i++) {
						if(player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).getItem() == ItemInit.VALION_BRONZE) {
							int money = player.inventory.getStackInSlot(i).getCount();
							System.out.println(money);
							System.out.println(Int1);
							
							int MoneyGive = money - Int1;
							
							if(String2.equals("VA")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_BRONZE, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_ARGENT, Int2));
							}
							if(String2.equals("VO")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_BRONZE, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_OR, Int2));
							}
							if(String2.equals("VM")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_BRONZE, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_MITHRIL, Int2));
							}
							
							count++;
							if(count > 8) {
								break;
							}
						}
					}
				}
			}
			
			if(String1.equals("VA")) {
				if(player.inventory.hasItemStack(new ItemStack(ItemInit.VALION_ARGENT))) {
					int count = 0;
					for(int i = 0; i < player.inventory.getSizeInventory(); i++) {
						if(player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).getItem() == ItemInit.VALION_ARGENT) {
							int money = player.inventory.getStackInSlot(i).getCount();
							System.out.println(money);
							System.out.println(Int1);
							
							int MoneyGive = money - Int1;
							
							if(String2.equals("VB")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_ARGENT, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_BRONZE, Int2));
							}
							if(String2.equals("VO")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_ARGENT, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_OR, Int2));
							}
							if(String2.equals("VM")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_ARGENT, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_MITHRIL, Int2));
							}
							
							count++;
							if(count > 8) {
								break;
							}
						}
					}
				}
				
			}
			
			if(String1.equals("VO")) {
				if(player.inventory.hasItemStack(new ItemStack(ItemInit.VALION_OR))) {
					int count = 0;
					for(int i = 0; i < player.inventory.getSizeInventory(); i++) {
						if(player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).getItem() == ItemInit.VALION_OR) {
							int money = player.inventory.getStackInSlot(i).getCount();
							System.out.println(money);
							System.out.println(Int1);
							
							int MoneyGive = money - Int1;
							
							
							if(String2.equals("VB")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_OR, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_BRONZE, Int2));
							}
							if(String2.equals("VA")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_OR, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_ARGENT, Int2));
							}
							if(String2.equals("VM")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_MITHRIL, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_MITHRIL, Int2));
							}
							
							count++;
							if(count > 8) {
								break;
							}
						}
					}
				}
				
			}
			
			if(String1.equals("VM")) {
				if(player.inventory.hasItemStack(new ItemStack(ItemInit.VALION_MITHRIL))) {
					int count = 0;
					for(int i = 0; i < player.inventory.getSizeInventory(); i++) {
						if(player.inventory.getStackInSlot(i) != null && player.inventory.getStackInSlot(i).getItem() == ItemInit.VALION_MITHRIL) {
							int money = player.inventory.getStackInSlot(i).getCount();
							System.out.println(money);
							System.out.println(Int1);
							
							int MoneyGive = money - Int1;
							
							if(String2.equals("VB")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_MITHRIL, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_BRONZE, Int2));
							}
							if(String2.equals("VA")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_MITHRIL, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_ARGENT, Int2));
							}
							if(String2.equals("VO")) {
								player.inventory.setInventorySlotContents(i, new ItemStack(ItemInit.VALION_MITHRIL, MoneyGive));
								player.inventory.addItemStackToInventory(new ItemStack(ItemInit.VALION_OR, Int2));
							}
							
							count++;
							if(count > 8) {
								break;
							}
						}
					}
				}
				
			}
			
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
	}

}
