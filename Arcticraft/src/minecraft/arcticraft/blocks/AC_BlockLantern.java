package arcticraft.blocks;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;

import arcticraft.helpers.WorldHelper;
import arcticraft.items.AC_Item;
import arcticraft.lib.Debug;
import arcticraft.main.MainRegistry;
import arcticraft.recipes.AC_RecipeLanternRefuel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AC_BlockLantern extends Block
{
	public AC_BlockLantern(int blockID)
	{
		super(blockID, Material.circuits);
		setTickRandomly(true);
        //float f = 0.15F;
        //setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
        setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
        setCreativeTab(MainRegistry.tabBlocks);
        setTickRandomly(true);
        GameRegistry.addRecipe(new AC_RecipeLanternRefuel());
	}
	
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (world.getBlockMetadata(x, y, z) < 15) world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 3);
    }
    
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        Debug.out(world.getBlockMetadata(x, y, z));
        
        if (world.getBlockMetadata(x, y, z) == 15) return 0;
        if (world.getBlockMetadata(x, y, z) == 14) return 4;
        if (world.getBlockMetadata(x, y, z) == 13) return 6;
        if (world.getBlockMetadata(x, y, z) == 12) return 8;
        if (world.getBlockMetadata(x, y, z) == 11) return 10;
        if (world.getBlockMetadata(x, y, z) == 10) return 12;
        return 15;
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (player.isSneaking()) tellFuelStatus(player, world, x, y, z);
        else if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().itemID == AC_Item.frigus.itemID) refuel(player, world, x, y, z);
        else if (Debug.debugMode) this.updateTick(world, x, y, z, new Random());
        return true;
    }
    
    public boolean tellFuelStatus(EntityPlayer player, World world, int x, int y, int z)
    {
        if (!world.isRemote) return false;
        player.addChatMessage("This lantern is " + getFuelLevel(world, x, y, z));
        return true;
    }

    public String getFuelLevel(World world, int x, int y, int z)
    {
        int m = world.getBlockMetadata(x, y, z);
        if (m == 0) return "full";
        if (m > 0 && m < 4) return "almost full";
        if (m > 3 && m < 8) return "more than half full";
        if (m == 8) return "half full";
        if (m > 8 && m < 11) return "less then half full";
        if (m > 11 && m < 15) return "almost empty";
        if (m == 15) return "empty";
        return "bugged, you should report this bug.";
    }

    public boolean refuel(EntityPlayer player, World world, int x, int y, int z)
    {
        if (world.getBlockMetadata(x, y, z) == 0) return false;
        world.setBlockMetadataWithNotify(x, y, z, (world.getBlockMetadata(x, y, z) < 4 ? 0 : world.getBlockMetadata(x, y, z) - 4), 3);
        
        if (!player.capabilities.isCreativeMode)
        {
            if (player.getCurrentEquippedItem().stackSize == 1) player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
            else player.inventory.setInventorySlotContents(player.inventory.currentItem, new ItemStack(AC_Item.frigus.itemID, player.getCurrentEquippedItem().stackSize - 1, 0));
        }
        
        return true;
    }

    public int damageDropped(int meta)
    {
        return meta;
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}
	
	public void registerIcons(IconRegister iconRegistry)
	{
		blockIcon = iconRegistry.registerIcon("AC:lantern");
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
	
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return world.doesBlockHaveSolidTopSurface(x, y - 1, z) || (Block.blocksList[world.getBlockId(x, y - 1, z)] != null && Block.blocksList[world.getBlockId(x, y - 1, z)].canPlaceTorchOnTop(world, x, y - 1, z));
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighborID)
	{
		if (!canPlaceBlockAt(world, x, y, z))
		{
			int damage = world.getBlockMetadata(x, y, z);
			world.setBlockToAir(x, y, z);
			WorldHelper.dropItemInWorld(world, x, y, z, new ItemStack(this.blockID, 1, damage));
		}
	}
}