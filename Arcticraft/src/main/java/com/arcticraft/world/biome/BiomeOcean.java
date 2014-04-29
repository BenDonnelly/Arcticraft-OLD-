package com.arcticraft.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

import com.arcticraft.Block.AC_Block;


public class BiomeOcean extends AC_BiomeGenBase
{

	protected BiomeOcean(int par1)
	{
		super(par1);

		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		topBlock =  AC_Block.frostDirt;
		fillerBlock = AC_Block.frostDirt;
		this.setHeight(new BiomeGenBase.Height(-1.0F, 0.4F));
	}

}
