package fr.harrysto.vb.util.tabs;

import fr.harrysto.vb.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ValientTabs3 extends CreativeTabs {

    public ValientTabs3(String label) {
        super(label);
        this.setBackgroundImageName(label + ".png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.VALION_BRONZE);
    }

}
