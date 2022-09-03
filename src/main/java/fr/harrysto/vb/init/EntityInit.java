package fr.harrysto.vb.init;

import fr.harrysto.vb.main;
import fr.harrysto.vb.objects.entity.EntityBank;
import fr.harrysto.vb.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("BankNPC", EntityBank.class, Reference.ENTITY_BANK, 50, 11437146, 000000);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, main.instance, range, 1, true, color1, color2);
	}

}
