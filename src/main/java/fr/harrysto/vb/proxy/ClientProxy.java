package fr.harrysto.vb.proxy;

import fr.harrysto.vb.objects.armor.body;
import fr.harrysto.vb.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerItemRenderer(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

	public static body BODY;
	
	@Override
	public void registerEntityRenderers() {
		super.registerEntityRenderers();
	}
	
	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {
		// TODO Auto-generated method stub
		super.registerVariantRenderer(item, meta, filename, id);
	}

	
	@Override
	public void preInit() {
		BODY = new body();
		super.preInit();
	}
	
	public void registerModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}

}
