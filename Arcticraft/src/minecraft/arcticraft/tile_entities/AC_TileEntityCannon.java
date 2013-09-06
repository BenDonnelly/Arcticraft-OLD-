package arcticraft.tile_entities;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import arcticraft.entities.AC_EntityCannonball;

public class AC_TileEntityCannon extends TileEntity
{
	//private int this.blockMetadata = this.blockMetadata;
	public boolean isLoaded;
	private int fuse;

	public AC_TileEntityCannon()
	{

	}

	@Override
	public void updateEntity()
	{
		System.out.println(this.blockMetadata);
		if(isLoaded)
		{
			fuse++;
			if(fuse == 100)
			{
				AC_EntityCannonball cannonball = new AC_EntityCannonball(worldObj, this.xCoord, this.yCoord, this.zCoord);
				if(this.blockMetadata == 4)
				{
					cannonball.setPosition(this.xCoord, this.yCoord + 2, this.zCoord + 2);
					cannonball.setVelocity(0, 2.0, 0.7);
					Minecraft.getMinecraft().sndManager.playSoundFX("ac:misc.cannon", 1.5F, 1.5F);
					worldObj.spawnEntityInWorld(cannonball);
					isLoaded = false;
					fuse = 0;
				}
				else if(this.blockMetadata == 3)
				{
					cannonball.setPosition(this.xCoord + 1.5, this.yCoord + 2, this.zCoord - 1);
					cannonball.setVelocity(0.625, 2.0, 0.025);
					Minecraft.getMinecraft().sndManager.playSoundFX("ac:misc.cannon", 1.5F, 1.5F);
					worldObj.spawnEntityInWorld(cannonball);
					isLoaded = false;
					fuse = 0;
				}
				else if(this.blockMetadata == 2)
				{
					cannonball.setPosition(this.xCoord, this.yCoord + 2, this.zCoord - 1);
					cannonball.setVelocity(0, 2.0, - 0.7);
					Minecraft.getMinecraft().sndManager.playSoundFX("ac:misc.cannon", 1.5F, 1.5F);
					worldObj.spawnEntityInWorld(cannonball);
					isLoaded = false;
					fuse = 0;
				}
				else if(this.blockMetadata == 1)
				{
					cannonball.setPosition(this.xCoord - 1.5, this.yCoord + 2, this.zCoord + 1);
					cannonball.setVelocity(- 0.625, 2.0, - 0.025);
					Minecraft.getMinecraft().sndManager.playSoundFX("ac:misc.cannon", 1.5F, 1.5F);
					worldObj.spawnEntityInWorld(cannonball);
					isLoaded = false;
					fuse = 0;
				}
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		compound.getBoolean("loaded");
		compound.getInteger("fuse");
	}
	
	public void writeToNBT(NBTTagCompound compound)
	{
		compound.setBoolean("loaded", isLoaded);
		compound.setInteger("fuse", fuse);
	}
}
