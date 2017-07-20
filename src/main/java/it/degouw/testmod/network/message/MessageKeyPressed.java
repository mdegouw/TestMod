package it.degouw.testmod.network.message;

import io.netty.buffer.ByteBuf;
import it.degouw.testmod.reference.Key;
import it.degouw.testmod.util.IKeyBound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by mathijs on 20-7-17.
 */
public class MessageKeyPressed implements IMessage {

    private Key keyPressed;

    public MessageKeyPressed() {
    }

    public MessageKeyPressed(Key keyPressed) {

        if (keyPressed != null) {
            this.keyPressed = keyPressed;
        }
        else {
            this.keyPressed = Key.UNKNOWN;
        }
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.keyPressed = Key.getKey(buf.readByte());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeByte((byte) keyPressed.ordinal());
    }

    public static class MessageHandler implements IMessageHandler<MessageKeyPressed, IMessage> {

        @Override
        public IMessage onMessage(MessageKeyPressed message, MessageContext ctx) {

            EntityPlayer entityPlayer = ctx.getServerHandler().player;

            if (entityPlayer != null && entityPlayer.getHeldItemMainhand() != null && entityPlayer.getHeldItemMainhand().getItem() instanceof IKeyBound) {
                ((IKeyBound) entityPlayer.getHeldItemMainhand().getItem()).doKeyBindingAction(entityPlayer, entityPlayer.getHeldItemMainhand(), message.keyPressed);
            }

            return null;
        }
    }


}
