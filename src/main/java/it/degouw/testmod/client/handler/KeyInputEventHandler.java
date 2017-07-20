package it.degouw.testmod.client.handler;

import it.degouw.testmod.client.settings.KeyBindings;
import it.degouw.testmod.network.Network;
import it.degouw.testmod.network.message.MessageKeyPressed;
import it.degouw.testmod.reference.Key;
import it.degouw.testmod.util.IKeyBound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by mathijs on 20-7-17.
 */
@SideOnly(Side.CLIENT)
public class KeyInputEventHandler {

    private static Key getPressedKeybinding() {

        if (KeyBindings.TEST.isPressed()) {
            return Key.TEST;
        }
        else {
            return Key.UNKNOWN;
        }
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event) {

        Key pressedKey = getPressedKeybinding();

        if (pressedKey == Key.UNKNOWN) {
            return;
        }

        if (FMLClientHandler.instance().getClient().inGameHasFocus && FMLClientHandler.instance().getClientPlayerEntity() != null) {

            EntityPlayer entityPlayer = FMLClientHandler.instance().getClientPlayerEntity();

            if (entityPlayer.getHeldItemMainhand() != null && entityPlayer.getHeldItemMainhand().getItem() instanceof IKeyBound) {
                if (entityPlayer.getEntityWorld().isRemote) {
                    Network.INSTANCE.sendToServer(new MessageKeyPressed(getPressedKeybinding()));
                }
                else {
                    ((IKeyBound) entityPlayer.getHeldItemMainhand().getItem()).doKeyBindingAction(entityPlayer, entityPlayer.getHeldItemMainhand(), getPressedKeybinding());
                }
            }
        }

    }

}
