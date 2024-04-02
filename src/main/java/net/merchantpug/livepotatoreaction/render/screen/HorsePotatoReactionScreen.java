package net.merchantpug.livepotatoreaction.render.screen;

import com.mojang.math.Axis;
import net.merchantpug.livepotatoreaction.LivePotatoReaction;
import net.merchantpug.livepotatoreaction.api.LiveReactionScreen;
import net.merchantpug.livepotatoreaction.render.LivePotatoBackgrounds;
import net.merchantpug.livepotatoreaction.render.model.PotatoHorseModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.horse.Horse;

public class HorsePotatoReactionScreen implements LiveReactionScreen {

    private PotatoHorseModel horseModel;

    @Override
    public void render(GuiGraphics graphics, float tickDelta) {
        if (horseModel == null) {
            horseModel = new PotatoHorseModel(Minecraft.getInstance().getEntityModels().bakeLayer(PotatoHorseModel.LAYER_LOCATION));
        }
        graphics.pose().pushPose();
        graphics.pose().translate(0, 0, 0);
        graphics.pose().mulPose(Axis.XN.rotationDegrees(70));
        graphics.pose().mulPose(Axis.YP.rotationDegrees(140));
        graphics.pose().mulPose(Axis.ZP.rotationDegrees(40));
        graphics.pose().scale(48, 48, 48);
        horseModel.getRoot().render(graphics.pose(), graphics.bufferSource().getBuffer(horseModel.renderType(LivePotatoReaction.asResource("textures/potato_horse.png"))), 15728850, OverlayTexture.NO_OVERLAY);
        graphics.pose().popPose();
        horseModel.getRoot().resetPose();
    }

    @Override
    public ResourceLocation getBackgroundTexture() {
        return LivePotatoBackgrounds.LIGHT_BLUE;
    }

    @Override
    public boolean shouldStart(LocalPlayer player) {
        return player.getVehicle() instanceof Horse;
    }

    @Override
    public boolean shouldStop(LocalPlayer player) {
        return !shouldStart(player);
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
