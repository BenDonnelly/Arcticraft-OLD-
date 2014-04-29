package com.arcticraft.world.biome;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.arcticraft.Block.AC_Block;

public class BiomeFrostMountains extends AC_BiomeGenBase
{

	public BiomeFrostMountains(int par1)
	{
		super(par1);
		this.theBiomeDecorator = new AC_BiomeDecorator(this);
		topBlock =  AC_Block.frostGrass;
		fillerBlock = AC_Block.frostDirt;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		//this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityPolarBear.class, 5, 4, 4));
		//this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityFrostGhost.class, 1, 1, 1));
		//this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityDragon.class, 1, 1, 1));
		this.setHeight(new BiomeGenBase.Height(0.2F, 2.3F));
		setTemperatureRainfall(0.0F, 1.0F);
	}

	
	
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return (WorldGenerator) (par1Random.nextInt(5) == 0 ? this.genGlacierTrees : genFrostTrees);
	}
}
