package arcticraft.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class AC_ItemWhiteberry extends ItemFood implements IPlantable
{
    /** Block ID of the crop this seed food should place. */
    private int cropId;

    /** Block ID of the soil this seed food should be planted on. */
    private int soilId;

    public AC_ItemWhiteberry(int par1, int par2, float par3, int par4, int par5)
    {
        super(par1, par2, par3, false);
        this.cropId = par4;
        this.soilId = par5;
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        int i1 = par3World.getBlockId(par4, par5, par6);

        if (i1 == Block.snow.blockID && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
        {
            par7 = 1;
        }
        else if (i1 != Block.vine.blockID && i1 != Block.tallGrass.blockID && i1 != Block.deadBush.blockID)
        {
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else if (par1ItemStack.stackSize == 0)
        {
            return false;
        }
        else
        {
            if (par3World.canPlaceEntityOnSide(this.soilId, par4, par5, par6, false, par7, (Entity)null, par1ItemStack))
            {
                Block block = Block.blocksList[this.soilId];
                int j1 = block.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);

                if (par3World.setBlock(par4, par5, par6, this.soilId, j1, 3))
                {
                    if (par3World.getBlockId(par4, par5, par6) == this.soilId)
                    {
                        Block.blocksList[this.soilId].onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
                        Block.blocksList[this.soilId].onPostBlockPlaced(par3World, par4, par5, par6, j1);
                    }

                    par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getPlaceSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                    --par1ItemStack.stackSize;
                }
            }

            return true;
        }
    
    }

    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return EnumPlantType.Crop;
    }

    @Override
    public int getPlantID(World world, int x, int y, int z)
    {
        return cropId;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z)
    {
        return 0;
    }
}
