package it.degouw.testmod.util;

import it.degouw.testmod.reference.Key;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Created by mathijs on 20-7-17.
 */
public interface IKeyBound {

    void doKeyBindingAction(EntityPlayer entityPlayer, ItemStack itemStack, Key key);

}
