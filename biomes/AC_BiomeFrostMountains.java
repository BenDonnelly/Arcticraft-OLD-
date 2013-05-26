package arcticraft.biomes;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import arcticraft.main.MainRegistry;

public class AC_BiomeFrostMountains extends AC_BiomeGenBaseArcticraft
{

	public AC_BiomeFrostMountains(int par1)
	{
		super(par1);
		this.theBiomeDecorator = new AC_BiomeDecoratorArcticraft(this);
		topBlock = (byte) MainRegistry.frostGrass.blockID;
		fillerBlock = (byte) MainRegistry.frostDirt.blockID;
		setMinMaxHeight(0.2F, 2.3F);
		setEnableSnow();
		setTemperatureRainfall(0.0F, 1.0F);

	}

	public boolean getEnableSnow()
	{
		return true;
	}

	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return (WorldGenerator) (par1Random.nextInt(5) == 0 ? this.genGlacierTrees : genFrostTrees);
	}
}
