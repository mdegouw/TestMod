package it.degouw.testmod.block.base;

import net.minecraft.util.IStringSerializable;

/**
 * Created by mathijs on 21-7-17.
 */
public interface IEnumMeta extends IStringSerializable {

    int getMeta();

    default String getName() {
        return ((Enum) this).name().toLowerCase();
    }
}
