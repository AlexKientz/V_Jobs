package fr.harrysto.vb.objects.entity;

import fr.harrysto.vb.util.Reference;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderNPC extends RenderLiving<EntityBank>{
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/entity/test/npc.png");
	
	public RenderNPC(RenderManager manager) {
		super(manager, new ModelHumanoidHead(), 0.2f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityBank entity) {
		return TEXTURE;
	}

}
