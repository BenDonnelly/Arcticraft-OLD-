package arcticraft.gen; 

import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import arcticraft.main.MainRegistry;

public class AC_GenArcaneStone2 extends WorldGenerator
{
	/** The block ID of the ore to be placed using this generator. */
	private int minableBlockId;
	/** The number of blocks to generate. */
	private int numberOfBlocks;
	public AC_GenArcaneStone2(int par1, int par2)
	{
		minableBlockId = par1;
		numberOfBlocks = par2;
	}
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		float f = par2Random.nextFloat() * (float)Math.PI;
		double d = (float)(par3 + 8) + (MathHelper.sin(f) * (float)numberOfBlocks) / 8F;
		double d1 = (float)(par3 + 8) - (MathHelper.sin(f) * (float)numberOfBlocks) / 8F;
		double d2 = (float)(par5 + 8) + (MathHelper.cos(f) * (float)numberOfBlocks) / 8F;
		double d3 = (float)(par5 + 8) - (MathHelper.cos(f) * (float)numberOfBlocks) / 8F;
		double d4 = (par4 + par2Random.nextInt(3)) - 2;
		double d5 = (par4 + par2Random.nextInt(3)) - 2;
		for (int i = 0; i <= numberOfBlocks; i++)
		{
			double d6 = d + ((d1 - d) * (double)i) / (double)numberOfBlocks;
			double d7 = d4 + ((d5 - d4) * (double)i) / (double)numberOfBlocks;
			double d8 = d2 + ((d3 - d2) * (double)i) / (double)numberOfBlocks;
			double d9 = (par2Random.nextDouble() * (double)numberOfBlocks) / 16D;
			double d10 = (double)(MathHelper.sin(((float)i * (float)Math.PI) / (float)numberOfBlocks) + 1.0F) * d9 + 1.0D;
			double d11 = (double)(MathHelper.sin(((float)i * (float)Math.PI) / (float)numberOfBlocks) + 1.0F) * d9 + 1.0D;
			int j = MathHelper.floor_double(d6 - d10 / 2D);
			int k = MathHelper.floor_double(d7 - d11 / 2D);
			int l = MathHelper.floor_double(d8 - d10 / 2D);
			int i1 = MathHelper.floor_double(d6 + d10 / 2D);
			int j1 = MathHelper.floor_double(d7 + d11 / 2D);
			int k1 = MathHelper.floor_double(d8 + d10 / 2D);
			for (int l1 = j; l1 <= i1; l1++)
			{
				double d12 = (((double)l1 + 0.5D) - d6) / (d10 / 2D);
				if (d12 * d12 >= 1.0D)
				{
					continue;
				}
				for (int i2 = k; i2 <= j1; i2++)
				{
					double d13 = (((double)i2 + 0.5D) - d7) / (d11 / 2D);
					if (d12 * d12 + d13 * d13 >= 1.0D)
					{
						continue;
					}
					for (int j2 = l; j2 <= k1; j2++)
					{
						double d14 = (((double)j2 + 0.5D) - d8) / (d10 / 2D);
						if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D && par1World.getBlockId(l1, i2, j2) == MainRegistry.frostGrass.blockID)
						{
							par1World.setBlock(l1, i2, j2, minableBlockId);
						}
					}
				}
			}
		}
		return true;
	}

	public void populate(IChunkProvider par1IChunkProvider, World par1World, Random par2Random, int par3, int par4, int par5)
	{
		if (!par1World.isAirBlock(par3, par4, par5))
		{
			return;
		}
		if (par1World.getBlockId(par3, par4 - 1, par5) != MainRegistry.frostGrass.blockID)
		{
			return;
		}
		else if (par1World.getBlockId(par3, par4 + 1, par5) != MainRegistry.frostStone.blockID)
		{
			return;
		}

		par1World.setBlock(par3, par4, par5, MainRegistry.arcaneStone.blockID);
		for (int i = 0; i < 1500; i++)
		{
			int j = (par3 + par2Random.nextInt(8)) - par2Random.nextInt(8);
			int k = par4 - par2Random.nextInt(12);
			int l = (par5 + par2Random.nextInt(8)) - par2Random.nextInt(8);
			if (par1World.getBlockId(j, k, l) != 0)
			{
				continue;
			}
			int i1 = 0;
			for (int j1 = 0; j1 < 6; j1++)
			{
				int k1 = 0;
				if (j1 == 0)
				{
					k1 = par1World.getBlockId(j - 1, k, l);
				}
				if (j1 == 1)
				{
					k1 = par1World.getBlockId(j + 1, k, l);
				}
				if (j1 == 2)
				{
					k1 = par1World.getBlockId(j, k - 1, l);
				}
				if (j1 == 3)
				{
					k1 = par1World.getBlockId(j, k + 1, l);
				}
				if (j1 == 4)
				{
					k1 = par1World.getBlockId(j, k, l - 1);
				}
				if (j1 == 5)
				{
					k1 = par1World.getBlockId(j, k, l + 1);
				}
				if (k1 == MainRegistry.arcaneStone.blockID)
				{
					i1++;
				}
			}
			if (i1 == 1)
			{
				par1World.setBlock(j, k, l, MainRegistry.arcaneStone.blockID);
			}
		}
		return;
	}
}