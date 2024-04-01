package net.merchantpug.livepotatoreaction.api;

import net.merchantpug.livepotatoreaction.LivePotatoReaction;
import net.merchantpug.livepotatoreaction.render.screens.DefaultPotatoReactionScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class LiveReactionScreenManager {
    private static final Map<ResourceLocation, LiveReactionScreen> REGISTRY = new HashMap<>();
    private static final LiveReactionScreen DEFAULT_SCREEN = new DefaultPotatoReactionScreen();
    private static LiveReactionScreen activeScreen;

    public static LiveReactionScreen register(ResourceLocation key, LiveReactionScreen screen) {
        return REGISTRY.put(key, screen);
    }

    public static LiveReactionScreen getOrReplaceActiveScreen(LocalPlayer player) {
        if (activeScreen == null || activeScreen.shouldStopRendering(player)) {
            activeScreen = DEFAULT_SCREEN;
        }
        for (LiveReactionScreen screen : REGISTRY.values()) {
            if (screen.getPriority() > activeScreen.getPriority() && screen.shouldStartRendering(player)) {
                activeScreen = screen;
            }
        }
        return activeScreen;
    }
}
