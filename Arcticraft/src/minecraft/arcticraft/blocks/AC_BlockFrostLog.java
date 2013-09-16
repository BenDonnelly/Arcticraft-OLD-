package arcticraft.blocks;

import java.util.Random;

import arcticraft.main.AC_Achievements;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class AC_BlockFrostLog extends Block
{

	public Icon frostLogTopBottom;
	public Icon frostLogSide;

	public AC_BlockFrostLog(int par1)
	{
		super(par1, Material.wood);

	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType()
	{
		return 31;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random)
	{
		return 1;
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an update, as appropriate
	 */
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		byte var7 = 4;
		int var8 = var7 + 1;

		if(par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
		{
			for(int var9 = - var7; var9 <= var7; ++var9)
			{
				for(int var10 = - var7; var10 <= var7; ++var10)
				{
					for(int var11 = - var7; var11 <= var7; ++var11)
					{
						int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);

						if(Block.blocksList[var12] != null)
						{
							Block.blocksList[var12].beginLeavesDecay(par1World, par2 + var9, par3 + var10, par4 + var11);
						}
					}
				}
			}
		}
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? frostLogTopBottom : (par1 == 0 ? frostLogTopBottom : frostLogSide);
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		frostLogSide = par1IconRegister.registerIcon("ac:frost_log_side");
		frostLogTopBottom = par1IconRegister.registerIcon("ac:frost_log_top_bottom");
		frostLogTopBottom = par1IconRegister.registerIcon("ac:frost_log_top_bottom");

	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean isWood(World world, int x, int y, int z)
	{
		return true;
	}

}
