package com.legitvelocity.mod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class VelocityHandler {

    public static int velocity = 100;
    public static int chance = 75;

    private final Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onHurt(LivingHurtEvent event) {
        if (mc.thePlayer == null) return;

        if (event.entityLiving != mc.thePlayer) return;

        if (velocity == 100) return;

        // Ajuste local de dano recebido.
        event.ammount *= velocity / 100.0F;
    }
}
