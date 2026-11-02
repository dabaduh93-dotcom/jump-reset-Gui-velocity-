package com.legitvelocity.mod;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;
import java.io.IOException;

public class VelocityGUI extends GuiScreen {

    @Override
    public void initGui() {
        buttonList.clear();

        buttonList.add(new GuiButton(
            0, width / 2 - 100, height / 2 - 40,
            200, 20,
            "Chance: " + VelocityHandler.chance + "%"
        ));

        buttonList.add(new GuiButton(
            1, width / 2 - 100, height / 2 - 10,
            200, 20,
            "Velocity: " + VelocityHandler.velocity + "%"
        ));

        buttonList.add(new GuiButton(
            2, width / 2 - 100, height / 2 + 30,
            200, 20, "Fechar"
        ));
    }

    @Override
    protected void actionPerformed(GuiButton button)
            throws IOException {

        if (button.id == 0) {
            VelocityHandler.chance += 5;

            if (VelocityHandler.chance > 100) {
                VelocityHandler.chance = 0;
            }
        }

        if (button.id == 1) {
            VelocityHandler.velocity += 10;

            if (VelocityHandler.velocity > 200) {
                VelocityHandler.velocity = 0;
            }
        }

        if (button.id == 2) {
            mc.displayGuiScreen(null);
            return;
        }

        initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        drawCenteredString(
            fontRendererObj,
            "LEGIT VELOCITY",
            width / 2,
            height / 2 - 80,
            0xFFFFFF
        );

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
