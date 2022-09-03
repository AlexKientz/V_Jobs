package fr.harrysto.vb.objects.items;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemPaper extends Item implements IHasModel{

    public ItemPaper(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(main.VALIENT_TAB);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModel() {
        main.proxy.registerItemRenderer(this, 0);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        ItemStack stack = playerIn.getHeldItem(handIn);
        NBTTagCompound nbt = stack.getTagCompound();
        if(nbt != null) {
            System.out.println(nbt.getString("message"));
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString(nbt.getString("message")));
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
