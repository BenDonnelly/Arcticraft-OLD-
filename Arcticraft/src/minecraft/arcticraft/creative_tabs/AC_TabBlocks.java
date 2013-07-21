package arcticraft.creative_tabs;

import net.minecraft.creativetab.CreativeTabs;
import arcticraft.blocks.AC_Block;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_TabBlocks extends CreativeTabs
{

	public AC_TabBlocks(int position, String tabID)
	{
		super(position, tabID);
	}

	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return AC_Block.frostGrass.blockID;
	}

	public String getTranslatedTabLabel()
	{
		return "Arcticraft Blocks";
	}
}
