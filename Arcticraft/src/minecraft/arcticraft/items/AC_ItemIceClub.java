package arcticraft.items;

import arcticraft.main.MainRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class AC_ItemIceClub extends ItemSword
{

	public AC_ItemIceClub(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		par2EntityLivingBase.addPotionEffect(new PotionEffect(MainRegistry.freezePotion.id, 1000, 1));
		return true;
	}
	
}
