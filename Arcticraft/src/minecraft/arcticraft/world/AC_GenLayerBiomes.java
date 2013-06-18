package arcticraft.world;

import arcticraft.biomes.AC_BiomeGenBaseArcticraft;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class AC_GenLayerBiomes extends GenLayer
{

	protected BiomeGenBase [] allowedBiomes =
		{AC_BiomeGenBaseArcticraft.FrostMountains, AC_BiomeGenBaseArcticraft.frostForest, AC_BiomeGenBaseArcticraft.glacier, AC_BiomeGenBaseArcticraft.snowPlains};

	public AC_GenLayerBiomes(long seed, GenLayer genlayer)
	{
		super(seed);
		this.parent = genlayer;
	}

	public AC_GenLayerBiomes(long seed)
	{
		super(seed);
	}

	@Override
	public int [] getInts(int x, int z, int width, int depth)
	{
		int [] dest = IntCache.getIntCache(width * depth);

		for (int dz = 0; dz < depth; dz++)
		{
			for (int dx = 0; dx < width; dx++)
			{
				this.initChunkSeed(dx + x, dz + z);
				dest [(dx + dz * width)] = this.allowedBiomes [nextInt(this.allowedBiomes.length)].biomeID;
			}
		}
		return dest;
	}
}
