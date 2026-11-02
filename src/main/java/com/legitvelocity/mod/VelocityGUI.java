package com.legitvelocity.mod;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;
import java.io.IOException;

public class VelocityGUI extends GuiScreen {

    private int chance = 75;
    private int velocity = 100;

    @Override
    public void initGui() {
        buttonList.clear();

        buttonList.add(new GuiButton(
            0, width / 2 - 100, height / 2 - 40,
            200, 20, "Chance: " + chance + "%"
        ));

        buttonList.add(new GuiButton(
            1, width / 2 - 100, height / 2 - 10,
            200, 20, "Velocity: " + velocity + "%"
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
            chance += 5;
            if (chance > 100) chance = 0;
        }

        if (button.id == 1) {
            velocity += 10;
            if (velocity > 200) velocity = 0;
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
