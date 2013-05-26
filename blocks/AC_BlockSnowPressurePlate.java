package arcticraft.blocks;

import java.util.Iterator;
import java.util.List;

import net.minecraft.block.BlockBasePressurePlate;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AC_BlockSnowPressurePlate extends BlockBasePressurePlate
{
    /** The mob type that can trigger this pressure plate. */
    private EnumMobType triggerMobType;

    public AC_BlockSnowPressurePlate(int par1, String par2Str, Material par3Material, EnumMobType par4EnumMobType)
    {
        super(par1, par2Str, par3Material);
        this.triggerMobType = par4EnumMobType;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
    }

    public void setBlockBoundsForItemRender()
    {
        this.func_96478_d(0);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.func_96478_d(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }

    protected void func_96478_d(int par1)
    {
        int j = par1 & 7;
        float f = (float)(2 * (1 + j)) / 16.0F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }

    
    protected int func_94355_d(int par1)
    {
        return par1 > 0 ? 1 : 0;
    }

    protected int func_94350_c(int par1)
    {
        return par1 == 1 ? 15 : 0;
    }

    protected int func_94351_d(World par1World, int par2, int par3, int par4)
    {
        List list = null;

        if (this.triggerMobType == EnumMobType.players)
        {
            list = par1World.getEntitiesWithinAABB(EntityPlayer.class, this.func_94352_a(par2, par3, par4));
        }

        if (!list.isEmpty())
        {
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                Entity entity = (Entity)iterator.next();

                if (!entity.doesEntityNotTriggerPressurePlate())
                {
                    return 15;
                }
            }
        }

        return 0;
    }
}
