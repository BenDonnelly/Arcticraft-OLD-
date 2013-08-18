package arcticraft.biomes;

import java.util.Random;

import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;
import arcticraft.blocks.AC_Block;
import arcticraft.entities.AC_EntityDragon;
import arcticraft.entities.AC_EntityFrostGhost;
import arcticraft.entities.AC_EntityPolarBear;

public class AC_BiomeFrostMountains extends AC_BiomeGenBase
{

	public AC_BiomeFrostMountains(int par1)
	{
		super(par1);
		this.theBiomeDecorator = new AC_BiomeDecorator(this);
		topBlock = (byte) AC_Block.frostGrass.blockID;
		fillerBlock = (byte) AC_Block.frostDirt.blockID;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityPolarBear.class, 5, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityFrostGhost.class, 1, 1, 1));
		//	this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityDragon.class, 1, 1, 1));
		setMinMaxHeight(0.2F, 2.3F);
		setTemperatureRainfall(0.0F, 1.0F);

	}

	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return (WorldGenerator) (par1Random.nextInt(5) == 0 ? this.genGlacierTrees : genFrostTrees);
	}
}
