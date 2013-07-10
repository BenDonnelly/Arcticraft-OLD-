package arcticraft.biomes;

import arcticraft.main.MainRegistry;
import net.minecraft.block.Block;

public class AC_BiomeOcean extends AC_BiomeGenBaseArcticraft
{

	protected AC_BiomeOcean(int par1)
	{
		super(par1);

		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		topBlock = (byte) MainRegistry.frostDirt.blockID;
		fillerBlock = (byte) MainRegistry.frostDirt.blockID;
		this.setMinMaxHeight(-1.0F, 0.4F);
	}

}
