package com.arcticraft.enums;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class AC_EnumToolMaterial {
	/**Params go as follows : name, durability, reductionAmounts, enchantability**/

	public static ToolMaterial TekkiteTool = EnumHelper.addToolMaterial("Tekkite Tool", 3, 1634, 8.3F, 4.0F, 22); //Best tools
	
	public static ToolMaterial EscariaTool = EnumHelper.addToolMaterial("Escaria Tool", 0, 140, 12.0F, 0.5F, 23); //worse tools, fast tho 
	
	public static ToolMaterial RigentemTool = EnumHelper.addToolMaterial("Rigentem Tool", 2, 500, 7.0F, 3.0F, 15); //third best tools
	
	public static ToolMaterial GlacianTool = EnumHelper.addToolMaterial("Glacian Tool", 3, 1400, 9.0F, 5.0F, 13);//second best tools

	public static ToolMaterial notchedPickaxeMaterial = EnumHelper.addToolMaterial("Notched Pickaxe", 3, 1000, 5.0F, 2.0F, 25);
	
	public static ToolMaterial ignisBladeMaterial = EnumHelper.addToolMaterial("Ignis Blade", 3, 750, 4.0F, 5.0F, 25);
}
