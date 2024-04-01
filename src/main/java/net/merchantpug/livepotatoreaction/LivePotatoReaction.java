package net.merchantpug.livepotatoreaction;

import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.merchantpug.livepotatoreaction.render.LivePotatoReactionRenderer;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LivePotatoReaction implements ClientModInitializer {
	public static final String MODID = "livepotatoreaction";
    public static final Logger LOGGER = LoggerFactory.getLogger("Live Potato Reaction");
	@Override
	public void onInitializeClient() {
		HudRenderCallback.EVENT.register(LivePotatoReactionRenderer::render);
	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(MODID, path);
	}
}