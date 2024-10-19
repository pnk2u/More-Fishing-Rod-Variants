//package de.pnku.mstv_mfrv.datagen;
//
//import de.pnku.mstv_mfrv.MoreFishingRodVariants;
//import de.pnku.mstv_base.item.MoreStickVariantItem;
//import de.pnku.mstv_mfrv.item.MoreFishingRodVariantItems;
//import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
//import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
//import net.minecraft.core.HolderLookup;
//import net.minecraft.data.recipes.RecipeCategory;
//import net.minecraft.data.recipes.RecipeOutput;
//import net.minecraft.data.recipes.ShapedRecipeBuilder;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.Items;
//
//import java.util.concurrent.CompletableFuture;
//import static de.pnku.mstv_mfrv.item.MoreFishingRodVariantItems.*;
//
//public class MoreFishingRodVariantRecipeGenerator extends FabricRecipeProvider {
//    public MoreFishingRodVariantRecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
//        super(output, registriesFuture);
//    }
//
//    @Override
//    public void buildRecipes(RecipeOutput exporter) {
//        for (Item fishingRodItem : more_fishing_rods) {
//            Item stickItem = more_fishing_rod_sticks.getOrDefault(fishingRodItem, Items.BAMBOO);
//            String stickWood = "bamboo";
//            if (stickItem != Items.BAMBOO) {
//                stickWood = ((MoreStickVariantItem) stickItem).mstvWoodType;
//            }
//            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, fishingRodItem)
//                    .group("fishing_rods")
//                    .unlockedBy("has_stick_and_string", has(stickItem))
//                    .unlockedBy("to_be_combined_post_generation", has(Items.STRING))
//                    .define('/', stickItem)
//                    .define('S', Items.STRING)
//                    .pattern("  /")
//                    .pattern(" /S")
//                    .pattern("/ S")
//                    .save(exporter, MoreFishingRodVariants.asId(stickWood + "_fishing_rod"));
//        }
//        for (Item carrotOnAStickItem : more_carrot_on_a_stick_variants) {
//            Item stickItem = more_carrot_on_a_stick_sticks.getOrDefault(carrotOnAStickItem, Items.BAMBOO);
//            Item fishingRodItem = more_stick_fishing_rods.getOrDefault(stickItem, BAMBOO_FISHING_ROD);
//            String stickWood = "bamboo";
//            if (stickItem != Items.BAMBOO) {
//                stickWood = ((MoreStickVariantItem) stickItem).mstvWoodType;
//            }
//            String article = "_a_"; if (stickWood.equals("acacia")) {article = "_an_";}
//            String carrotOnAStickPath = "carrot_on" + article + stickWood + "_stick";
//            ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, carrotOnAStickItem)
//                    .group("carrot_on_a_stick_variants")
//                    .unlockedBy("has_fishing_rod_and_carrot", has(fishingRodItem))
//                    .unlockedBy("to_be_combined_post_generation", has(Items.CARROT))
//                    .define('F', fishingRodItem)
//                    .define('V', Items.CARROT)
//                    .pattern("F ")
//                    .pattern(" V")
//                    .save(exporter, MoreFishingRodVariants.asId(carrotOnAStickPath));
//        }
//        for (Item warpedFungusOnAStickItem : more_warped_fungus_on_a_stick_variants) {
//            Item stickItem = more_warped_fungus_on_a_stick_sticks.getOrDefault(warpedFungusOnAStickItem, Items.BAMBOO);
//            Item fishingRodItem = more_stick_fishing_rods.getOrDefault(stickItem, BAMBOO_FISHING_ROD);
//            String stickWood = "bamboo";
//            if (stickItem != Items.BAMBOO) {
//                stickWood = ((MoreStickVariantItem) stickItem).mstvWoodType;
//            }
//            String article = "_a_"; if (stickWood.equals("acacia")) {article = "_an_";}
//            String warpedFungusOnAStickPath = "warped_fungus_on" + article + stickWood + "_stick";
//            ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, warpedFungusOnAStickItem)
//                    .group("warped_fungus_on_a_stick_variants")
//                    .unlockedBy("has_fishing_rod_and_warped_fungus", has(fishingRodItem))
//                    .unlockedBy("to_be_combined_post_generation", has(Items.WARPED_FUNGUS))
//                    .define('F', fishingRodItem)
//                    .define('T', Items.WARPED_FUNGUS)
//                    .pattern("F ")
//                    .pattern(" T")
//                    .save(exporter, MoreFishingRodVariants.asId(warpedFungusOnAStickPath));
//        }
//    }
//}
