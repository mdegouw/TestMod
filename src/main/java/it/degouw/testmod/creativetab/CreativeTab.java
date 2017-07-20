package it.degouw.testmod.creativetab;

import it.degouw.testmod.TestMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by mathijs on 21-7-17.
 */
public class CreativeTab {

    public static final CreativeTabs TESTMOD_TAB = new CreativeTabs(TestMod.MOD_ID) {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.SLIME_BALL);
        }
    };

}
