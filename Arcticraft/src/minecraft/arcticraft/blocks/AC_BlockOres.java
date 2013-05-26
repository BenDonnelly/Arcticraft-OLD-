package arcticraft.blocks;

import java.util.Random;

import arcticraft.main.MainRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AC_BlockOres extends Block {

	public AC_BlockOres(int par1) {
		super(par1, Material.rock);
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3) {
		if (this == MainRegistry.tekkiteOre) {
			return MainRegistry.tekkiteGem.itemID;
		}
		
		if (this == MainRegistry.escariaOre) {
			return MainRegistry.escariaGem.itemID;
		}
		
		if (this == MainRegistry.frigusOre) {
			return MainRegistry.frigus.itemID;
		}
		
		if (this == MainRegistry.glacianOre) {
			return MainRegistry.glacianOre.blockID;
		}
		
		if (this == MainRegistry.rigentemOre) {
			return MainRegistry.rigentemOre.blockID;
		}
		
		
		else return this.blockID;
	}
}
