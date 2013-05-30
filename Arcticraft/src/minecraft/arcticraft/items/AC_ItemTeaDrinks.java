package arcticraft.items;

import java.util.List;

import arcticraft.main.AC_TickHandler;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemTeaDrinks extends ItemFood
{

	private static final String [] teaFlavours =
		{"AC:red_tea", "AC:hot_chocolate", "AC:floran_tea"};
	@SideOnly(Side.CLIENT)
	private Icon [] teaField;
	



	public AC_ItemTeaDrinks(int par1, int par2, float par3, boolean par4)
	{
		super(par1, par2, par3, par4);
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Gets an icon index based on an item's damage value
	 */
	public Icon getIconFromDamage(int par1)
	{
		int j = MathHelper.clamp_int(par1, 0, 15);
		return this.teaField [j];
	}

	public String getItemDisplayName(ItemStack par1ItemStack)//test
	{
		String [] teaflavours = new String []
			{"Red Tea", "Hot Chocolate"};

		return teaflavours [par1ItemStack.getItemDamage()];
	}

	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par2World.isRemote)
		{
			if (par1ItemStack.getItemDamage() == 0)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 3));
			
			}
			else if(par1ItemStack.getItemDamage() == 1)
			{
				AC_TickHandler.value += 30;
				System.out.println("value");
			}
		}
		else
		{
			super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < 2; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister)
	{
		this.teaField = new Icon [teaFlavours.length];

		for (int i = 0; i < teaFlavours.length; ++i)
		{
			this.teaField [i] = par1IconRegister.registerIcon(teaFlavours [i]);
		}
	}
}
