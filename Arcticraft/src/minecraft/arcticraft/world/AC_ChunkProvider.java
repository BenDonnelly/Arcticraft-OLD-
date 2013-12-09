package arcticraft.world;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.MINESHAFT;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.SCATTERED_FEATURE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.STRONGHOLD;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.VILLAGE;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import arcticraft.biomes.AC_BiomeOcean;
import arcticraft.blocks.AC_Block;
import arcticraft.gen.AC_GenArcaneStone1;
import arcticraft.gen.AC_GenArcaneStone2;
import arcticraft.gen.AC_GenCaveman;
import arcticraft.gen.AC_GenIceberg;
import arcticraft.gen.AC_GenShip;
import arcticraft.helpers.AC_TickHandler;

public class AC_ChunkProvider implements IChunkProvider
{

	/** RNG. */
	private Random rand;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen1;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen2;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen3;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen4;

	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen5;

	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;

	/** Reference to the World object. */
	private World worldObj;

	/** are map structures going to be generated (e.g. strongholds) */
	private final boolean mapFeaturesEnabled = false;

	/** Holds the overall noise array used in chunk generation */
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenCaves();

	/** Holds Stronghold Generator */
	private MapGenStronghold strongholdGenerator = new MapGenStronghold();

	/** Holds Village Generator */
	private MapGenVillage villageGenerator = new MapGenVillage();

	/** Holds Mineshaft Generator */
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();

	/** Holds ravine generator */
	private MapGenBase ravineGenerator = new MapGenRavine();

	/** The biomes that are used to generate the chunk */
	private BiomeGenBase[] biomesForGeneration;

	/** A double array that hold terrain noise from noiseGen3 */
	double[] noise3;

	/** A double array that hold terrain noise */
	double[] noise1;

	/** A double array that hold terrain noise from noiseGen2 */
	double[] noise2;

	/** A double array that hold terrain noise from noiseGen5 */
	double[] noise5;

	/** A double array that holds terrain noise from noiseGen6 */
	double[] noise6;

	/**
	 * Used to store the 5x5 parabolic field that is used during terrain
	 * generation.
	 */
	float[] parabolicField;
	int[][] field_73219_j = new int[32][32];

	{
		caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
		strongholdGenerator = (MapGenStronghold) TerrainGen.getModdedMapGen(strongholdGenerator, STRONGHOLD);
		villageGenerator = (MapGenVillage) TerrainGen.getModdedMapGen(villageGenerator, VILLAGE);
		mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(mineshaftGenerator, MINESHAFT);
		scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
		ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
	}

	public AC_ChunkProvider(World par1World, long par2, boolean par4)
	{
		this.worldObj = par1World;

		this.rand = new Random(par2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);

		NoiseGeneratorOctaves[] noiseGens = {noiseGen1 , noiseGen2 , noiseGen3 , noiseGen4 , noiseGen5 , noiseGen6 , mobSpawnerNoise};
		noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
		this.noiseGen1 = noiseGens[0];
		this.noiseGen2 = noiseGens[1];
		this.noiseGen3 = noiseGens[2];
		this.noiseGen4 = noiseGens[3];
		this.noiseGen5 = noiseGens[4];
		this.noiseGen6 = noiseGens[5];
		this.mobSpawnerNoise = noiseGens[6];
	}

	/**
	 * Generates the shape of the terrain for the chunk though its all stone
	 * though the water is frozen if the temperature is low enough
	 */
	public void generateTerrain(int par1, int par2, byte[] par3ArrayOfByte)
	{
		byte var4 = 4;
		byte var5 = 16;
		byte var6 = 63;
		int var7 = var4 + 1;
		byte var8 = 17;
		int var9 = var4 + 1;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, var7 + 5, var9 + 5);
		this.noiseArray = this.initializeNoiseField(this.noiseArray, par1 * var4, 0, par2 * var4, var7, var8, var9);

		for(int var10 = 0; var10 < var4; ++var10)
		{
			for(int var11 = 0; var11 < var4; ++var11)
			{
				for(int var12 = 0; var12 < var5; ++var12)
				{
					double var13 = 0.125D;
					double var15 = this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
					double var17 = this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
					double var19 = this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
					double var21 = this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
					double var23 = (this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
					double var25 = (this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
					double var27 = (this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
					double var29 = (this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

					for(int var31 = 0; var31 < 8; ++var31)
					{
						double var32 = 0.25D;
						double var34 = var15;
						double var36 = var17;
						double var38 = (var19 - var15) * var32;
						double var40 = (var21 - var17) * var32;

						for(int var42 = 0; var42 < 4; ++var42)
						{
							int var43 = var42 + var10 * 4 << 11 | 0 + var11 * 4 << 7 | var12 * 8 + var31;
							short var44 = 128;
							var43 -= var44;
							double var45 = 0.25D;
							double var49 = (var36 - var34) * var45;
							double var47 = var34 - var49;

							for(int var51 = 0; var51 < 4; ++var51)
							{
								if((var47 += var49) > 0.0D)
								{
									par3ArrayOfByte[var43 += var44] = (byte) AC_Block.frostStone.blockID;
								}
								else if(var12 * 8 + var31 < var6)
								{
									par3ArrayOfByte[var43 += var44] = (byte) AC_Block.acWaterStill.blockID;
								}
								else
								{
									par3ArrayOfByte[var43 += var44] = 0;
								}
							}

							var34 += var38;
							var36 += var40;
						}

						var15 += var23;
						var17 += var25;
						var19 += var27;
						var21 += var29;
					}
				}
			}
		}
	}

	/**
	 * Replaces the stone that was placed in with blocks that match the biome
	 */
	public void replaceBlocksForBiome(int par1, int par2, byte par3ArrayOfByte[], BiomeGenBase par4ArrayOfBiomeGenBase[])
	{
		byte byte0 = 63;
		double d = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);

		for(int i = 0; i < 16; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				BiomeGenBase biomegenbase = par4ArrayOfBiomeGenBase[j + i * 16];
				float f = biomegenbase.getFloatTemperature();
				int k = (int) (this.stoneNoise[i + j * 16] / 3D + 3D + this.rand.nextDouble() * 0.25D);
				int l = - 1;
				byte byte1 = biomegenbase.topBlock;
				byte byte2 = biomegenbase.fillerBlock;

				for(int i1 = 127; i1 >= 0; i1--)
				{
					int j1 = (j * 16 + i) * 128 + i1;

					if(i1 <= 0 + this.rand.nextInt(5))
					{
						par3ArrayOfByte[j1] = (byte) Block.bedrock.blockID;
						continue;
					}

					byte byte3 = par3ArrayOfByte[j1];

					if(byte3 == 0)
					{
						l = - 1;
						continue;
					}

					if(byte3 != (byte) AC_Block.frostStone.blockID)
					{
						continue;
					}

					if(l == - 1)
					{
						if(k <= 0)
						{
							byte1 = 0;
							byte2 = (byte) AC_Block.frostStone.blockID;
						}
						else if(i1 >= byte0 - 4 && i1 <= byte0 + 1)
						{
							byte1 = biomegenbase.topBlock;
							byte2 = biomegenbase.fillerBlock;
						}

						if(i1 < byte0 && byte1 == 0)
						{
							if(f < 0.15F)
							{
								byte1 = (byte) AC_Block.acWaterIce.blockID;
							}
							else
							{
								byte1 = (byte) AC_Block.acWaterStill.blockID;
							}
						}

						l = k;

						if(i1 >= byte0 - 1)
						{
							par3ArrayOfByte[j1] = byte1;
						}
						else
						{
							par3ArrayOfByte[j1] = byte2;
						}

						continue;
					}

					if(l <= 0)
					{
						continue;
					}

					l--;
					par3ArrayOfByte[j1] = byte2;

				}
			}
		}
	}

	/**
	 * loads or generates the chunk at the chunk location specified
	 */
	public Chunk loadChunk(int par1, int par2)
	{
		return this.provideChunk(par1, par2);
	}

	/**
	 * Will return back a chunk, if it doesn't exist and its not a MP client it
	 * will generates all the blocks for the specified chunk from the map seed
	 * and chunk seed
	 */
	public Chunk provideChunk(int par1, int par2)
	{
		this.rand.setSeed((long) par1 * 341873128712L + (long) par2 * 132897987541L);
		byte[] var3 = new byte[32768];
		this.generateTerrain(par1, par2, var3);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		this.replaceBlocksForBiome(par1, par2, var3, this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, par1, par2, var3);
		this.ravineGenerator.generate(this, this.worldObj, par1, par2, var3);

		if(this.mapFeaturesEnabled)
		{
			this.mineshaftGenerator.generate(this, this.worldObj, par1, par2, var3);
			this.villageGenerator.generate(this, this.worldObj, par1, par2, var3);
			this.strongholdGenerator.generate(this, this.worldObj, par1, par2, var3);
			this.scatteredFeatureGenerator.generate(this, this.worldObj, par1, par2, var3);
		}

		Chunk var4 = new Chunk(this.worldObj, var3, par1, par2);
		byte[] var5 = var4.getBiomeArray();

		for(int var6 = 0; var6 < var5.length; ++var6)
		{
			var5[var6] = (byte) this.biomesForGeneration[var6].biomeID;
		}

		var4.generateSkylightMap();
		return var4;
	}

	/**
	 * generates a subset of the level's terrain data. Takes 7 arguments: the
	 * [empty] noise array, the position, and the size.
	 */
	private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7)
	{
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.getResult() == Result.DENY)
			return event.noisefield;

		if(par1ArrayOfDouble == null)
		{
			par1ArrayOfDouble = new double[par5 * par6 * par7];
		}

		if(this.parabolicField == null)
		{
			this.parabolicField = new float[25];

			for(int var8 = - 2; var8 <= 2; ++var8)
			{
				for(int var9 = - 2; var9 <= 2; ++var9)
				{
					float var10 = 10.0F / MathHelper.sqrt_float((float) (var8 * var8 + var9 * var9) + 0.2F);
					this.parabolicField[var8 + 2 + (var9 + 2) * 5] = var10;
				}
			}
		}

		double var44 = 684.412D;
		double var45 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, par2, par4, par5, par7, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par4, par5, par7, 200.0D, 200.0D, 0.5D);
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, var44 / 80.0D, var45 / 160.0D, var44 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		boolean var43 = false;
		boolean var42 = false;
		int var12 = 0;
		int var13 = 0;

		for(int var14 = 0; var14 < par5; ++var14)
		{
			for(int var15 = 0; var15 < par7; ++var15)
			{
				float var16 = 0.0F;
				float var17 = 0.0F;
				float var18 = 0.0F;
				byte var19 = 2;
				BiomeGenBase var20 = this.biomesForGeneration[var14 + 2 + (var15 + 2) * (par5 + 5)];

				for(int var21 = - var19; var21 <= var19; ++var21)
				{
					for(int var22 = - var19; var22 <= var19; ++var22)
					{
						BiomeGenBase var23 = this.biomesForGeneration[var14 + var21 + 2 + (var15 + var22 + 2) * (par5 + 5)];
						float var24 = this.parabolicField[var21 + 2 + (var22 + 2) * 5] / (var23.minHeight + 2.0F);

						if(var23.minHeight > var20.minHeight)
						{
							var24 /= 2.0F;
						}

						var16 += var23.maxHeight * var24;
						var17 += var23.minHeight * var24;
						var18 += var24;
					}
				}

				var16 /= var18;
				var17 /= var18;
				var16 = var16 * 0.9F + 0.1F;
				var17 = (var17 * 4.0F - 1.0F) / 8.0F;
				double var47 = this.noise6[var13] / 8000.0D;

				if(var47 < 0.0D)
				{
					var47 = - var47 * 0.3D;
				}

				var47 = var47 * 3.0D - 2.0D;

				if(var47 < 0.0D)
				{
					var47 /= 2.0D;

					if(var47 < - 1.0D)
					{
						var47 = - 1.0D;
					}

					var47 /= 1.4D;
					var47 /= 2.0D;
				}
				else
				{
					if(var47 > 1.0D)
					{
						var47 = 1.0D;
					}

					var47 /= 8.0D;
				}

				++var13;

				for(int var46 = 0; var46 < par6; ++var46)
				{
					double var48 = (double) var17;
					double var26 = (double) var16;
					var48 += var47 * 0.2D;
					var48 = var48 * (double) par6 / 16.0D;
					double var28 = (double) par6 / 2.0D + var48 * 4.0D;
					double var30 = 0.0D;
					double var32 = ((double) var46 - var28) * 12.0D * 128.0D / 128.0D / var26;

					if(var32 < 0.0D)
					{
						var32 *= 4.0D;
					}

					double var34 = this.noise1[var12] / 512.0D;
					double var36 = this.noise2[var12] / 512.0D;
					double var38 = (this.noise3[var12] / 10.0D + 1.0D) / 2.0D;

					if(var38 < 0.0D)
					{
						var30 = var34;
					}
					else if(var38 > 1.0D)
					{
						var30 = var36;
					}
					else
					{
						var30 = var34 + (var36 - var34) * var38;
					}

					var30 -= var32;

					if(var46 > par6 - 4)
					{
						double var40 = (double) ((float) (var46 - (par6 - 4)) / 3.0F);
						var30 = var30 * (1.0D - var40) + - 10.0D * var40;
					}

					par1ArrayOfDouble[var12] = var30;
					++var12;
				}
			}
		}

		return par1ArrayOfDouble;
	}

	/**
	 * Checks to see if a chunk exists at x, y
	 */
	public boolean chunkExists(int par1, int par2)
	{
		return true;
	}

	/**
	 * Populates chunk with ores etc etc
	 */
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
	{
		BiomeGenBase biome = worldObj.getWorldChunkManager().getBiomeGenAt(par2, par3);
		int i = par2 * 16;
		int j = par3 * 16;
		BlockSand.fallInstantly = true;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(i + 16, j + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long l = (this.rand.nextLong() / 2L) * 2L + 1L;
		long l1 = (this.rand.nextLong() / 2L) * 2L + 1L;
		this.rand.setSeed((long) par2 * l + (long) par3 * l1 ^ this.worldObj.getSeed());
		boolean flag = false;
		int var6;
		int var7;
		int var8;
		int var9;
		int var10;
		if(biomegenbase instanceof AC_BiomeOcean)
		{
			for(int x = 0; x < 2; x++)
			{
				int e = i + rand.nextInt(16);
				int r = 62;
				int b = j + rand.nextInt(16);
				(new AC_GenShip()).generate(worldObj, rand, e, r, b);
			}

		}

		for(int x = 0; x < 2; x++)
		{

			int e = i + rand.nextInt(16);
			int b = j + rand.nextInt(16);

			int r = worldObj.getHeightValue(e, b) - 2;
			(new AC_GenIceberg()).generate(worldObj, rand, e, r, b);
		}

		var6 = this.rand.nextInt(this.rand.nextInt(14) + 1) + 1;

		for(var7 = 0; var7 < var6; var7++)
		{
			var8 = i + this.rand.nextInt(16) + 8;
			var9 = this.rand.nextInt(128);
			var10 = j + this.rand.nextInt(16) + 8;

			(new AC_GenArcaneStone1(AC_Block.arcaneStone.blockID, 16)).generate(this.worldObj, this.rand, var8, var9, var10);
		}

		for(var7 = 0; var7 < var6; var7++)
		{
			var8 = i + this.rand.nextInt(16) + 8;
			var9 = this.rand.nextInt(128);
			var10 = j + this.rand.nextInt(16) + 8;

			(new AC_GenArcaneStone2(AC_Block.arcaneStone.blockID, 16)).generate(this.worldObj, this.rand, var8, var9, var10);
		}
		/*
		 * for(int g = 0;g<1;++g){
		 * int y = worldObj.getHeightValue(i, j);
		 * (new AC_GenArcaneStone2(AC_Block.arcaneStone.blockID, 9)).generate(this.worldObj, this.rand, i, y, j);
		 * }
		 */
		for(int x = 0; x < 1; x++)
		{
			int e = i + rand.nextInt(16);
			int r = rand.nextInt(128);
			int b = j + rand.nextInt(16);
			(new AC_WorldGenMineable(AC_Block.tekkiteOre.blockID, 11, 0)).generate(worldObj, rand, e, r, b);
		}

		for(int x = 0; x < 3; x++)
		{
			int e = i + rand.nextInt(16);
			int r = rand.nextInt(128);
			int b = j + rand.nextInt(16);
			(new AC_WorldGenMineable(AC_Block.escariaOre.blockID, 11, 0)).generate(worldObj, rand, e, r, b);
		}

		for(int x = 0; x < 1; x++)
		{
			int e = i + rand.nextInt(16);
			int r = rand.nextInt(20);
			int b = j + rand.nextInt(16);
			(new AC_WorldGenMineable(AC_Block.glacianOre.blockID, 8, 0)).generate(worldObj, rand, e, r, b);
		}

		for(int x = 0; x < 5; x++)
		{
			int e = i + rand.nextInt(16);
			int r = rand.nextInt(128);
			int b = j + rand.nextInt(16);
			(new AC_WorldGenMineable(AC_Block.eriumOre.blockID, 13, 0)).generate(worldObj, rand, e, r, b);
		}

		for(int x = 0; x < 35; x++)
		{
			int e = i + rand.nextInt(16);
			int r = rand.nextInt(128);
			int b = j + rand.nextInt(16);
			(new AC_WorldGenMineable(AC_Block.frigusOre.blockID, 15, 0)).generate(worldObj, rand, e, r, b);
		}

		for(int x = 0; x < 10; x++)
		{
			int e = i + rand.nextInt(16);
			int r = rand.nextInt(128);
			int b = j + rand.nextInt(16);
			(new AC_WorldGenMineable(AC_Block.rigentemOre.blockID, 12, 0)).generate(worldObj, rand, e, r, b);
		}

		biomegenbase.decorate(this.worldObj, this.rand, i, j);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, i + 8, j + 8, 16, 16, this.rand);
		i += 8;
		j += 8;

		for(int k1 = 0; k1 < 16; k1++)
		{
			for(int l2 = 0; l2 < 16; l2++)
			{
				int l3 = this.worldObj.getPrecipitationHeight(i + k1, j + l2);

				if(this.worldObj.isBlockFreezable(k1 + i, l3 - 1, l2 + j))
				{
					this.worldObj.setBlock(k1 + i, l3 - 1, l2 + j, AC_Block.acWaterIce.blockID);
				}

				if(this.worldObj.canSnowAt(k1 + i, l3, l2 + j))
				{
					if(AC_TickHandler.snowLayersEnabled)
					{
						int meta = (int) Math.abs(rand.nextGaussian() * 4);
						this.worldObj.setBlock(k1 + i, l3, l2 + j, Block.snow.blockID, meta, 3);
					}
					else
					{
						this.worldObj.setBlock(k1 + i, l3, l2 + j, this.pickSnow(rand));
					}
				}
			}
		}

		BlockSand.fallInstantly = false;
	}

	private int pickSnow(Random par1Random)
	{
		int var2 = par1Random.nextInt(4);
		return var2 == 0 ? AC_Block.thickSnow.blockID : Block.snow.blockID;
	}

	/**
	 * Two modes of operation: if passed true, save all Chunks in one go. If
	 * passed false, save up to two chunks. Return true if all chunks have been
	 * saved.
	 */
	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
	{
		return true;
	}

	/**
	 * Unloads the 100 oldest chunks from memory, due to a bug with
	 * chunkSet.add() never being called it thinks the list is always empty and
	 * will not remove any chunks.
	 */
	public boolean unload100OldestChunks()
	{
		return false;
	}

	/**
	 * Returns if the IChunkProvider supports saving.
	 */
	public boolean canSave()
	{
		return true;
	}

	/**
	 * Converts the instance data to a readable string.
	 */
	public String makeString()
	{
		return "RandomLevelSource";
	}

	/**
	 * Returns a list of creatures of the specified type that can spawn at the
	 * given location.
	 */
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
	{
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(par2, par4);
		return var5 == null ? null : var5.getSpawnableList(par1EnumCreatureType);
	}

	/**
	 * Returns the location of the closest structure of the specified type. If
	 * not found returns null.
	 */
	public ChunkPosition findClosestStructure(World par1World, String par2Str, int par3, int par4, int par5)
	{
		return "Stronghold".equals(par2Str) && this.strongholdGenerator != null ? this.strongholdGenerator.getNearestInstance(par1World, par3, par4, par5) : null;
	}

	public int getLoadedChunkCount()
	{
		return 0;
	}

	public void recreateStructures(int par1, int par2)
	{
		if(this.mapFeaturesEnabled)
		{
			this.mineshaftGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
			this.villageGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
			this.strongholdGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
			this.scatteredFeatureGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
		}
	}

	@Override
	public boolean unloadQueuedChunks()
	{
		return false;
	}

	@Override
	public void saveExtraData() {
		// TODO Auto-generated method stub
		
	}
}
