package de.pnku.mstv_mfrv.mixin.entity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static de.pnku.mstv_mfrv.item.MoreFishingRodVariantItems.*;

@Mixin(FishingHook.class)
public class FishingHookMixin {

    @Unique
    FishingHook fishingHook = (FishingHook)(Object)this;


    @Inject(method = "shouldStopFishing", at = @At("HEAD"), cancellable = true)
    private void injectedShouldStopFishing(Player player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack mainHandStack = player.getMainHandItem();
        ItemStack offHandStack = player.getOffhandItem();
        boolean isFishingRodVariant = more_fishing_rods.contains(mainHandStack.getItem()) || more_fishing_rods.contains(offHandStack.getItem());
        if (isFishingRodVariant) {
            if (!player.isRemoved() && player.isAlive() && !(fishingHook.distanceToSqr(player) > 1024.0)) {
                cir.setReturnValue(false);
            } else {
                fishingHook.discard();
                cir.setReturnValue(true);
            }
        }
    }
}
