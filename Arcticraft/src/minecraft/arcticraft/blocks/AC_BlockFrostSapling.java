package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import arcticraft.gen.AC_GenFrostTrees;
import arcticraft.main.MainRegistry;

public class AC_BlockFrostSapling extends BlockFlower
{

	public AC_BlockFrostSapling(int i)
	{
		super(i);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}

	protected boolean canThisPlantGrowOnThisBlockID(int i, int j)
	{
		return i == MainRegistry.frostGrass.blockID;
	}

	public void updateTick(World world, int i, int j, int k, Random random)
	{
		if (world.isRemote)
		{
			return;
		}
		super.updateTick(world, i, j, k, random);

		if (world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
		{
			int l = world.getBlockMetadata(i, j, k);
			if ((l & 8) == 0)
			{
				world.setBlockMetadataWithNotify(i, j, k, l | 8, l);
			}
			else
			{
				growTree(world, i, j, k, random);
			}
		}
	}
	public void growTree(World world, int i, int j, int k, Random random)
	{
		int l = world.getBlockMetadata(i, j, k) & 3;
		world.setBlock(i, j, k, 0);
		Object obj = null;
		obj = new AC_GenFrostTrees(blockConstructorCalled);
		if (!((WorldGenerator) (obj)).generate(world, random, i, j, k))
		{
			world.setBlock(i, j, k, blockID, l, blockID);
		}
	}
	public int damageDropped(int i)
	{
		return i & 3;
	}
}
