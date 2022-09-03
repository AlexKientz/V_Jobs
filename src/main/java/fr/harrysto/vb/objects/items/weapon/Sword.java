package fr.harrysto.vb.objects.items.weapon;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class Sword extends Item implements IHasModel{
	
	public Sword(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(main.VALIENT_WEAPON);
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModel() {
		main.proxy.registerItemRenderer(this, 0);
	}

}
