package it.degouw.testmod.util;

import it.degouw.testmod.TestMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;

/**
 * Created by mathijs on 21-7-17.
 */
public class ResourceLocationHelper {

    private ResourceLocationHelper() {}

    public static ResourceLocation getResourceLocation(String path) {
        return new ResourceLocation(TestMod.MOD_ID, path);
    }

    public static ModelResourceLocation getModelResourceLocation(String path) {
        return new ModelResourceLocation(TestMod.MOD_ID + ":" + path);
    }

}
