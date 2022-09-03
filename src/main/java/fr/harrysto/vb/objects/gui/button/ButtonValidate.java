package fr.harrysto.vb.objects.gui.button;

import fr.harrysto.vb.util.Reference;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.util.ResourceLocation;

public class ButtonValidate extends GuiButtonImage{
	
	private static int state;
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/bookbank1.png");
	
	public ButtonValidate(int buttonID, int xPos, int yPos, int width, int height, int xTexStart, int yTexStart, int yDiffText, int state) {
		super(buttonID, xPos, yPos, width, height, xTexStart, yTexStart, yDiffText, TEXTURE);
		ButtonValidate.state = state;
	}
	
	private static String GetTextureLocation(int i) {
		switch (i) {

		default:
			return ":textures/gui/bookbank1.png";
	
		}
	}
}
