package arcticraft.world;

import java.util.Random;

import arcticraft.gen.AC_GenPortalHouse;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class AC_WorldGenerator implements IWorldGenerator
{

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		//The different methods here are for genning in other dimensions
		switch (world.provider.dimensionId)
		{
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	public void generateSurface(World world, Random rand, int x, int z)
    {
       BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);

       if ((biome instanceof BiomeGenTaiga))
       {
    	   {
    		   for(int k = 0; k < 13; k++)
    		   {
    			   int RandPosX = x + rand.nextInt(16);
    			   int RandPosY = rand.nextInt(128);
    			   int RandPosZ = z + rand.nextInt(16);
    			   (new AC_GenPortalHouse()).generate(world, rand, RandPosX, RandPosY, RandPosZ);
    		   }
    	   }
       }
    }       
	public void generateNether(World world, Random ran, int baseX, int baseZ)
	{

	}

	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{

	}

}
