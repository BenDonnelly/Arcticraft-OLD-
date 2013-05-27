package arcticraft.tile_entities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;


public class AC_TileEntityLantern extends TileEntity
{
	int durability;

	@Override
	public void readFromNBT(NBTTagCompound par1nbtTagCompound)
	{
		super.readFromNBT(par1nbtTagCompound);
		this.durability = par1nbtTagCompound.getInteger("durability");
	}

	@Override
	public void writeToNBT(NBTTagCompound par1nbtTagCompound)
	{	
		super.writeToNBT(par1nbtTagCompound);
		par1nbtTagCompound.setInteger("durability", durability);
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	
}
