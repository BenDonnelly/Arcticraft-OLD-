package com.arcticraft.world.biome;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

import com.arcticraft.Block.AC_Block;

public class BiomeGlacier extends AC_BiomeGenBase
{

	public BiomeGlacier(int par1)
	{
		super(par1);
		this.theBiomeDecorator = new AC_BiomeDecorator(this);
		topBlock =  Blocks.snow;
		fillerBlock = AC_Block.acWaterIce;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		//this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityPolarBear.class, 5, 4, 4));
		//this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityFrostGhost.class, 1, 1, 1));
		this.setHeight(new BiomeGenBase.Height(0.2F, 2.1F));
		setTemperatureRainfall(0.0F, 0.5F);
	}

}
