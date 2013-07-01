package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemCaptainSword extends ItemSword
{

	public AC_ItemCaptainSword(int par1, EnumToolMaterial par2EnumToolMaterial)
	{
		super(par1, par2EnumToolMaterial);
	}

	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLiving mob, EntityLiving par3EntityLiving)
	{
		par1ItemStack.damageItem(2, par3EntityLiving);
		mob.addPotionEffect(new PotionEffect(Potion.poison.id, 600, 2));
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister)
	{
		if (this == MainRegistry.pirateSword)
		{
			this.iconIndex = par1IconRegister.registerIcon("AC:captainSword");
		}
	}
}
