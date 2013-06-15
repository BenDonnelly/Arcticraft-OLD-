package arcticraft.biomes;

import arcticraft.entities.AC_EntityPolarBear;
import net.minecraft.block.Block;
import net.minecraft.world.biome.SpawnListEntry;

public class AC_BiomeGlacier extends AC_BiomeGenBaseArcticraft
{

	public AC_BiomeGlacier(int par1)
	{
		super(par1);
		this.theBiomeDecorator = new AC_BiomeDecoratorArcticraft(this);
		this.minHeight = 0.1F;
		this.maxHeight = 0.3F;
		topBlock = (byte) Block.blockSnow.blockID;
		fillerBlock = (byte) Block.ice.blockID;
		this.spawnableMonsterList.add(new SpawnListEntry(AC_EntityPolarBear.class, 5, 4, 4));
		setMinMaxHeight(0.2F, 2.1F);
		setEnableSnow();
		setTemperatureRainfall(0.0F, 0.5F);
	}

	public boolean getEnableSnow()
	{
		return true;
	}

}
