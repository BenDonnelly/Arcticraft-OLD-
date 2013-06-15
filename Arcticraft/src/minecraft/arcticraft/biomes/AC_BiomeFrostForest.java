package arcticraft.biomes;

import java.util.Random;

import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;
import arcticraft.entities.AC_EntityBoar;
import arcticraft.entities.AC_EntityHusky;
import arcticraft.main.MainRegistry;

public class AC_BiomeFrostForest extends AC_BiomeGenBaseArcticraft
{	

	public AC_BiomeFrostForest(int par1)
	{
		super(par1);		
		this.theBiomeDecorator = new AC_BiomeDecoratorArcticraft(this);
		topBlock = (byte)MainRegistry.frostGrass.blockID;
		fillerBlock = (byte)MainRegistry.frostDirt.blockID;
		this.theBiomeDecorator.treesPerChunk = 10;
		this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityHusky.class, 5,4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityBoar.class, 5, 4, 4));
		setEnableSnow();
		setTemperatureRainfall(0.0F, 0.5F);
		setColor(16777215);
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return (WorldGenerator)(par1Random.nextInt(5) == 0 ? this.genGlacierTrees : this.genFrostTrees);
	}
	
	public boolean getEnableSnow()
    {
        return true;
    }

}
