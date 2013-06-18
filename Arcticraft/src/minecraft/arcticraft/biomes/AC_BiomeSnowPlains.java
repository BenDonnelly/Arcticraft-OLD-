package arcticraft.biomes;

import arcticraft.entities.AC_EntityPolarBear;
import arcticraft.main.MainRegistry;
import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class AC_BiomeSnowPlains extends AC_BiomeGenBaseArcticraft
{

	protected AC_BiomeSnowPlains(int par1)
	{
		super(par1);

		this.theBiomeDecorator = new AC_BiomeDecoratorArcticraft(this);
		topBlock = (byte) Block.blockSnow.blockID;
		fillerBlock = (byte)Block.blockSnow.blockID;
		this.theBiomeDecorator.treesPerChunk = -999;
		setMinMaxHeight(0.1F, 0.1F);
		setEnableSnow();
		setTemperatureRainfall(0.0F, 0.5F);
	}
	public boolean getEnableSnow()
	{
		return true;
	}
}
