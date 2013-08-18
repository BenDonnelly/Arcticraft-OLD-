package arcticraft.helpers;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WorldHelper 
{
    public static void dropItemInWorld(World world, int x, int y, int z, ItemStack stack, int lifeSpan, int pickupDelay, double dropDistance)
    {
        float f = 0.7F;
        double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * dropDistance;
        double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * dropDistance;
        double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * dropDistance;
        EntityItem entityitem = new EntityItem(world, (double)x + d0, (double)y + d1, (double)z + d2, stack);
        entityitem.lifespan = lifeSpan;
        entityitem.delayBeforeCanPickup = pickupDelay;
        world.spawnEntityInWorld(entityitem);
    }
    
    public static void dropItemInWorld(World world, int x, int y, int z, ItemStack stack)
    {
    	dropItemInWorld(world, x, y, z, stack, 6000, 10, 0.5D);
    }
}
