package fr.harrysto.vb.init;

import akka.dispatch.sysmsg.Create;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeybindsInit {
	public static KeyBinding gaucheKey;
	
	public static void register(final FMLClientHandler event) {
	
	}
}
