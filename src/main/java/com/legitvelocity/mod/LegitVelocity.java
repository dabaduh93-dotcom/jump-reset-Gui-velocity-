package com.legitvelocity.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.lwjgl.input.Keyboard;

@Mod(
    modid = "legitvelocity",
    name = "LegitVelocity",
    version = "1.0",
    acceptedMinecraftVersions = "[1.8.9]"
)
public class LegitVelocity {

    public static KeyBinding openGui;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        openGui = new KeyBinding(
            "LegitVelocity GUI",
            Keyboard.KEY_Z,
            "LegitVelocity"
        );

        net.minecraftforge.fml.client.registry
            .ClientRegistry.registerKeyBinding(openGui);

        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void onKey(InputEvent.KeyInputEvent event) {
        if (openGui.isPressed()) {
            Minecraft mc = Minecraft.getMinecraft();

            if (mc.thePlayer != null) {
                mc.displayGuiScreen(new VelocityGUI());
            }
        }
    }
}
