package fr.harrysto.vb.objects.items.bucheron;

import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.main;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemEcorceur extends Item implements IHasModel {

    public ItemEcorceur(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(main.VALIENT_BUCHERON);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModel() {
        main.proxy.registerItemRenderer(this, 0);
    }

}
