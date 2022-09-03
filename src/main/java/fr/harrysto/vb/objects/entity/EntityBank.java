package fr.harrysto.vb.objects.entity;

import fr.harrysto.vb.main;
import fr.harrysto.vb.objects.gui.BankGUI;
import fr.harrysto.vb.util.network.MessagePlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityBank extends EntityCreature{

	public EntityBank(World worldIn) {
		super(worldIn);
		this.setSize(width, height);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.3D));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.5D, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);;
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
	}

	

	

}
