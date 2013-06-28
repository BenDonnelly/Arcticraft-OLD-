package arcticraft.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class AC_BossStatus
{
    public static float healthScale;
    public static int statusBarLength;
    public static boolean field_82825_d;
    public static String bossName;
    
    public static void func_82824_a(AC_IBossDisplayData par0IBossDisplayData, boolean par1)
    {
        healthScale = (float)par0IBossDisplayData.getBossHealth() / (float)par0IBossDisplayData.getMaxHealth();
        statusBarLength = 100;
        field_82825_d = par1;
        bossName = par0IBossDisplayData.getEntityName();
    }
}
