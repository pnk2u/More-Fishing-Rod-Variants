package de.pnku.mstv_mfrv.mixin.client;

import de.pnku.mstv_mfrv.item.compat.tide.TideFishingRodVariantItems;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.renderer.entity.FishingHookRenderer;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FishingHookRenderer.class)
public class FishingHookRendererMixin {

    @Redirect(method = "getPlayerHandPos", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private boolean redirectedStackIs(ItemStack itemStack, Item originalItem) {
        if (FabricLoader.getInstance().isModLoaded("tide")){
            return TideFishingRodVariantItems.stackIsTide(itemStack);
        }
        return itemStack.getItem() instanceof FishingRodItem;
    }
}
