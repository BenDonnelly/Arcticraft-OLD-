package arcticraft.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.SpawnListEntry;
import arcticraft.blocks.AC_Block;
import arcticraft.entities.AC_EntityFrostGhost;
import arcticraft.entities.AC_EntityPolarBear;

public class AC_BiomeGlacier extends AC_BiomeGenBase
{

	public AC_BiomeGlacier(int par1)
	{
		super(par1);
		this.theBiomeDecorator = new AC_BiomeDecorator(this);
		this.minHeight = 0.1F;
		this.maxHeight = 0.3F;
		topBlock = (byte) Block.blockSnow.blockID;
		fillerBlock = (byte) AC_Block.acWaterIce.blockID;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityPolarBear.class, 5, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityFrostGhost.class, 1, 1, 1));
		setMinMaxHeight(0.2F, 2.1F);
		setTemperatureRainfall(0.0F, 0.5F);
	}

}
