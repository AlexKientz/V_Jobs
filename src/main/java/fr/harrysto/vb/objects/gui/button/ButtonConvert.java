package fr.harrysto.vb.objects.gui.button;

import fr.harrysto.vb.util.Reference;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.util.ResourceLocation;

public class ButtonConvert extends GuiButtonImage{
	
	private static int state;
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/bookbank2.png");
	
	public ButtonConvert(int buttonID, int xPos, int yPos, int width, int height, int xTexStart, int yTexStart, int yDiffText, int state) {
		super(buttonID, xPos, yPos, width, height, xTexStart, yTexStart, yDiffText, TEXTURE);
		ButtonConvert.state = state;
	}
	
	private static String GetTextureLocation(int i) {
		switch (i) {

		default:
			return ":textures/gui/bookbank2.png";
	
		}
	}
}
