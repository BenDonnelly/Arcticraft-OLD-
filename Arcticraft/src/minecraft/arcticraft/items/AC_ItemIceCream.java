package arcticraft.items;

import java.util.List;

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
import arcticraft.main.AC_TickHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemIceCream extends ItemFood
{

	private static final String [] iceCreamFlavours =
		{"ac:Chocolate", "ac:Strawberry", "ac:Vanilla", "ac:Banana", "ac:Raspberry", "ac:Mint Choc Chip", "ac:Pistachio", "ac:Lemon Ice", "ac:Stracciatella", "ac:Bubblegum",};
	@SideOnly(Side.CLIENT)
	private Icon [] field_94594_d;

	public AC_ItemIceCream(int par1, int par2, float par3, boolean par4)
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
		int j = MathHelper.clamp_int(par1, 0, 10);
		return this.field_94594_d [j];
	}

	public String getItemDisplayName(ItemStack par1ItemStack)
	{
		String [] flavours = new String []
			{"Chocolate", "Strawberry", "Vanilla", "Banana", "Raspberry", "Mint Choc Chip", "Pistachio", "Lemon Ice", "Stracciatella", "Bubblegum"};

		return flavours [par1ItemStack.getItemDamage()] + " Ice Cream";
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack.getItemDamage() == 0)
		{
			par3List.add("Regeneration III (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}
		else if (par1ItemStack.getItemDamage() == 1)
		{
			par3List.add("Speed III (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}
		else if (par1ItemStack.getItemDamage() == 2)
		{
			par3List.add("Haste III (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}
		else if (par1ItemStack.getItemDamage() == 3)
		{
			par3List.add("Mining Fatigue III (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}
		else if (par1ItemStack.getItemDamage() == 4)
		{
			par3List.add("Strength III (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}
		else if (par1ItemStack.getItemDamage() == 5)
		{
			par3List.add("Jump III (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}
		else if (par1ItemStack.getItemDamage() == 6)
		{
			par3List.add("Resistance III (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}
		else if (par1ItemStack.getItemDamage() == 7)
		{
			par3List.add("Invisibility (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}
		else if (par1ItemStack.getItemDamage() == 8)
		{
			par3List.add("Night Vision III (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}
		else if(par1ItemStack.getItemDamage() == 9)
		{
			par3List.add("Water Breathing III (5:00)");
			par3List.add("Decrease Temperature By 30\u00B0C");
		}

	}

	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (!par2World.isRemote)
		{
			if (par1ItemStack.getItemDamage() == 0)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

			}
			else if (par1ItemStack.getItemDamage() == 1)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(1, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

			}
			else if (par1ItemStack.getItemDamage() == 2)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(3, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

			}
			else if (par1ItemStack.getItemDamage() == 3)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(4, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

			}
			else if (par1ItemStack.getItemDamage() == 4)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(5, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

			}
			else if (par1ItemStack.getItemDamage() == 5)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(8, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

			}
			else if (par1ItemStack.getItemDamage() == 6)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(11, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

			}
			else if (par1ItemStack.getItemDamage() == 7)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(14, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

			}
			else if (par1ItemStack.getItemDamage() == 8)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(16, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

			}
			else if (par1ItemStack.getItemDamage() == 9)
			{
				par3EntityPlayer.addPotionEffect(new PotionEffect(13, 6000, 2));
				if (AC_TickHandler.value <= 100 && AC_TickHandler.value >= 30)
				{
					AC_TickHandler.value -= 30;
				}
				else if (AC_TickHandler.value <= 29)
				{
					AC_TickHandler.value = 0;

				}

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
		for (int i = 0; i < 10; i++)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.field_94594_d = new Icon [iceCreamFlavours.length];

		for (int i = 0; i < iceCreamFlavours.length; ++i)
		{
			this.field_94594_d [i] = par1IconRegister.registerIcon(iceCreamFlavours [i]);
		}
	}

	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return par1ItemStack.getItemDamage() >= 0;
	}
}
