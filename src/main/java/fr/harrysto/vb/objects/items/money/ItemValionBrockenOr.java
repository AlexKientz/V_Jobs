package fr.harrysto.vb.objects.items.money;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemValionBrockenOr extends Item implements IHasModel{
	
	public ItemValionBrockenOr(String name) {
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
