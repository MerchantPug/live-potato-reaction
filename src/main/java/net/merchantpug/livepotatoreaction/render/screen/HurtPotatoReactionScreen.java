package net.merchantpug.livepotatoreaction.render.screen;

import net.merchantpug.livepotatoreaction.api.LiveReactionScreen;
import net.merchantpug.livepotatoreaction.render.LivePotatoBackgrounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class HurtPotatoReactionScreen implements LiveReactionScreen {
    private int hurtAmount = 0;
    private int previousRunAmount = 0;
    private float tickCount = 0.0F;

    public void incrementHurtAmount() {
        ++hurtAmount;
    }

    public void resetHurtAmount() {
        hurtAmount = 0;
    }

    @Override
    public void render(GuiGraphics drawContext, float tickDelta) {
        switch (hurtAmount) {
            case 10: {

            }
            default: {

            }
        }
        this.tickCount += tickDelta;
    }

    @Override
    public ResourceLocation getBackgroundTexture() {
        return LivePotatoBackgrounds.BLACK;
    }

    @Override
    public boolean shouldStart(LocalPlayer player) {
        return this.hurtAmount > 0 && this.hurtAmount % 10 == 0 && this.previousRunAmount != this.hurtAmount;
    }

    @Override
    public void start() {
        this.tickCount = 0.0F;
        this.previousRunAmount = this.hurtAmount;
        Minecraft.getInstance().getChatListener().handleSystemMessage(Component.translatable("livepotatoreaction.hurt", this.hurtAmount), true);
    }

    @Override
    public boolean shouldStop(LocalPlayer player) {
        return this.tickCount > 60;
    }

    @Override
    public int getPriority() {
        return 5;
    }
}
