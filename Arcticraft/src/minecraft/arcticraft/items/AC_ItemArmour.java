package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class AC_ItemArmour extends ItemArmor
{

	public AC_ItemArmour(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{

		if(stack.itemID == AC_Item.TekkiteHelmet.itemID || stack.itemID == AC_Item.TekkitePlate.itemID || stack.itemID == AC_Item.TekkiteBoots.itemID)
		{
			return "ac:textures/armour/tektite_1.png";
		}
		if(stack.itemID == AC_Item.TekkiteLegs.itemID)
		{
			return "ac:textures/armour/tektite_2.png";
		}

		if(stack.itemID == AC_Item.EscariaHelmet.itemID || stack.itemID == AC_Item.EscariaPlate.itemID || stack.itemID == AC_Item.EscariaBoots.itemID)
		{
			return "ac:textures/armour/escaria_1.png";
		}

		if(stack.itemID == AC_Item.EscariaLegs.itemID)
		{
			return "ac:textures/armour/escaria_2.png";
		}

		if(stack.itemID == AC_Item.RigentemHelmet.itemID || stack.itemID == AC_Item.RigentemPlate.itemID || stack.itemID == AC_Item.RigentemBoots.itemID)
		{
			return "ac:textures/armour/rigentem_1.png";
		}

		if(stack.itemID == AC_Item.RigentemLegs.itemID)
		{
			return "ac:textures/armour/rigentem_2.png";
		}

		if(stack.itemID == AC_Item.GlacianHelmet.itemID || stack.itemID == AC_Item.GlacianPlate.itemID || stack.itemID == AC_Item.GlacianBoots.itemID)
		{
			return "ac:textures/armour/glacians_1.png";
		}

		if(stack.itemID == AC_Item.GlacianLegs.itemID)
		{
			return "ac:textures/armour/glacians_2.png";
		}

		if(stack.itemID == AC_Item.pirateHat.itemID)
		{
			return "ac:textures/armour/piratehat.png";
		}

		if(stack.itemID == AC_Item.hikingBoots.itemID)
		{
			return "ac:textures/armour/hiking_boots.png";
		}

		else
			return null;
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{

		if(this == AC_Item.TekkiteHelmet)
		{
			itemIcon = iconRegister.registerIcon("ac:tekkite_helm");
		}

		if(this == AC_Item.TekkitePlate)
		{
			itemIcon = iconRegister.registerIcon("ac:tekkite_plate");
		}

		if(this == AC_Item.TekkiteLegs)
		{
			itemIcon = iconRegister.registerIcon("ac:tekkite_legs");
		}

		if(this == AC_Item.TekkiteBoots)
		{
			itemIcon = iconRegister.registerIcon("ac:tekkite_boots");
		}

		if(this == AC_Item.EscariaHelmet)
		{
			itemIcon = iconRegister.registerIcon("ac:escaria_helm");
		}

		if(this == AC_Item.EscariaPlate)
		{
			itemIcon = iconRegister.registerIcon("ac:escaria_plate");
		}

		if(this == AC_Item.EscariaLegs)
		{
			itemIcon = iconRegister.registerIcon("ac:escaria_legs");
		}

		if(this == AC_Item.EscariaBoots)
		{
			itemIcon = iconRegister.registerIcon("ac:escaria_boots");
		}

		if(this == AC_Item.RigentemHelmet)
		{
			itemIcon = iconRegister.registerIcon("ac:rigentem_helm");
		}

		if(this == AC_Item.RigentemPlate)
		{
			itemIcon = iconRegister.registerIcon("ac:rigentem_plate");
		}

		if(this == AC_Item.RigentemLegs)
		{
			itemIcon = iconRegister.registerIcon("ac:rigentem_legs");
		}

		if(this == AC_Item.RigentemBoots)
		{
			itemIcon = iconRegister.registerIcon("ac:rigentem_boots");
		}

		if(this == AC_Item.GlacianHelmet)
		{
			itemIcon = iconRegister.registerIcon("ac:glacian_helm");
		}

		if(this == AC_Item.GlacianPlate)
		{
			itemIcon = iconRegister.registerIcon("ac:glacian_plate");
		}

		if(this == AC_Item.GlacianLegs)
		{
			itemIcon = iconRegister.registerIcon("ac:glacian_legs");
		}

		if(this == AC_Item.GlacianBoots)
		{
			itemIcon = iconRegister.registerIcon("ac:glacian_boots");
		}

		if(this == AC_Item.pirateHat)
		{
			itemIcon = iconRegister.registerIcon("ac:pirate_hat_icon");
		}

		if(this == AC_Item.hikingBoots)
		{
			itemIcon = iconRegister.registerIcon("ac:hiking_boots");
		}
	}
}
