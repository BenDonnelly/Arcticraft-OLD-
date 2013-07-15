package arcticraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_ItemRecord extends ItemRecord
{

	/** The name of the record. */
	public final String recordName;

	public AC_ItemRecord(int ID, String par2Str)
	{
		super(ID, par2Str);
		this.recordName = par2Str;
		this.setCreativeTab(MainRegistry.tabMisc);
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Gets an icon index based on an item's damage value
	 */
	public Icon getIconFromDamage(int par1)
	{
		return this.itemIcon;
	}

	/**
	 * Return the title for this record.
	 */
	public String getRecordTitle()
	{
		return "Ben Porayko - " + this.recordName;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Return an item rarity from EnumRarity
	 */
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return EnumRarity.rare;
	}

	@SideOnly(Side.CLIENT)
	public void updateIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("AC:record_" + this.recordName);
	}

}
