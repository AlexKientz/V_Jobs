package fr.harrysto.vb.objects.armor;// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class body extends ModelBiped {
	private final ModelRenderer bucheronvest;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer LeftArm;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public body() {
		textureWidth = 64;
		textureHeight = 64;

		bucheronvest = new ModelRenderer(this);
		bucheronvest.setRotationPoint(1.9F, 12.0F, 0.0F);


		Body = new ModelRenderer(this);
		Body.setRotationPoint(-1.9F, -12.0F, 0.0F);
		bucheronvest.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 16, 32, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.25F, false));
		Body.cubeList.add(new ModelBox(Body, 1, 10, -3.1F, 8.3F, -2.2F, 7, 2, 4, 0.25F, false));
		Body.cubeList.add(new ModelBox(Body, 1, 2, -4.2F, 0.5F, -2.1F, 8, 7, 3, 0.25F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		Body.addChild(RightArm);
		RightArm.cubeList.add(new ModelBox(RightArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		RightArm.cubeList.add(new ModelBox(RightArm, 40, 32, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 14, -3.5F, 5.7F, 1.3F, 5, 1, 1, 0.0F, true));
		RightArm.cubeList.add(new ModelBox(RightArm, 6, 14, -3.5F, 5.7F, -2.3F, 5, 1, 1, 0.0F, true));
		RightArm.cubeList.add(new ModelBox(RightArm, 11, 14, -3.5F, 6.7F, 1.3F, 5, 1, 1, 0.0F, true));
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 14, -3.5F, 6.7F, -2.3F, 5, 1, 1, 0.0F, true));

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-3.0F, 7.2F, 0.3F);
		RightArm.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 6, 14, -2.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F, true));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 14, 14, -2.0F, -1.5F, -0.5F, 4, 1, 1, 0.0F, true));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 6, 14, -2.0F, -0.5F, 3.5F, 4, 1, 1, 0.0F, true));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 14, 14, -2.0F, -1.5F, 3.5F, 4, 1, 1, 0.0F, true));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-1.0F, 4.7F, -1.8F);
		RightArm.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 3.1416F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 39, 5, -2.5F, -2.0F, -0.5F, 5, 3, 1, 0.0F, true));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-1.0F, 4.7F, 1.8F);
		RightArm.addChild(cube_r3);
		setRotationAngle(cube_r3, -3.1416F, 0.0F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 39, 5, -2.5F, -2.0F, -0.5F, 5, 3, 1, 0.0F, true));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-1.0F, 4.7F, 1.8F);
		RightArm.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -1.5708F, 3.1416F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 40, 5, -3.5F, -2.0F, -2.5F, 4, 3, 1, 0.0F, true));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-1.0F, 4.7F, 1.2F);
		RightArm.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 1.5708F, 3.1416F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 40, 5, -0.5F, -2.0F, -2.5F, 4, 3, 1, 0.0F, true));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		Body.addChild(LeftArm);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 32, 48, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 48, 48, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.25F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 14, -1.5F, 6.7F, -2.3F, 5, 1, 1, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 11, 14, -1.5F, 6.7F, 1.3F, 5, 1, 1, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 6, 14, -1.5F, 4.7F, -2.3F, 5, 1, 1, 0.0F, false));
		LeftArm.cubeList.add(new ModelBox(LeftArm, 0, 14, -1.5F, 4.7F, 1.3F, 5, 1, 1, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(1.0F, 4.7F, 1.2F);
		LeftArm.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -1.5708F, -3.1416F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 40, 5, -3.5F, -2.0F, -2.5F, 4, 3, 1, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(1.0F, 4.7F, 1.8F);
		LeftArm.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 1.5708F, -3.1416F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 40, 5, -0.5F, -2.0F, -2.5F, 4, 3, 1, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(1.0F, 4.7F, 1.8F);
		LeftArm.addChild(cube_r8);
		setRotationAngle(cube_r8, -3.1416F, 0.0F, 0.0F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 39, 5, -2.5F, -2.0F, -0.5F, 5, 3, 1, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(1.0F, 4.7F, -1.8F);
		LeftArm.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -3.1416F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 39, 5, -2.5F, -2.0F, -0.5F, 5, 3, 1, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(3.0F, 5.2F, 0.3F);
		LeftArm.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, -1.5708F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 14, 14, -2.0F, -0.5F, 3.5F, 4, 1, 1, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 6, 14, -2.0F, 1.5F, 3.5F, 4, 1, 1, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 14, 14, -2.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 6, 14, -2.0F, 1.5F, -0.5F, 4, 1, 1, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		Body.addChild(RightLeg);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 0, 32, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		Body.addChild(LeftLeg);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 0, 48, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bucheronvest.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}