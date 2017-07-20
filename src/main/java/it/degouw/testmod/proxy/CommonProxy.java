package it.degouw.testmod.proxy;

import it.degouw.testmod.TestMod;
import it.degouw.testmod.handler.ConfigurationHandler;
import it.degouw.testmod.network.Network;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by mathijs on 20-7-17.
 */
public class CommonProxy implements IProxy {

    @Override
    public void onPreInit(FMLPreInitializationEvent event) {

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        Network.init();
    }

    @Override
    public void onInit(FMLInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
    }

    @Override
    public void onPostInit(FMLPostInitializationEvent event){
    }

    @Override
    public void onServerStarting(FMLServerStartingEvent event){
    }

    @Override
    public void onServerStopping(FMLServerStoppingEvent event){
    }
}
