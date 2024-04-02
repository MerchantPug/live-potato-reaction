package net.merchantpug.livepotatoreaction.render;

import net.merchantpug.livepotatoreaction.LivePotatoReaction;
import net.merchantpug.livepotatoreaction.api.LiveReactionScreenManager;
import net.merchantpug.livepotatoreaction.render.screen.HorsePotatoReactionScreen;
import net.merchantpug.livepotatoreaction.render.screen.HurtPotatoReactionScreen;

public class LivePotatoReactionScreens {

    public static final HorsePotatoReactionScreen HORSE = LiveReactionScreenManager.register(LivePotatoReaction.asResource("horse"), new HorsePotatoReactionScreen());
    public static final HurtPotatoReactionScreen HURT = LiveReactionScreenManager.register(LivePotatoReaction.asResource("hurt"), new HurtPotatoReactionScreen());

    public static void registerAll() {

    }
}
