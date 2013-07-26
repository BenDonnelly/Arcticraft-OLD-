package arcticraft.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.SpawnListEntry;
import arcticraft.blocks.AC_Block;
import arcticraft.entities.AC_EntityBoar;

public class AC_BiomeSnowPlains extends AC_BiomeGenBaseArcticraft
{

	protected AC_BiomeSnowPlains(int par1)
	{
		super(par1);

		this.theBiomeDecorator = new AC_BiomeDecoratorArcticraft(this);
		topBlock = (byte) Block.snow.blockID;
		fillerBlock = (byte) AC_Block.frostGrass.blockID;
		this.theBiomeDecorator.treesPerChunk = - 999;
		this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityBoar.class, 5, 4, 4));
		setMinMaxHeight(0.1F, 0.1F);
		setTemperatureRainfall(0.0F, 0.5F);
	}
}
