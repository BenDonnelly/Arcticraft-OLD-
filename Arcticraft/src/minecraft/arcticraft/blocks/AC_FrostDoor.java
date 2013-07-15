package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import arcticraft.items.AC_Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_FrostDoor extends BlockDoor
{
    private static final String[] field_94467_a = new String[] {"ac:frost_door_bottom", "ac:frost_door_top"};
    private final int field_94465_b;
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public AC_FrostDoor(int par1, Material par2Material)
    {
        super(par1, par2Material);

            this.field_94465_b = 0;
            float f = 0.5F;
    		float f1 = 1.0F;
    		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);


    }
    @SideOnly(Side.CLIENT)
	/**
	 * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
	 */
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		if (par5 != 1 && par5 != 0)
		{
			int i1 = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;

			if (flag)
			{
				if (j1 == 0 && par5 == 2)
				{
					flag1 = !flag1;
				}
				else if (j1 == 1 && par5 == 5)
				{
					flag1 = !flag1;
				}
				else if (j1 == 2 && par5 == 3)
				{
					flag1 = !flag1;
				}
				else if (j1 == 3 && par5 == 4)
				{
					flag1 = !flag1;
				}
			}
			else
			{
				if (j1 == 0 && par5 == 5)
				{
					flag1 = !flag1;
				}
				else if (j1 == 1 && par5 == 3)
				{
					flag1 = !flag1;
				}
				else if (j1 == 2 && par5 == 4)
				{
					flag1 = !flag1;
				}
				else if (j1 == 3 && par5 == 2)
				{
					flag1 = !flag1;
				}

				if ((i1 & 16) != 0)
				{
					flag1 = !flag1;
				}
			}

			return this.iconArray [this.field_94465_b + (flag1 ? field_94467_a.length : 0) + (flag2 ? 1 : 0)];
		}
		else
		{
			return this.iconArray [this.field_94465_b];
		}
	}


    public Icon getIcon(int par1, int par2)
    {
    	return this.iconArray [this.field_94465_b];
    	}
    
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[field_94467_a.length * 2];

        for (int i = 0; i < field_94467_a.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(field_94467_a[i]);
            this.iconArray[i + field_94467_a.length] = new IconFlipped(this.iconArray[i], true, false);
        }
    }

   
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return AC_Item.frostDoorPlace.itemID;
    }

    
}
