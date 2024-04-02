package net.merchantpug.livepotatoreaction.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.merchantpug.livepotatoreaction.render.LivePotatoReactionScreens;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.game.ClientboundDamageEventPacket;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public abstract class ClientPacketListenerMixin {

    @Inject(method = "handleDamageEvent", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;handleDamageEvent(Lnet/minecraft/world/damagesource/DamageSource;)V"))
    private void livepotatoreaction$onDamage(ClientboundDamageEventPacket packet, CallbackInfo ci, @Local Entity entity) {
        if (entity instanceof LocalPlayer) {
            LivePotatoReactionScreens.HURT.incrementHurtAmount();
        }
    }
}
