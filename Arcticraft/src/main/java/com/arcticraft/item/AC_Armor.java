package com.arcticraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.arcticraft.lib.Strings;

public class AC_Armor extends ItemArmor{

	public AC_Armor(ArmorMaterial material, int par2, int par3) {
		super(material, par2, par3);
		// TODO Auto-generated constructor stub
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

		if (stack.getItem() == AC_Item.TekkiteHelmet || stack.getItem() == AC_Item.TekkitePlate || stack.getItem() == AC_Item.TekkiteBoots) {
			return Strings.MODID + ":textures/armour/tektite_1.png";
		}else if(stack.getItem() == AC_Item.TekkiteLegs){
			return Strings.MODID + ":textures/armour/tektite_2.png";
		}else if (stack.getItem() == AC_Item.EscariaHelmet || stack.getItem() == AC_Item.EscariaPlate || stack.getItem() == AC_Item.EscariaBoots) {
			return Strings.MODID + ":textures/armour/glacians_1.png";
		}else if(stack.getItem() == AC_Item.EscariaLegs){
			return Strings.MODID + ":textures/armour/glacians_2.png";
		}else if (stack.getItem() == AC_Item.GlacianHelmet || stack.getItem() == AC_Item.GlacianPlate || stack.getItem() == AC_Item.GlacianBoots) {
			return Strings.MODID + ":textures/armour/glacians_1.png";
		}else if(stack.getItem() == AC_Item.GlacianLegs){
			return Strings.MODID + ":textures/armour/glacians_2.png";
		}else if (stack.getItem() == AC_Item.RigentemHelmet || stack.getItem() == AC_Item.RigentemPlate || stack.getItem() == AC_Item.RigentemBoots) {
			return Strings.MODID + ":textures/armour/rigentem_1.png";
		}else if(stack.getItem() == AC_Item.RigentemLegs){
			return Strings.MODID + ":textures/armour/rigentem_2.png";
		}else if(stack.getItem() == AC_Item.pirateHat){
			return Strings.MODID + ":textures/armour/pirate_hat.png";
		}else{
			return null;
		}
	}

}
