package fr.harrysto.vb.objects.gui.lockpick;

import fr.harrysto.vb.util.Reference;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.util.ResourceLocation;

public class FakeButtonCenter extends GuiButtonImage{
	
	private static int state;
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/pointeur.png");
	
	public FakeButtonCenter(int buttonID, int xPos, int yPos, int width, int height, int xTexStart, int yTexStart, int yDiffText, int state) {
		super(buttonID, xPos, yPos, width, height, xTexStart, yTexStart, yDiffText, TEXTURE);
		FakeButtonCenter.state = state;
	}
	
	private static String GetTextureLocation(int i) {
		switch (i) {

		default:
			return ":textures/gui/pointeur.png";
	
		}
	}
}
