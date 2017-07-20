package it.degouw.testmod.util;

import it.degouw.testmod.block.base.BlockEnum;
import it.degouw.testmod.item.base.ItemBlockEnum;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 * Created by mathijs on 20-7-17.
 */
public class BlockUtils {

    private BlockUtils() {}

    public static ItemBlock getItemBlockFor(Block block) {
        return block instanceof BlockEnum ? new ItemBlockEnum((BlockEnum) block) : new ItemBlock(block);
    }

}
