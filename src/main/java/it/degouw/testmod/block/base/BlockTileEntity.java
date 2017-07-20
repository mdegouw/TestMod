package it.degouw.testmod.block.base;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;

/**
 * Created by mathijs on 21-7-17.
 */
public abstract class BlockTileEntity extends BlockBase implements ITileEntityProvider {

    public BlockTileEntity(String name) {
        this(name, Material.ROCK);
    }

    public BlockTileEntity(String name, Material material) {
        super(name, material);
    }
}
