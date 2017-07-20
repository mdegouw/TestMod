package it.degouw.testmod.proxy;

import it.degouw.testmod.client.util.ClientParticleHelper;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by mathijs on 20-7-17.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public ClientProxy getClientProxy()
    {
        return this;
    }

    @Override
    public void onPreInit(FMLPreInitializationEvent event) {

        super.onPreInit(event);
    }

    @Override
    public void onInit(FMLInitializationEvent event) {

        super.onInit(event);
    }

    @Override
    public void spawnParticle(EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, double xVelocity, double yVelocity, double zVelocity) {
        ClientParticleHelper.spawnParticleAtLocation(particleType, xCoord, yCoord, zCoord, xVelocity, yVelocity, zVelocity);
    }

}
