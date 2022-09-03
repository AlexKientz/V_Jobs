package fr.harrysto.vb.util.handlers;

import fr.harrysto.vb.objects.entity.EntityBank;
import fr.harrysto.vb.objects.entity.RenderNPC;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
	
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityBank.class, new IRenderFactory<EntityBank>() {

			@Override
			public Render<? super EntityBank> createRenderFor(RenderManager manager) {
				return new RenderNPC(manager);
			}
			
			
		});
	}

}
