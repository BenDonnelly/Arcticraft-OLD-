package arcticraft.biomes;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class AC_BiomeDecoratorArcticraft extends BiomeDecorator
{

	public AC_BiomeDecoratorArcticraft(BiomeGenBase par1BiomeGenBase)
	{
		super(par1BiomeGenBase);
	}

	public void decorate()
	{
		super.decorate();

		if(this.biome == AC_BiomeGenBaseArcticraft.FrostMountains)
		{
			this.treesPerChunk = 3;
			this.deadBushPerChunk = - 999;
			this.reedsPerChunk = - 999;
			this.flowersPerChunk = - 999;

		}
	}
}
