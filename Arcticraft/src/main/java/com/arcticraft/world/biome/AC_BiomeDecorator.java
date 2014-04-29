package com.arcticraft.world.biome;

import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class AC_BiomeDecorator extends BiomeDecorator {

	public AC_BiomeDecorator(BiomeGenBase par1BiomeGenBase) {
		super();
	}

	protected void genDecorations(BiomeGenBase biome) {
		super.genDecorations(biome);

		if (biome == AC_BiomeGenBase.FrostMountains) {
			this.treesPerChunk = 3;
			this.deadBushPerChunk = -999;
			this.reedsPerChunk = -999;
			this.flowersPerChunk = -999;

		}
	}

}
