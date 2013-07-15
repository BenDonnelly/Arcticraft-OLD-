package arcticraft.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public static List<String> recordNames = new ArrayList<String>();
	
	public AC_ItemRecord(int ID, String par2Str)
	{
		super(ID, par2Str);
		recordNames.add(this.recordName);
		this.setCreativeTab(MainRegistry.tabMisc);
	}
	
	@Override
	public String getRecordTitle()
	{
		return "Voog2 - " + this.recordName;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon("ac:record_" + this.recordName);
	}

}
