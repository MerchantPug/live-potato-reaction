package net.merchantpug.livepotatoreaction.render;

import net.merchantpug.livepotatoreaction.LivePotatoReaction;
import net.merchantpug.livepotatoreaction.api.LiveReactionScreen;
import net.merchantpug.livepotatoreaction.api.LiveReactionScreenManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class LivePotatoReactionRenderer {
    private static final ResourceLocation TV_TEXTURE = LivePotatoReaction.asResource("textures/gui/television.png");
    private static float liveReactionTranslation = 0.0F;
    private static boolean reversed = false;

    public static void render(GuiGraphics graphics, float tickDelta) {
        if (Minecraft.getInstance().screen != null && !(Minecraft.getInstance().screen instanceof ChatScreen)) {
            return;
        }

        LocalPlayer player = Minecraft.getInstance().player;
        float deltaTime = Minecraft.getInstance().getDeltaFrameTime();

        int width = graphics.guiWidth();

        int x = width - 128;
        int y = 14;

        LiveReactionScreen screen = LiveReactionScreenManager.getOrReplaceActiveScreen(player);

        graphics.pose().pushPose();

        graphics.pose().translate(x, y, 0);
        graphics.pose().scale(1.5F, 1.5F, 1.5F);

        graphics.pose().pushPose();
        graphics.pose().translate(0, 0, 0);
        graphics.blit(screen.getBackgroundTexture(), 6, 15, 0, 0, 62, 33, 64, 64);
        graphics.pose().popPose();

        graphics.pose().pushPose();
        graphics.pose().translate(6, 15, 0);
        screen.render(graphics, deltaTime);
        graphics.pose().popPose();

        graphics.pose().pushPose();
        graphics.blit(TV_TEXTURE, 0, 0, 0, 0, 0, 74, 54, 128, 64);
        graphics.pose().popPose();

        graphics.pose().pushPose();
        float translation = (reversed ? -deltaTime : deltaTime) / 16;
        liveReactionTranslation = Mth.clamp(liveReactionTranslation + translation, -0.75F, 0.75F);
        if (liveReactionTranslation > 0.745) {
            reversed = true;
        } else if (liveReactionTranslation < -0.745) {
            reversed = false;
        }
        graphics.pose().translate(0, liveReactionTranslation, 0);
        graphics.blit(TV_TEXTURE, 4, 45, 0, 0, 54, 65, 10, 128, 64);
        graphics.pose().popPose();

        graphics.pose().popPose();
    }

}
