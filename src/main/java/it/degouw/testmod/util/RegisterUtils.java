package it.degouw.testmod.util;

import it.degouw.testmod.block.base.BlockBase;
import it.degouw.testmod.item.base.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collection;

/**
 * Created by mathijs on 21-7-17.
 */
public class RegisterUtils {

    public static void registerBlocks(IForgeRegistry<Block> registry, Collection<BlockBase> blocks) {

        for (BlockBase block : blocks) {
            registry.register(block);
        }
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry, Collection<BlockBase> blocks) {

        for (BlockBase block : blocks){
            //registry.register(BlockUtils.getItemBlockFor(block));
        }
    }


    public static void registerItems(IForgeRegistry<Item> registry, Collection<ItemBase> items) {

        for (ItemBase item : items) {
            registry.register(item);
        }
    }

    public static void registerBlockModels(Collection<BlockBase> blocks) {

        for (BlockBase block : blocks) {
            block.initModelsAndVariants();
        }
    }

    public static void registerItemModels(Collection<ItemBase> items) {

        for (ItemBase item : items) {
            item.initModelsAndVariants();
        }
    }


}
