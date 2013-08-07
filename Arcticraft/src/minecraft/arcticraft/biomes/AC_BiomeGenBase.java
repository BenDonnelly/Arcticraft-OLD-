package arcticraft.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import arcticraft.blocks.AC_Block;
import arcticraft.entities.AC_EntityFrostGhost;
import arcticraft.entities.AC_EntityIceCreeper;
import arcticraft.entities.AC_EntityPenguin;
import arcticraft.gen.AC_GenFrostTrees;
import arcticraft.gen.AC_GenGlacierTrees;

public class AC_BiomeGenBase extends BiomeGenBase
{

	protected boolean enableSnow;
	public static final AC_BiomeGenBase FrostMountains;
	public static final AC_BiomeGenBase frostForest;
	public static final AC_BiomeGenBase glacier;
	public static final AC_BiomeGenBase snowPlains;
	public static final AC_BiomeGenBase ocean;
	protected AC_GenFrostTrees genFrostTrees;
	protected AC_GenGlacierTrees genGlacierTrees;

	public AC_BiomeGenBase(int i)
	{
		super(i);
		this.topBlock = (byte) AC_Block.frostGrass.blockID;
		this.topBlock = (byte) AC_Block.frostDirt.blockID;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityIceCreeper.class, 10, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(AC_EntityPenguin.class, 12, 4, 4));
		this.genFrostTrees = new AC_GenFrostTrees(false);
		this.genGlacierTrees = new AC_GenGlacierTrees(false);
	}

	public boolean getEnableSnow()
	{
		return true;
	}

	static
	{

		FrostMountains = (AC_BiomeGenBase) (new AC_BiomeFrostMountains(23)).setBiomeName("Arctic Mountains");
		frostForest = (AC_BiomeGenBase) (new AC_BiomeFrostForest(24)).setBiomeName("Frost Forest");
		glacier = (AC_BiomeGenBase) (new AC_BiomeGlacier(25)).setBiomeName("Glacier");
		snowPlains = (AC_BiomeGenBase) (new AC_BiomeSnowPlains(26)).setBiomeName("Snow Plains");
		ocean = (AC_BiomeGenBase) (new AC_BiomeOcean(27)).setBiomeName("Arctic Ocean");
	}

}
