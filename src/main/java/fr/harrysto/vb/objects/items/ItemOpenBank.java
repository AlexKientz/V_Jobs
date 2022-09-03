package fr.harrysto.vb.objects.items;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.objects.gui.BankGUI;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemOpenBank extends Item implements IHasModel{
	
	public ItemOpenBank(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.REDSTONE);
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldin, EntityPlayer player, EnumHand hand){
		if(!worldin.isRemote) {
			player.sendMessage(new TextComponentString("Right clicked"));
		} else {
			Minecraft.getMinecraft().displayGuiScreen(new BankGUI());
		}
		return super.onItemRightClick(worldin, player, hand);
	}
	
	@Override
	public void registerModel() {
		main.proxy.registerItemRenderer(this, 0);
	}

}
