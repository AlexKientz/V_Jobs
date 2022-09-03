package fr.harrysto.vb.objects.items.money;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.objects.gui.BankGUI;
import fr.harrysto.vb.util.interfaces.IHasModel;
import fr.harrysto.vb.util.network.MessageMoney;
import fr.harrysto.vb.util.network.MessagePlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemValionBronze extends Item implements IHasModel{
	
	public ItemValionBronze(String name) {
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
	public ActionResult<ItemStack> onItemRightClick(World worldin, EntityPlayer player, EnumHand hand){
		if(!worldin.isRemote) {
		} else {
			//Minecraft.getMinecraft().displayGuiScreen(new BankGUI());
			//main.NETWORK.sendToServer(new MessagePlayer(player.getDisplayNameString()));
			
		}
		return super.onItemRightClick(worldin, player, hand);
	}

}
