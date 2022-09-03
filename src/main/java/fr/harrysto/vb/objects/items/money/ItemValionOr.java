package fr.harrysto.vb.objects.items.money;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.util.Reference;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.lwjgl.opengl.GL11;

public class ItemValionOr extends Item implements IHasModel{
	
	public ItemValionOr(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(main.VALIENT_TAB);
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModel() {
		GL11.glPushMatrix();
		GL11.glScalef(0.001F, 0.001F, 0.001F);
		main.proxy.registerItemRenderer(this, 0);
		GL11.glPopMatrix();
	}

	
	public static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
