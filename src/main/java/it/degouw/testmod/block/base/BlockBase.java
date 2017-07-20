package it.degouw.testmod.block.base;

import it.degouw.testmod.TestMod;
import it.degouw.testmod.creativetab.CreativeTab;
import it.degouw.testmod.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by mathijs on 20-7-17.
 */
public class BlockBase extends Block{

    private final String BASE_NAME;

    public BlockBase(String name) {
        this(name, Material.ROCK);
    }

    public BlockBase(String name, Material material) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(CreativeTab.TESTMOD_TAB);
        BASE_NAME = name;
        ModBlocks.register(this);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s:%s", TestMod.MOD_ID, BASE_NAME);
    }

    @SideOnly(Side.CLIENT)
    public void initModelsAndVariants() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName().toString()));
    }

}
