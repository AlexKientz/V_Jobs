package fr.harrysto.vb.objects.items.keys;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemKeys extends Item implements IHasModel{
	
	public ItemKeys(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(main.VALIENT_TAB);
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModel() {
		main.proxy.registerItemRenderer(this, 0);
	}

}
