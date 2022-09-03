package fr.harrysto.vb.objects.items.money;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemValionArgent extends Item implements IHasModel{
	
	public ItemValionArgent(String name) {
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
