package it.degouw.testmod.item.base;

import it.degouw.testmod.TestMod;
import it.degouw.testmod.creativetab.CreativeTab;
import it.degouw.testmod.init.ModItems;
import it.degouw.testmod.util.ResourceLocationHelper;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mathijs on 21-7-17.
 */
public class ItemBase extends Item implements IItemVariantHolder<ItemBase> {

    private final String BASE_NAME;
    private final String[] VARIANTS;

    public ItemBase(String name, String ... variants) {

        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.TESTMOD_TAB);
        setMaxStackSize(1);
        setNoRepair();

        BASE_NAME = name;
        if (variants.length > 0) {
            VARIANTS = variants;
        }
        else {
            VARIANTS = new String[0];
        }

        ModItems.register(this);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {

        if (hasSubtypes && itemStack.getMetadata() < VARIANTS.length) {
            return String.format("item.%s:%s", TestMod.MOD_ID, VARIANTS[Math.abs(itemStack.getMetadata() % VARIANTS.length)]);
        }
        else {
            return String.format("item.%s:%s", TestMod.MOD_ID, BASE_NAME);
        }
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTab, NonNullList<ItemStack> list) {

        if (getHasSubtypes() && VARIANTS.length > 0) {
            for (int meta = 0; meta < VARIANTS.length; ++meta) {
                list.add(new ItemStack(this, 1, meta));
            }
        }
        else {
            list.add(new ItemStack(this, 1, 0));
            super.getSubItems(creativeTab, list);
        }
    }

    @SideOnly(Side.CLIENT)
    public void initModelsAndVariants() {

        if (getCustomMeshDefinition() != null) {

            for (int i = 0; i < VARIANTS.length; i++) {
                ModelBakery.registerItemVariants(this, ResourceLocationHelper.getModelResourceLocation(VARIANTS[i]));
            }

            ModelLoader.setCustomMeshDefinition(this, getCustomMeshDefinition());
        }
        else {

            if (getHasSubtypes() && VARIANTS.length > 0) {
                List<ModelResourceLocation> modelResources = new ArrayList<>();

                for (int i = 0; i < VARIANTS.length; i++) {
                    modelResources.add(ResourceLocationHelper.getModelResourceLocation(VARIANTS[i]));
                }

                ModelBakery.registerItemVariants(this, modelResources.toArray(new ModelResourceLocation[0]));
                ModelLoader.setCustomMeshDefinition(this, itemStack -> modelResources.get(itemStack.getMetadata()));
            }
            else {
                ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName().toString()));
            }
        }
    }

    @Override
    public ItemBase getItem() {
        return this;
    }

    @Override
    public String[] getVariants() {
        return VARIANTS;
    }
}
