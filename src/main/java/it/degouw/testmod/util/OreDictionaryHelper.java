package it.degouw.testmod.util;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mathijs on 20-7-17.
 */
public class OreDictionaryHelper {

    public static Collection<String> getOreNames(ItemStack itemStack) {

        Set<String> oreNames = new TreeSet<>();

        for (int oreId : OreDictionary.getOreIDs(itemStack)) {
            oreNames.add(OreDictionary.getOreName(oreId));
        }

        return oreNames;
    }

}
