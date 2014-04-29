package com.arcticraft.world;

import com.arcticraft.world.biome.AC_GenLayerBiomes;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class AC_GenLayer extends GenLayer
{

	public AC_GenLayer(long seed)
	{
		super(seed);
	}

	public static GenLayer[] makeTheWorld(long seed)
	{

		GenLayer biomes = new AC_GenLayerBiomes(1L);

		// more GenLayerZoom = bigger biomes
		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001L, biomes);
		biomes = new GenLayerZoom(1002L, biomes);
		biomes = new GenLayerZoom(700L, biomes);
		biomes = new GenLayerZoom(1250L, biomes);
		biomes = new GenLayerZoom(1005L, biomes);

		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);

		return new GenLayer[] {biomes , genlayervoronoizoom};
	}
}
