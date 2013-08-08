package arcticraft.helpers;

import java.util.EnumSet;
import java.util.Random;

import arcticraft.items.AC_ItemBlockLantern;
import arcticraft.lib.Debug;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;

import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class AC_ScheduledTickHandler implements IScheduledTickHandler
{
    public int ticksToPass = 1200;
    
    public void tickStart(EnumSet<TickType> type, Object... tickData)
    {
        if (ticksToPass % 100 == 0) Debug.out(ticksToPass + " Ticks left");
        if (ticksToPass > 0) ticksToPass--;
        else processTick();
    }

    public void processTick()
    {
        ServerConfigurationManager configMgr = MinecraftServer.getServerConfigurationManager(MinecraftServer.getServer());
        String[] playerNamesList = configMgr.getAllUsernames();
        
        for (int i = 0; i < playerNamesList.length; i++)
        {
            Debug.out("Call for " + playerNamesList[i] + "'s lantern item");
            AC_ItemBlockLantern.getInstance().damageLanternInInventory(configMgr.getPlayerForUsername(playerNamesList[i]));
        }
        
        ticksToPass = 1150 + new Random().nextInt(300);
    }
    
    public void tickEnd(EnumSet<TickType> type, Object... tickData) { }

    public EnumSet<TickType> ticks()
    {
        return EnumSet.of(TickType.PLAYER);
    }

    public String getLabel()
    {
        return "LanternTickHandler";
    }

    public int nextTickSpacing()
    {
        //ForgeModLoader is derpy, ignoring this number >_<
        //return 900;
        return 0;
    }
    
}
