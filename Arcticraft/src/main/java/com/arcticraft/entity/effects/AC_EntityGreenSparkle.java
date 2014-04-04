package com.arcticraft.entity.effects;

import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.world.World;

public class AC_EntityGreenSparkle extends EntitySpellParticleFX
{

	public AC_EntityGreenSparkle(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
	{
		super(par1World, par2, par4, par6, par8, par10, par12);
		particleRed = 0.5F;
		particleGreen = 0.7F;
		particleBlue = 0.5F;

	}
}
