package com.arcticraft.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

import com.arcticraft.Block.AC_Block;
import com.arcticraft.world.gen.WorldGenFrostTrees;
import com.arcticraft.world.gen.WorldGenGlacierTrees;

public class AC_BiomeGenBase extends BiomeGenBase
{

	protected boolean enableSnow;
	public static final AC_BiomeGenBase FrostMountains;
	public static final AC_BiomeGenBase frostForest;
	public static final AC_BiomeGenBase glacier;
	public static final AC_BiomeGenBase snowPlains;
	public static final AC_BiomeGenBase ocean;
	protected WorldGenFrostTrees genFrostTrees;
	protected WorldGenGlacierTrees genGlacierTrees;

	public AC_BiomeGenBase(int i)
	{
		super(i);
		this.topBlock = AC_Block.frostGrass;
		this.fillerBlock =  AC_Block.frostDirt;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		//this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityIceCreeper.class, 10, 4, 4));
		//this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityPenguin.class, 12, 4, 4));
		this.genFrostTrees = new WorldGenFrostTrees(false);
		this.genGlacierTrees = new WorldGenGlacierTrees(false);
	}

	public boolean getEnableSnow()
	{
		return true;
	}

	static
	{
		FrostMountains = (AC_BiomeGenBase) (new BiomeFrostMountains(70)).setBiomeName("Arctic Mountains");
		frostForest = (AC_BiomeGenBase) (new BiomeFrostForest(71)).setBiomeName("Frost Forest");
		glacier = (AC_BiomeGenBase) (new BiomeGlacier(72)).setBiomeName("Glacier");
		snowPlains = (AC_BiomeGenBase) (new BiomeSnowPlains(73)).setBiomeName("Snow Plains");
		ocean = (AC_BiomeGenBase) (new BiomeOcean(74)).setBiomeName("Arctic Ocean");
	}

}
