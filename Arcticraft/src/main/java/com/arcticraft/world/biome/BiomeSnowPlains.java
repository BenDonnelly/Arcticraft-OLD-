package com.arcticraft.world.biome;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSnowPlains extends AC_BiomeGenBase {

	Minecraft mc;

	protected BiomeSnowPlains(int par1) {
		super(par1);
		this.theBiomeDecorator = new AC_BiomeDecorator(this);
		this.theBiomeDecorator.treesPerChunk = -999;
		//this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityBoar.class, 5, 4, 4));
		this.setHeight(new BiomeGenBase.Height(0.1F, 0.1F));
		setTemperatureRainfall(0.0F, 0.5F);
	}

}
