package it.degouw.testmod.item.base;

import net.minecraft.client.renderer.ItemMeshDefinition;

/**
 * Created by mathijs on 21-7-17.
 */
public interface IItemVariantHolder<T extends ItemBase> {

    T getItem();

    String[] getVariants();

    default ItemMeshDefinition getCustomMeshDefinition() {
        return null;
    }
}
