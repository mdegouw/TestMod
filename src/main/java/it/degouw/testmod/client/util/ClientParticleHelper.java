package it.degouw.testmod.client.util;

import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.client.FMLClientHandler;

/**
 * Created by mathijs on 20-7-17.
 */
public class ClientParticleHelper {

    public static void spawnParticleAtLocation(EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, double xVelocity, double yVelocity, double zVelocity, int... parameters) {
        FMLClientHandler.instance().getWorldClient().spawnParticle(particleType, xCoord, yCoord, zCoord, xVelocity, yVelocity, zVelocity);
    }

}
