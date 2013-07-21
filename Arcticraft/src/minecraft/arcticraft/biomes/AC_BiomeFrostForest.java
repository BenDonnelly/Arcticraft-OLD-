package arcticraft.biomes;

import java.util.Random;

import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;
import arcticraft.blocks.AC_Block;
import arcticraft.entities.AC_EntityBoar;
import arcticraft.entities.AC_EntityFrostZombie;
import arcticraft.entities.AC_EntityHusky;

public class AC_BiomeFrostForest extends AC_BiomeGenBaseArcticraft
{

	public AC_BiomeFrostForest(int par1)
	{
		super(par1);
		this.theBiomeDecorator = new AC_BiomeDecoratorArcticraft(this);
		topBlock = (byte) AC_Block.frostGrass.blockID;
		fillerBlock = (byte) AC_Block.frostDirt.blockID;
		this.theBiomeDecorator.treesPerChunk = 10;
		this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityHusky.class, 5, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityBoar.class, 5, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityFrostZombie.class, 10, 4, 4));
		setTemperatureRainfall(0.0F, 0.5F);
		setColor(16777215);
	}

	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return (WorldGenerator) (par1Random.nextInt(5) == 0 ? this.genGlacierTrees : this.genFrostTrees);
	}
}
