package fr.harrysto.vb.init;

import java.util.ArrayList;
import java.util.List;


import fr.harrysto.vb.objects.armor.LoulouBody;
import fr.harrysto.vb.objects.items.ItemOpenBank;
import fr.harrysto.vb.objects.items.ItemPaper;
import fr.harrysto.vb.objects.items.bucheron.ItemBark;
import fr.harrysto.vb.objects.items.bucheron.ItemEcorceur;
import fr.harrysto.vb.objects.items.keys.ItemKeys;
import fr.harrysto.vb.objects.items.keys.ItemSpecialKeys;
import fr.harrysto.vb.objects.items.money.ItemValionArgent;
import fr.harrysto.vb.objects.items.money.ItemValionBrockenArgent;
import fr.harrysto.vb.objects.items.money.ItemValionBrockenBronze;
import fr.harrysto.vb.objects.items.money.ItemValionBrockenOr;
import fr.harrysto.vb.objects.items.money.ItemValionBronze;
import fr.harrysto.vb.objects.items.money.ItemValionMithril;
import fr.harrysto.vb.objects.items.money.ItemValionOr;
import fr.harrysto.vb.objects.items.weapon.Sword;
import fr.harrysto.vb.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import scala.Int;


public class ItemInit {
	
	public static List<Item> ITEMS = new ArrayList<Item>();

	public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial("timbur_armor", Reference.MODID + ":timbur_armor", 75, new int[] {3, 6, 8, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0f);
	
	public static final Item VALION_BRONZE = new ItemValionBronze("bronzecoin");
	public static final Item VALION_ARGENT = new ItemValionArgent("silvercoin");
	public static final Item VALION_OR = new ItemValionOr("orcoin");
	public static final Item VALION_MITHRIL = new ItemValionMithril("mithrilcoin");
	
	public static final Item VALION_BROCKEN_BRONZE = new ItemValionBrockenBronze("bronzebrocken");
	public static final Item VALION_BROCKEN_ARGENT = new ItemValionBrockenArgent("brockenargent");
	public static final Item VALION_BROCKEN_OR = new ItemValionBrockenOr("brockenor");

	public static final Item paper = new ItemPaper("paper");
	
	public static final Item KEYS = new ItemKeys("valientkeys");
	public static final Item SPECIAL_KEYS = new ItemSpecialKeys("valientkeyspecial");
	public static final Item CREATE_KEYS = new ItemKeys("create_key");




}

