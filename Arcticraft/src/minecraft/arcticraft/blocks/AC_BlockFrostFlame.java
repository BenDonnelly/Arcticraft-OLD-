package arcticraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockFire;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import arcticraft.entities.AC_EntityGreenSparkle;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AC_BlockFrostFlame extends BlockFire
{

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public AC_BlockFrostFlame(int par1)
	{
		super(par1);
		this.disableStats();
	}

	@Override
	public void randomDisplayTick(World world, int i, int j, int k, Random random)
	{
		super.randomDisplayTick(world, i, j, k, random);

		for(int l = 0; l < 4; l++)
		{
			double d = (double) (float) i + ((double) random.nextFloat() - 0.5D) * 10D;
			double d1 = (double) (float) j + ((double) random.nextFloat() - 0.5D) * 10D;
			double d2 = (double) (float) k + ((double) random.nextFloat() - 0.5D) * 10D;
			double d3 = 0.0D;
			double d4 = 0.0D;
			double d5 = 0.0D;
			d3 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			d4 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			d5 = ((double) random.nextFloat() - 0.5D) * 0.5D;
			AC_EntityGreenSparkle entitybluesparkle = new AC_EntityGreenSparkle(world, d, d1, d2, d3, d4, d5);
			Minecraft.getMinecraft().effectRenderer.addEffect(entitybluesparkle);
		}

	}

	public void registerIcons(IconRegister par1IconRegister)
	{
		this.iconArray = new Icon[] {par1IconRegister.registerIcon("ac:frost_flame_0") , par1IconRegister.registerIcon("ac:frost_flame_1")};
	}

	@SideOnly(Side.CLIENT)
	public Icon func_94438_c(int par1)
	{
		return this.iconArray[par1];
	}

	public Icon getIcon(int par1, int par2)
	{
		return this.iconArray[0];
	}
}
