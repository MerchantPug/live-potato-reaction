package net.merchantpug.livepotatoreaction.render.screens;

import com.mojang.math.Axis;
import net.merchantpug.livepotatoreaction.api.LiveReactionScreen;
import net.merchantpug.livepotatoreaction.render.LivePotatoBackgrounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class DefaultPotatoReactionScreen implements LiveReactionScreen {
    private float age = 0.0F;
    private float bobOffset = 0.0F;

    @Override
    public void render(GuiGraphics graphics, float tickDelta) {
        ItemStack potato = new ItemStack(Items.POTATO);
        BakedModel bakedModel = Minecraft.getInstance().getItemRenderer().getModel(potato, Minecraft.getInstance().level, null, 0);
        float j = Mth.sin((age + tickDelta) / 10.0F + this.bobOffset) * 0.1F + 0.1F;
        float k = bakedModel.getTransforms().getTransform(ItemDisplayContext.GROUND).scale.y();
        graphics.pose().translate(SCREEN_WIDTH / 2F - 2F,  SCREEN_HEIGHT / 2F, -8.0F);
        graphics.pose().translate(0.0F, j + 0.25F * k, 0.0f);
        graphics.pose().mulPose(Axis.XP.rotation(Mth.PI));
        graphics.pose().mulPose(Axis.YP.rotation((this.age + tickDelta) / 20.0F + this.bobOffset));
        graphics.pose().scale(64.0F, 64.0F, -64.0F);
        Minecraft.getInstance().getItemRenderer().render(potato, ItemDisplayContext.GROUND, false, graphics.pose(), graphics.bufferSource(), 15728850, OverlayTexture.NO_OVERLAY, bakedModel);
        age += tickDelta;
    }

    @Override
    public ResourceLocation getBackgroundTexture() {
        return LivePotatoBackgrounds.OXIDISED;
    }

    @Override
    public boolean shouldStartRendering(LocalPlayer player) {
        return true;
    }

    public void startRendering() {
        this.age = 0.0F;
        this.bobOffset = Minecraft.getInstance().level.random.nextFloat() * 3.1415927F * 2.0F;
    }

    @Override
    public boolean shouldStopRendering(LocalPlayer player) {
        return false;
    }
}
