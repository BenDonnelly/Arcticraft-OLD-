package com.arcticraft.enums;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class AC_EnumArmourMaterial {
	//name, durability, reductionAmounts, enchantability
	
	public static ArmorMaterial TekkiteArmour = EnumHelper.addArmorMaterial("Tekkite", 15, new int[]{2, 6, 5, 2}, 30);
	
	public static ArmorMaterial EscariaArmour = EnumHelper.addArmorMaterial("Escaria", 18, new int[]{4, 6, 4, 3}, 6);
	
	public static ArmorMaterial RigentemArmour = EnumHelper.addArmorMaterial("Rigentem", 18, new int[]{3, 6, 5, 3}, 16);
	
	public static ArmorMaterial GlacianArmour =  EnumHelper.addArmorMaterial("Glacian", 36, new int[]{3, 8, 6, 3}, 23);
	
	public static ArmorMaterial PirateArmour = EnumHelper.addArmorMaterial("Pirate Armor", 33, new int[] {1 , 3 , 2 , 1}, 15);
}
