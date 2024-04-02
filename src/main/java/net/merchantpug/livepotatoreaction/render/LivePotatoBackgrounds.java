package net.merchantpug.livepotatoreaction.render;

import net.merchantpug.livepotatoreaction.LivePotatoReaction;
import net.minecraft.resources.ResourceLocation;

public class LivePotatoBackgrounds {
    public static final ResourceLocation BLACK = backgroundTexture("black");
    public static final ResourceLocation LIGHT_BLUE = backgroundTexture("light_blue");
    public static final ResourceLocation PURPLE = backgroundTexture("purple");
    public static final ResourceLocation RED = backgroundTexture("red");
    public static final ResourceLocation YELLOW = backgroundTexture("yellow");

    private static ResourceLocation backgroundTexture(String value) {
        return LivePotatoReaction.asResource("textures/gui/background/" + value + ".png");
    }

}
