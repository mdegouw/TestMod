package it.degouw.testmod.init;

import it.degouw.testmod.block.base.BlockBase;
import it.degouw.testmod.TestMod;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mathijs on 20-7-17.
 */
@GameRegistry.ObjectHolder(TestMod.MOD_ID)
public class ModBlocks {

    private static final List<BlockBase> BLOCKS = new ArrayList<>();


    public static final BlockBase TEST = new BlockBase("test", Material.GROUND);


    private ModBlocks() {}

    public static Collection<BlockBase> getBlocks() {
        return BLOCKS;
    }

    public static void register(BlockBase block) {
        BLOCKS.add(block);
    }

}
