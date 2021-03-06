package com.arcticraft.world;

import java.util.Random;

import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.DimensionManager;

import com.arcticraft.main.MainRegistry;

public class WorldProviderArctic extends WorldProvider
{

	private Random rand = new Random();

	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new AC_WorldChunkManager(worldObj.getSeed(), terrainType);
		this.dimensionId = MainRegistry.dimensionId;
		//this.setSkyRenderer(new AC_RenderHandlerTest());
	}

	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderArctic(this.worldObj, this.worldObj.getSeed(), true);
	}

	public static WorldProvider getProviderForDimension(int id)
	{
		return DimensionManager.createProviderFor(MainRegistry.dimensionId);
	}

	@Override
	public String getSaveFolder()
	{
		return "ARCTIC";
	}

	public float calculateCelestialAngle(long par1, float par3)
	{
		return 3.7F;
	}

	public Vec3 getFogColor(float par1, float par2)
	{
		return Vec3.createVectorHelper(0.1, 0.9, 1.0);
	}

	/**
	 * True if the player can respawn in this dimension (true = overworld, false
	 * = nether).
	 */
	public boolean canRespawnHere()
	{
		return false;
	}

	public String getWelcomeMessage()
	{
		return pickWelcomeMessage(rand) + " The Arctic";
	}

	public String getDepartMessage()
	{
		return pickDepartMessage(rand);
	}

	private String pickDepartMessage(Random par1Random)
	{
		int var2 = par1Random.nextInt(4);
		return var2 == 0 ? "Leaving The Arctic" : (var2 == 1 ? "Returning from The Arctic" : (var2 == 2 ? "Teleporting from The Arctic" : "Forming in The Overworld"));
	}

	private String pickWelcomeMessage(Random par1Random)
	{
		int var2 = par1Random.nextInt(5);
		return var2 == 0 ? "Entering" : (var2 == 1 ? "Re-Materializing in" : (var2 == 2 ? "Forming in" : (var2 == 3 ? "Sending To" : "Teleporting to")));
	}

	public String getDimensionName()
	{
		return "Arcticraft";
	}

}
