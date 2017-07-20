package it.degouw.testmod.client.settings;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

/**
 * Created by mathijs on 20-7-17.
 */
@SideOnly(Side.CLIENT)
public class KeyBindings {

    private static final String CATEGORY = "key.categories.testmod";

    public static final KeyBinding TEST = new KeyBinding("key.test", Keyboard.KEY_V, CATEGORY);

}
