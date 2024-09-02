package de.pnku.mstv_mfrv.client.renderer;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;

import static de.pnku.mstv_mfrv.item.MoreFishingRodVariantItems.*;

public class MfrvItemProperties {

    public static void registerFishingRodPredicates() {
        for (Item fishingRodVariant : more_fishing_rods) {
            registerFishingRodPredicate(fishingRodVariant);
        }
    }

    private static void registerFishingRodPredicate(Item fishingRod) {
        ItemProperties.register(fishingRod, new ResourceLocation("cast"),
                (itemStack, clientLevel, livingEntity, seed) -> {
                    if (livingEntity == null) {
                        return 0.0f;
                    }
                    boolean bl = livingEntity.getMainHandItem() == itemStack;
                    boolean bl2 = livingEntity.getOffhandItem() == itemStack;
                    if (livingEntity.getMainHandItem().getItem() instanceof FishingRodItem) {
                        bl2 = false;
                    }
                    return (bl || bl2) && livingEntity instanceof Player && ((Player)livingEntity).fishing != null ? 1.0f : 0.0f;
                });
    }
}
