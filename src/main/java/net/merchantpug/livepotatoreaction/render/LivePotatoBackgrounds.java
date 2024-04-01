package net.merchantpug.livepotatoreaction.render;

import net.merchantpug.livepotatoreaction.LivePotatoReaction;
import net.minecraft.resources.ResourceLocation;

public class LivePotatoBackgrounds {
    public static final ResourceLocation OXIDISED = backgroundTexture("oxidised");

    private static ResourceLocation backgroundTexture(String value) {
        return LivePotatoReaction.asResource("textures/gui/background/" + value + ".png");
    }

}
