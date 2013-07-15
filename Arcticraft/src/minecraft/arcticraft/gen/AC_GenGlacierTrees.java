package arcticraft.gen; 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import arcticraft.blocks.AC_Block;
import arcticraft.main.MainRegistry;

public class AC_GenGlacierTrees extends WorldGenerator
{
    private final int field_48202_a;
    private final boolean field_48200_b;
    private final int field_48201_c;
    private final int field_48199_d;

    public AC_GenGlacierTrees(boolean par1)
    {
        this(par1, 4, 0, 0, false);
    }

    public AC_GenGlacierTrees(boolean par1, int par2, int par3, int par4, boolean par5)
    {
        super(par1);
        field_48202_a = par2;
        field_48201_c = par3;
        field_48199_d = par4;
        field_48200_b = par5;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        int i = par2Random.nextInt(3) + 5;
        boolean flag = true;

        if (par4 < 1 || par4 + i + 1 > 256)
        {
            return false;
        }

        for (int j = par4; j <= par4 + 1 + i; j++)
        {
            byte byte0 = 1;

            if (j == par4)
            {
                byte0 = 0;
            }

            if (j >= (par4 + 1 + i) - 2)
            {
                byte0 = 2;
            }

            for (int l = par3 - byte0; l <= par3 + byte0 && flag; l++)
            {
                for (int j1 = par5 - byte0; j1 <= par5 + byte0 && flag; j1++)
                {
                    if (j >= 0 && j < 256)
                    {
                        int j2 = par1World.getBlockId(l, j, j1);

                        if (j2 != 0 && j2 != AC_Block.glacierLeaves.blockID && j2 != AC_Block.frostGrass.blockID && j2 != AC_Block.frostDirt.blockID && j2 != AC_Block.glacierLog.blockID)
                        {
                            flag = false;
                        }
                    }
                    else
                    {
                        flag = false;
                    }
                }
            }
        }

        if (!flag)
        {
            return false;
        }

        int k = par1World.getBlockId(par3, par4 - 1, par5);

        if (k != AC_Block.frostGrass.blockID && k != AC_Block.frostDirt.blockID || par4 >= 256 - i - 1)
        {
            return false;
        }

        par1World.setBlock(par3, par4 - 1, par5, AC_Block.frostDirt.blockID, 0, 2);
        byte byte1 = 3;
        int i1 = 0;

        for (int k1 = (par4 - byte1) + i; k1 <= par4 + i; k1++)
        {
            int k2 = k1 - (par4 + i);
            int j3 = (i1 + 1) - k2 / 2;

            for (int l3 = par3 - j3; l3 <= par3 + j3; l3++)
            {
                int j4 = l3 - par3;

                for (int l4 = par5 - j3; l4 <= par5 + j3; l4++)
                {
                    int i5 = l4 - par5;

                    if ((Math.abs(j4) != j3 || Math.abs(i5) != j3 || par2Random.nextInt(2) != 0 && k2 != 0) && !Block.opaqueCubeLookup[par1World.getBlockId(l3, k1, l4)])
                    {
                        setBlockAndMetadata(par1World, l3, k1, l4, AC_Block.glacierLeaves.blockID, field_48199_d);
                    }
                }
            }
        }

        for (int l1 = 0; l1 < i; l1++)
        {
            int l2 = par1World.getBlockId(par3, par4 + l1, par5);

            if (l2 != 0 && l2 != AC_Block.glacierLeaves.blockID)
            {
                continue;
            }

            setBlockAndMetadata(par1World, par3, par4 + l1, par5, AC_Block.glacierLog.blockID, field_48201_c);

            if (!field_48200_b || l1 <= 0)
            {
                continue;
            }

            
        }

        if (field_48200_b)
        {
            for (int i2 = (par4 - 3) + i; i2 <= par4 + i; i2++)
            {
                int i3 = i2 - (par4 + i);
                int k3 = 2 - i3 / 2;

                for (int i4 = par3 - k3; i4 <= par3 + k3; i4++)
                {
                    for (int k4 = par5 - k3; k4 <= par5 + k3; k4++)
                    {
                        if (par1World.getBlockId(i4, i2, k4) != AC_Block.glacierLeaves.blockID)
                        {
                            continue;
                        }

                        
                    }
                }
            }
        }

        return true;
    }

    
}
