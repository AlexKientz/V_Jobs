package fr.harrysto.vb.util.tabs;

import fr.harrysto.vb.init.BlockInit;
import fr.harrysto.vb.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ValientTabs2 extends CreativeTabs {

    public ValientTabs2(String label) {
        super(label);
        this.setBackgroundImageName(label + ".png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(BlockInit.TABLE);
    }

}
