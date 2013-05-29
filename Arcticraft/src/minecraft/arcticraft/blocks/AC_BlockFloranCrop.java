package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import arcticraft.main.MainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_BlockFloranCrop extends BlockCrops
{
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;
    private static AC_BlockFloranCrop theFloranCrop;
    private Minecraft mc;

    public AC_BlockFloranCrop(int par1)
    {
        super(par1);
        theFloranCrop = this;
        mc = mc.getMinecraft();
        
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        if (par2 < 7)
        {
            if (par2 == 6)
            {
                par2 = 5;
            }

            return this.iconArray[par2 >> 1];
        }
        else
        {
            return this.iconArray[3];
        }
    }
	
    
    public static AC_BlockFloranCrop getFloran()
	{
		
		return theFloranCrop;
	}
    
    public void test(World world, int x, int y, int z)
    {
    }

	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public int getRenderType()
	{
		return 1;
	}
    
    /**
     * Generate a seed ItemStack for this crop.
     */
    protected int getSeedItem()
    {
        return MainRegistry.floranSeed.itemID;
    }

    /**
     * Generate a crop produce ItemStack for this crop.
     */
    protected int getCropItem()
    {
        return MainRegistry.floranBerry.itemID;
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return par1 == 7 ? this.getCropItem() : this.getSeedItem();
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[4];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon("AC:floran_" + i);
        }
    }

}
