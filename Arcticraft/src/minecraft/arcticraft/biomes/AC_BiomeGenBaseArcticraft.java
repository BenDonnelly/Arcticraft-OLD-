package arcticraft.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import arcticraft.entities.AC_EntityBoar;
import arcticraft.entities.AC_EntityFrostZombie;
import arcticraft.entities.AC_EntityHusky;
import arcticraft.entities.AC_EntityIceCreeper;
import arcticraft.entities.AC_EntityPenguin;
import arcticraft.entities.AC_EntityPolarBear;
import arcticraft.gen.AC_GenFrostTrees;
import arcticraft.gen.AC_GenGlacierTrees;
import arcticraft.main.MainRegistry;

public class AC_BiomeGenBaseArcticraft extends BiomeGenBase
{  
	
    protected boolean enableSnow;
    public static final AC_BiomeGenBaseArcticraft FrostMountains;
    public static final AC_BiomeGenBaseArcticraft frostForest;
    public static final AC_BiomeGenBaseArcticraft glacier;
    protected AC_GenFrostTrees genFrostTrees;
	protected AC_GenGlacierTrees genGlacierTrees;
    public AC_BiomeGenBaseArcticraft(int i)
    {
        super(i);
        this.topBlock = (byte)MainRegistry.frostGrass.blockID;
        this.topBlock = (byte)MainRegistry.frostDirt.blockID;
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityIceCreeper.class, 5, 2, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityFrostZombie.class, 5, 2, 2));
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
    	
    	FrostMountains = (AC_BiomeGenBaseArcticraft) (new AC_BiomeFrostMountains(23)).setBiomeName("Arctic Mountains");
    	frostForest = (AC_BiomeGenBaseArcticraft) (new AC_BiomeFrostForest(24)).setBiomeName("Frost Forest");
    	glacier = (AC_BiomeGenBaseArcticraft) (new AC_BiomeGlacier(25)).setBiomeName("Glacier");
    }
    
  
    
}