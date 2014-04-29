package com.arcticraft.handler;

import com.arcticraft.interfaces.AC_IBossDisplayData;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class AC_BossStatus
{

	public AC_BossStatus(String name){
		this.getEntityName = name;
	}
	
	public static float healthScale;
	public static int statusBarLength;
	public static boolean field_82825_d;
	public static String bossName;
	public static boolean isMiniBoss;
	
	private static String getEntityName;

	public static void func_82824_a(AC_IBossDisplayData par0IBossDisplayData, boolean par1)
	{
		healthScale = par0IBossDisplayData.getMaxHealth() / par0IBossDisplayData.getHealth();
		statusBarLength = 100;
		bossName = getEntityName;
		isMiniBoss = par0IBossDisplayData.isMiniBoss();
		field_82825_d = par1;
	}
}
