package it.degouw.testmod.init;


import it.degouw.testmod.item.base.ItemBase;
import it.degouw.testmod.TestMod;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mathijs on 20-7-17.
 */
@GameRegistry.ObjectHolder(TestMod.MOD_ID)
public class ModItems {

    private static final List<ItemBase> ITEMS = new ArrayList<>();


    private ModItems() {}

    public static Collection<ItemBase> getItems() {
        return ITEMS;
    }

    public static void register(ItemBase item) {
        ITEMS.add(item);
    }

}
