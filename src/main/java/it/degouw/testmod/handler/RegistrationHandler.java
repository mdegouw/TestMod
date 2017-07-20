package it.degouw.testmod.handler;


import it.degouw.testmod.init.ModBlocks;
import it.degouw.testmod.init.ModItems;
import it.degouw.testmod.util.RegisterUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by mathijs on 21-7-17.
 */
@Mod.EventBusSubscriber
public class RegistrationHandler {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        RegisterUtils.registerBlocks(event.getRegistry(), ModBlocks.getBlocks());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegisterUtils.registerItems(event.getRegistry(), ModItems.getItems());
        RegisterUtils.registerItemBlocks(event.getRegistry(), ModBlocks.getBlocks());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        RegisterUtils.registerBlockModels(ModBlocks.getBlocks());
        RegisterUtils.registerItemModels(ModItems.getItems());
    }
}
