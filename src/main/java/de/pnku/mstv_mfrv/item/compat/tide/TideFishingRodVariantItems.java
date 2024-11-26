package de.pnku.mstv_mfrv.item.compat.tide;

//import com.li64.tide.registries.items.TideFishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static de.pnku.mstv_mfrv.MoreFishingRodVariants.LOGGER;

public class TideFishingRodVariantItems {

    // Tide Compatibility

    public static Item createTideFishingRodItem(String woodType) {
//        Item.Properties tideRodProperties = new Item.Properties().durability(20);
//        if (woodType.matches("crimson|warped")) {
//            tideRodProperties.fireResistant();
//        }
//        LOGGER.info("Variant of Tide Fishing Rod registered."); // DEBUG, to be removed
//        return new TideFishingRodItem(32, tideRodProperties);
        return null;
    }

    public static boolean stackIsTide(ItemStack itemStack) {
//        return itemStack.getItem() instanceof TideFishingRodItem;
        return false;
    }
}
