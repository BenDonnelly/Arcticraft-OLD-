package arcticraft.biomes;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;
import arcticraft.blocks.AC_Block;
import arcticraft.entities.AC_EntityBoar;
import arcticraft.entities.AC_EntityFrostZombie;
import arcticraft.entities.AC_EntityHusky;
import arcticraft.gen.AC_GenCaveman;

public class AC_BiomeFrostForest extends AC_BiomeGenBase
{

	public AC_BiomeFrostForest(int par1)
	{
		super(par1);
		this.theBiomeDecorator = new AC_BiomeDecorator(this);
		topBlock = (byte) AC_Block.frostGrass.blockID;
		fillerBlock = (byte) AC_Block.frostDirt.blockID;
		this.theBiomeDecorator.treesPerChunk = 10;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityHusky.class, 5, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityBoar.class, 5, 4, 4));
	//	this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityFrostZombie.class, 10, 4, 4));
		setTemperatureRainfall(0.0F, 0.5F);
		setColor(16777215);
	}

	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);

		if(par2Random.nextInt(750) < 10)
		{
			int k = par3 + par2Random.nextInt(16) + 8;
			int l = par4 + par2Random.nextInt(16) + 8;
			AC_GenCaveman caveman = new AC_GenCaveman();
			caveman.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1, l);
		}
	}

	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return (WorldGenerator) (par1Random.nextInt(5) == 0 ? this.genGlacierTrees : this.genFrostTrees);
	}
}
