package it.degouw.testmod;

import it.degouw.testmod.proxy.IProxy;
import it.degouw.testmod.reference.Messages;
import it.degouw.testmod.util.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;

/**
 * Created by mathijs on 20-7-17.
 */
@Mod(modid = TestMod.MOD_ID,
        name = "Test Mod",
        certificateFingerprint = TestMod.FINGERPRINT,
        version = "@MOD_VERSION@",
        guiFactory = "it.degouw.testmod.client.gui.GuiFactory",
        updateJSON = "http://testmod.degouw.it/update/versions.json")
public class TestMod {

    public static final String MOD_ID = "testmod";
    static final String FINGERPRINT = "@FINGERPRINT@";

    @Mod.Instance(TestMod.MOD_ID)
    public static TestMod instance;

    @SidedProxy(clientSide = "it.degouw.testmod.proxy.ClientProxy", serverSide = "it.degouw.testmod.proxy.ServerProxy")
    public static IProxy proxy;

    @Mod.EventHandler
    public void invalidFingerprint(FMLFingerprintViolationEvent event) {

        if (FINGERPRINT.equals("@FINGERPRINT@")) {
            LogHelper.info(Messages.NO_FINGERPRINT);
        }
        else {
            LogHelper.warn(Messages.INVALID_FINGERPRINT);
        }
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        proxy.onServerStarting(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.onPreInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.onInit(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.onPostInit(event);
    }

    @Mod.EventHandler
    public void onServerStopping(FMLServerStoppingEvent event) {
        proxy.onServerStopping(event);
    }


}
