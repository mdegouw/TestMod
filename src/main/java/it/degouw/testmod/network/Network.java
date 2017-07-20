package it.degouw.testmod.network;

import it.degouw.testmod.TestMod;
import it.degouw.testmod.network.message.MessageKeyPressed;
import it.degouw.testmod.network.message.MessageSingleParticleEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by mathijs on 20-7-17.
 */
public class Network {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(TestMod.MOD_ID);

    public static void init() {

        INSTANCE.registerMessage(MessageKeyPressed.MessageHandler.class, MessageKeyPressed.class, 1, Side.SERVER);
        INSTANCE.registerMessage(MessageSingleParticleEvent.MessageHandler.class, MessageSingleParticleEvent.class, 2, Side.CLIENT);
    }

}
