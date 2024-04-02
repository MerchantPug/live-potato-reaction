package net.merchantpug.livepotatoreaction.api;

import net.merchantpug.livepotatoreaction.render.screen.DefaultPotatoReactionScreen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public class LiveReactionScreenManager {
    private static final Map<ResourceLocation, LiveReactionScreen> REGISTRY = new HashMap<>();
    private static final LiveReactionScreen DEFAULT_SCREEN = new DefaultPotatoReactionScreen();
    private static LiveReactionScreen activeScreen;

    public static <T extends LiveReactionScreen> T register(ResourceLocation key, T screen) {
        REGISTRY.put(key, screen);
        return screen;
    }

    public static LiveReactionScreen getOrReplaceActiveScreen(LocalPlayer player) {
        if (activeScreen == null || activeScreen.shouldStop(player)) {
            if (activeScreen != null) {
                activeScreen.stop();
            }
            activeScreen = DEFAULT_SCREEN;
            activeScreen.start();
        }
        for (LiveReactionScreen screen : REGISTRY.values()) {
            if (screen.getPriority() > activeScreen.getPriority() && screen.shouldStart(player)) {
                activeScreen.stop();
                activeScreen = screen;
                activeScreen.start();
            }
        }
        return activeScreen;
    }
}
