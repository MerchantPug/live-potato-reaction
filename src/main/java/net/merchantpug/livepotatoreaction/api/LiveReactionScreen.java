package net.merchantpug.livepotatoreaction.api;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;

public interface LiveReactionScreen {

    int SCREEN_WIDTH = 62;
    int SCREEN_HEIGHT = 33;

    void render(GuiGraphics drawContext, float tickDelta);

    ResourceLocation getBackgroundTexture();

    boolean shouldStartRendering(LocalPlayer player);

    default void startRendering() {

    }

    boolean shouldStopRendering(LocalPlayer player);

    default void stopRendering() {

    }

    default int getPriority() {
        return 0;
    }

}
