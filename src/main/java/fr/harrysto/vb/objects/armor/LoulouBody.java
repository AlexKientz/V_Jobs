package fr.harrysto.vb.objects.armor;

import fr.harrysto.vb.init.ItemInit;
import fr.harrysto.vb.main;
import fr.harrysto.vb.proxy.ClientProxy;
import fr.harrysto.vb.util.interfaces.IHasModel;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LoulouBody extends ItemArmor implements IHasModel {
    public LoulouBody(String name, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, 1, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(main.VALIENT_WEAPON);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModel() {
        main.proxy.registerItemRenderer(this, 0);
    }

    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default)
    {
        if(itemStack != ItemStack.EMPTY)
        {
            if(itemStack.getItem() instanceof ItemArmor)
            {
                body model = new body();

                model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;

                model.isChild = _default.isChild;
                model.isRiding = _default.isRiding;
                model.isSneak = _default.isSneak;
                model.rightArmPose = _default.rightArmPose;
                model.leftArmPose = _default.leftArmPose;

                return model;
            }
        }

        return null;
    }
}

