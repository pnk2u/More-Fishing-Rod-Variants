package de.pnku.mstv_mfrv.datagen;

import de.pnku.mstv_base.item.MoreStickVariantItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import org.apache.commons.text.WordUtils;

import java.util.concurrent.CompletableFuture;
import static de.pnku.mstv_mfrv.item.MoreFishingRodVariantItems.*;

public class MoreFishingRodVariantLangGenerator extends FabricLanguageProvider {
    public MoreFishingRodVariantLangGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        for (Item fishingRodItem : more_fishing_rods) {
            Item stickItem = more_fishing_rod_sticks.get(fishingRodItem);
            String fishingRodName = WordUtils.capitalizeFully(((MoreStickVariantItem) stickItem).mstvWoodType + " Fishing Rod");
            translationBuilder.add(fishingRodItem, fishingRodName);
        }
        for (Item carrotOnAStickItem : more_carrot_on_a_stick_variants) {
            Item stickItem = more_carrot_on_a_stick_sticks.get(carrotOnAStickItem);
            String stickWood = ((MoreStickVariantItem) stickItem).mstvWoodType;
            String article = " a "; if (stickWood.equals("acacia") || stickWood.equals("oak")) {article = " an ";}
            String carrotOnAStickName = WordUtils.capitalizeFully("Carrot On" + article + stickWood + " Stick");
            translationBuilder.add(carrotOnAStickItem, carrotOnAStickName);
        }
        for (Item warpedFungusOnAStickItem : more_warped_fungus_on_a_stick_variants) {
            Item stickItem = more_warped_fungus_on_a_stick_sticks.get(warpedFungusOnAStickItem);
            String stickWood = ((MoreStickVariantItem) stickItem).mstvWoodType;
            String article = " a "; if (stickWood.equals("acacia") || stickWood.equals("oak")) {article = " an ";}
            String warpedFungusOnAStickName = WordUtils.capitalizeFully("Warped Fungus On" + article + stickWood + " Stick");
            translationBuilder.add(warpedFungusOnAStickItem, warpedFungusOnAStickName);
        }
    }
}
