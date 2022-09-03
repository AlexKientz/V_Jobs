package fr.harrysto.vb.objects.blocks.coins;

import com.sun.org.apache.xerces.internal.xinclude.XIncludeHandler;
import fr.harrysto.vb.objects.gui.BankGUI;
import fr.harrysto.vb.objects.gui.MessageGUI;
import fr.harrysto.vb.util.Reference;
import fr.harrysto.vb.util.network.message.MessageUpdate;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

import fr.harrysto.vb.main;
import fr.harrysto.vb.init.BlockInit;
import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockTable extends Block implements IHasModel {

	public BlockTable(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(main.VALIENT_BLOCK);
		setHardness(40.0f);
		setResistance(40.0f);
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));
	}
	
	@Override
	public void registerModel() {
		GL11.glPushMatrix();
		GL11.glScalef(0.1F, 0.1F, 0.1F);
		main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
		GL11.glPopMatrix();
	}
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    public boolean IsNormalCube(IBlockState state) {
    	return false;
    }


}
