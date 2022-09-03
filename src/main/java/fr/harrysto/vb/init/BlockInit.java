package fr.harrysto.vb.init;

import java.util.ArrayList;
import java.util.List;

import fr.harrysto.vb.objects.blocks.coins.BlockTable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	
	public static List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block TABLE = new BlockTable("table", Material.ROCK);

}
