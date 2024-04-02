package net.merchantpug.livepotatoreaction.api;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;

public interface LiveReactionScreen {

    int SCREEN_WIDTH = 62;
    int SCREEN_HEIGHT = 33;

    void render(GuiGraphics graphics, float tickDelta);

    ResourceLocation getBackgroundTexture();

    boolean shouldStart(LocalPlayer player);

    default void start() {

    }

    boolean shouldStop(LocalPlayer player);

    default void stop() {

    }

    default int getPriority() {
        return 0;
    }

}
