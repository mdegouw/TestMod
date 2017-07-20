package it.degouw.testmod.util;

import it.degouw.testmod.network.Network;
import it.degouw.testmod.network.message.MessageSingleParticleEvent;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by mathijs on 20-7-17.
 */
public class CommonParticleHelper {

    public static void spawnParticleAtLocation(EnumParticleTypes particleType, int dimensionId, double xCoord, double yCoord, double zCoord, double xVelocity, double yVelocity, double zVelocity) {
        spawnParticleAtLocation(particleType, dimensionId, xCoord, yCoord, zCoord, xVelocity, yVelocity, zVelocity, 64d);
    }

    public static void spawnParticleAtLocation(EnumParticleTypes particleType, int dimensionId, double xCoord, double yCoord, double zCoord, double xVelocity, double yVelocity, double zVelocity, double range) {
        Network.INSTANCE.sendToAllAround(new MessageSingleParticleEvent(particleType, xCoord, yCoord, zCoord, xVelocity, yVelocity, zVelocity), new NetworkRegistry.TargetPoint(dimensionId, xCoord, yCoord, zCoord, range));
    }

}
