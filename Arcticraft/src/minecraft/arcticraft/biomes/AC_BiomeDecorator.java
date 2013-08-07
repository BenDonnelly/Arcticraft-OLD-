package arcticraft.biomes;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class AC_BiomeDecorator extends BiomeDecorator
{

	public AC_BiomeDecorator(BiomeGenBase par1BiomeGenBase)
	{
		super(par1BiomeGenBase);
	}

	public void decorate()
	{
		super.decorate();

		if(this.biome == AC_BiomeGenBase.FrostMountains)
		{
			this.treesPerChunk = 3;
			this.deadBushPerChunk = - 999;
			this.reedsPerChunk = - 999;
			this.flowersPerChunk = - 999;

		}
	}
}
