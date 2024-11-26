package de.pnku.mstv_mfrv.item;

import de.pnku.mstv_base.item.MoreStickVariantItem;
import de.pnku.mstv_mfrv.MoreFishingRodVariants;
import de.pnku.mstv_mfrv.item.compat.tide.TideFishingRodVariantItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.core.Registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.pnku.mstv_base.item.MoreStickVariantItems.*;
import static de.pnku.mstv_mfrv.MoreFishingRodVariants.*;


public class MoreFishingRodVariantItems {

    public static Item createRodItem(String rodType, String woodType) {
      // Tide Compatibility
            if (rodType.equals("fish") && FabricLoader.getInstance().isModLoaded("tide")){
                return TideFishingRodVariantItems.createTideFishingRodItem(woodType);
            }

        Item.Properties rodProperties;
        String article = woodType.equals("acacia") ? "an_" : "a_";
        switch (rodType) {
            case "fish" -> rodProperties = new Item.Properties().durability(64).setId(ResourceKey.create(Registries.ITEM, MoreFishingRodVariants.asId(woodType + "_fishing_rod")));
            case "pig" -> rodProperties = new Item.Properties().durability(25).setId(ResourceKey.create(Registries.ITEM, MoreFishingRodVariants.asId("carrot_on_" + article + woodType + "_stick")));
            case "strider" -> rodProperties = new Item.Properties().durability(100).setId(ResourceKey.create(Registries.ITEM, MoreFishingRodVariants.asId("warped_fungus_on_" + article + woodType + "_stick")));
            case null, default -> {
                rodProperties = new Item.Properties();
                LOGGER.info("Error: Rod with wrong or missing entity type");
            }
        }
        if (woodType.matches("crimson|warped")) {
            rodProperties.fireResistant();
        }
        switch (rodType) {
            case "fish" -> {return new FishingRodItem(rodProperties);}
            case "pig" -> {return new FoodOnAStickItem<>(EntityType.PIG,7,rodProperties);}
            case "strider" -> {return new FoodOnAStickItem<>(EntityType.STRIDER,1,rodProperties);}
            case null, default -> {return new Item(rodProperties);}
        }
    }


    // Fishing Rods
    public static final Item ACACIA_FISHING_ROD = createRodItem("fish", "acacia");
    public static final Item BAMBOO_FISHING_ROD = createRodItem("fish", "bamboo");
    public static final Item BIRCH_FISHING_ROD = createRodItem("fish", "birch");
    public static final Item CHERRY_FISHING_ROD = createRodItem("fish", "cherry");
    public static final Item CRIMSON_FISHING_ROD = createRodItem("fish", "crimson");
    public static final Item DARK_OAK_FISHING_ROD = createRodItem("fish", "dark_oak");
    public static final Item JUNGLE_FISHING_ROD = createRodItem("fish", "jungle");
    public static final Item MANGROVE_FISHING_ROD = createRodItem("fish", "mangrove");
    public static final Item SPRUCE_FISHING_ROD = createRodItem("fish", "spruce");
    public static final Item WARPED_FISHING_ROD = createRodItem("fish", "warped");

    public static final Item CARROT_ON_AN_ACACIA_STICK = createRodItem("pig", "acacia");
    public static final Item CARROT_ON_A_BAMBOO_STICK = createRodItem("pig", "bamboo");
    public static final Item CARROT_ON_A_BIRCH_STICK = createRodItem("pig", "birch");
    public static final Item CARROT_ON_A_CHERRY_STICK = createRodItem("pig", "cherry");
    public static final Item CARROT_ON_A_CRIMSON_STICK = createRodItem("pig", "crimson");
    public static final Item CARROT_ON_A_DARK_OAK_STICK = createRodItem("pig", "dark_oak");
    public static final Item CARROT_ON_A_JUNGLE_STICK = createRodItem("pig", "jungle");
    public static final Item CARROT_ON_A_MANGROVE_STICK = createRodItem("pig", "mangrove");
    public static final Item CARROT_ON_A_SPRUCE_STICK = createRodItem("pig", "spruce");
    public static final Item CARROT_ON_A_WARPED_STICK = createRodItem("pig", "warped");

    public static final Item WARPED_FUNGUS_ON_AN_ACACIA_STICK = createRodItem("strider", "acacia");
    public static final Item WARPED_FUNGUS_ON_A_BAMBOO_STICK = createRodItem("strider", "bamboo");
    public static final Item WARPED_FUNGUS_ON_A_BIRCH_STICK = createRodItem("strider", "birch");
    public static final Item WARPED_FUNGUS_ON_A_CHERRY_STICK = createRodItem("strider", "cherry");
    public static final Item WARPED_FUNGUS_ON_A_CRIMSON_STICK = createRodItem("strider", "crimson");
    public static final Item WARPED_FUNGUS_ON_A_DARK_OAK_STICK = createRodItem("strider", "dark_oak");
    public static final Item WARPED_FUNGUS_ON_A_JUNGLE_STICK = createRodItem("strider", "jungle");
    public static final Item WARPED_FUNGUS_ON_A_MANGROVE_STICK = createRodItem("strider", "mangrove");
    public static final Item WARPED_FUNGUS_ON_A_SPRUCE_STICK = createRodItem("strider", "spruce");
    public static final Item WARPED_FUNGUS_ON_A_WARPED_STICK = createRodItem("strider", "warped");

    public static final List<Item> more_fishing_rods = new ArrayList<>();
    public static final Map<Item, Item> more_fishing_rod_sticks = new HashMap<>();
    public static final Map<Item, Item> more_stick_fishing_rods = new HashMap<>();
    public static final List<Item> more_carrot_on_a_stick_variants = new ArrayList<>();
    public static final Map<Item, Item> more_carrot_on_a_stick_sticks = new HashMap<>();
    public static final List<Item> more_warped_fungus_on_a_stick_variants = new ArrayList<>();
    public static final Map<Item, Item> more_warped_fungus_on_a_stick_sticks = new HashMap<>();

    public static void registerRodItems() {
        // Fishing Rods
        registerFishingRodItem(ACACIA_FISHING_ROD, Items.FISHING_ROD, ACACIA_STICK);
        registerBambooFishingRodItem(BAMBOO_FISHING_ROD, ACACIA_FISHING_ROD);
        registerFishingRodItem(BIRCH_FISHING_ROD, BAMBOO_FISHING_ROD, BIRCH_STICK);
        registerFishingRodItem(CHERRY_FISHING_ROD, BIRCH_FISHING_ROD, CHERRY_STICK);
        registerFishingRodItem(CRIMSON_FISHING_ROD, CHERRY_FISHING_ROD, CRIMSON_STICK);
        registerFishingRodItem(DARK_OAK_FISHING_ROD, CRIMSON_FISHING_ROD, DARK_OAK_STICK);
        registerFishingRodItem(JUNGLE_FISHING_ROD, DARK_OAK_FISHING_ROD, JUNGLE_STICK);
        registerFishingRodItem(MANGROVE_FISHING_ROD, JUNGLE_FISHING_ROD, MANGROVE_STICK);
        registerFishingRodItem(SPRUCE_FISHING_ROD, MANGROVE_FISHING_ROD, SPRUCE_STICK);
        registerFishingRodItem(WARPED_FISHING_ROD, SPRUCE_FISHING_ROD, WARPED_STICK);

        // Carrot On A Stick Variants
        registerCarrotOnAStickItem(CARROT_ON_AN_ACACIA_STICK, Items.CARROT_ON_A_STICK, ACACIA_STICK);
        registerCarrotOnABambooItem(CARROT_ON_A_BAMBOO_STICK, CARROT_ON_AN_ACACIA_STICK);
        registerCarrotOnAStickItem(CARROT_ON_A_BIRCH_STICK, CARROT_ON_A_BAMBOO_STICK, BIRCH_STICK);
        registerCarrotOnAStickItem(CARROT_ON_A_CHERRY_STICK, CARROT_ON_A_BIRCH_STICK, CHERRY_STICK);
        registerCarrotOnAStickItem(CARROT_ON_A_CRIMSON_STICK, CARROT_ON_A_CHERRY_STICK, CRIMSON_STICK);
        registerCarrotOnAStickItem(CARROT_ON_A_DARK_OAK_STICK, CARROT_ON_A_CRIMSON_STICK, DARK_OAK_STICK);
        registerCarrotOnAStickItem(CARROT_ON_A_JUNGLE_STICK, CARROT_ON_A_DARK_OAK_STICK, JUNGLE_STICK);
        registerCarrotOnAStickItem(CARROT_ON_A_MANGROVE_STICK, CARROT_ON_A_JUNGLE_STICK, MANGROVE_STICK);
        registerCarrotOnAStickItem(CARROT_ON_A_SPRUCE_STICK, CARROT_ON_A_MANGROVE_STICK, SPRUCE_STICK);
        registerCarrotOnAStickItem(CARROT_ON_A_WARPED_STICK, CARROT_ON_A_SPRUCE_STICK, WARPED_STICK);

        // Warped Fungus On A Stick Variants
        registerWarpedFungusOnAStickItem(WARPED_FUNGUS_ON_AN_ACACIA_STICK, Items.WARPED_FUNGUS_ON_A_STICK, ACACIA_STICK);
        registerWarpedFungusOnABambooItem(WARPED_FUNGUS_ON_A_BAMBOO_STICK, WARPED_FUNGUS_ON_AN_ACACIA_STICK);
        registerWarpedFungusOnAStickItem(WARPED_FUNGUS_ON_A_BIRCH_STICK, WARPED_FUNGUS_ON_A_BAMBOO_STICK, BIRCH_STICK);
        registerWarpedFungusOnAStickItem(WARPED_FUNGUS_ON_A_CHERRY_STICK, WARPED_FUNGUS_ON_A_BIRCH_STICK, CHERRY_STICK);
        registerWarpedFungusOnAStickItem(WARPED_FUNGUS_ON_A_CRIMSON_STICK, WARPED_FUNGUS_ON_A_CHERRY_STICK, CRIMSON_STICK);
        registerWarpedFungusOnAStickItem(WARPED_FUNGUS_ON_A_DARK_OAK_STICK, WARPED_FUNGUS_ON_A_CRIMSON_STICK, DARK_OAK_STICK);
        registerWarpedFungusOnAStickItem(WARPED_FUNGUS_ON_A_JUNGLE_STICK, WARPED_FUNGUS_ON_A_DARK_OAK_STICK, JUNGLE_STICK);
        registerWarpedFungusOnAStickItem(WARPED_FUNGUS_ON_A_MANGROVE_STICK, WARPED_FUNGUS_ON_A_JUNGLE_STICK, MANGROVE_STICK);
        registerWarpedFungusOnAStickItem(WARPED_FUNGUS_ON_A_SPRUCE_STICK, WARPED_FUNGUS_ON_A_MANGROVE_STICK, SPRUCE_STICK);
        registerWarpedFungusOnAStickItem(WARPED_FUNGUS_ON_A_WARPED_STICK, WARPED_FUNGUS_ON_A_SPRUCE_STICK, WARPED_STICK);
    }

    private static void registerFishingRodItem(Item fishingRodItem, Item fishingRodAfter, Item stickItem) {
        String fishingRodPath = ((MoreStickVariantItem) stickItem).mstvWoodType + "_fishing_rod";
        Registry.register(BuiltInRegistries.ITEM, MoreFishingRodVariants.asId(fishingRodPath), fishingRodItem);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.addAfter(fishingRodAfter, fishingRodItem));
        more_fishing_rods.add(fishingRodItem);
        more_fishing_rod_sticks.put(fishingRodItem, stickItem);
        more_stick_fishing_rods.put(stickItem, fishingRodItem);
    }
    private static void registerBambooFishingRodItem(Item fishingRodItem, Item fishingRodAfter) {
        String fishingRodPath = "bamboo_fishing_rod";
        Registry.register(BuiltInRegistries.ITEM, MoreFishingRodVariants.asId(fishingRodPath), fishingRodItem);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.addAfter(fishingRodAfter, fishingRodItem));
        more_fishing_rods.add(fishingRodItem);
    }
    private static void registerCarrotOnAStickItem(Item carrotOnAStickItem, Item carrotOnAStickAfter, Item stickItem) {
        String stickWood = ((MoreStickVariantItem) stickItem).mstvWoodType;
        String article = "_a_"; if (stickWood.equals("acacia")) {article = "_an_";}
        String carrotOnAStickPath = "carrot_on" + article + stickWood + "_stick";
        Registry.register(BuiltInRegistries.ITEM, MoreFishingRodVariants.asId(carrotOnAStickPath), carrotOnAStickItem);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.addAfter(carrotOnAStickAfter, carrotOnAStickItem));
        more_carrot_on_a_stick_variants.add(carrotOnAStickItem);
        more_carrot_on_a_stick_sticks.put(carrotOnAStickItem, stickItem);
    }
    private static void registerCarrotOnABambooItem(Item carrotOnAStickItem, Item carrotOnAStickAfter) {
        String carrotOnAStickPath = "carrot_on_a_bamboo_stick";
        Registry.register(BuiltInRegistries.ITEM, MoreFishingRodVariants.asId(carrotOnAStickPath), carrotOnAStickItem);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.addAfter(carrotOnAStickAfter, carrotOnAStickItem));
        more_carrot_on_a_stick_variants.add(carrotOnAStickItem);
    }
    private static void registerWarpedFungusOnAStickItem(Item warpedFungusOnAStickItem, Item warpedFungusOnAStickAfter, Item stickItem) {
        String stickWood = ((MoreStickVariantItem) stickItem).mstvWoodType;
        String article = "_a_"; if (stickWood.equals("acacia")) {article = "_an_";}
        String warpedFungusOnAStickPath = "warped_fungus_on" + article + stickWood + "_stick";
        Registry.register(BuiltInRegistries.ITEM, MoreFishingRodVariants.asId(warpedFungusOnAStickPath), warpedFungusOnAStickItem);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.addAfter(warpedFungusOnAStickAfter, warpedFungusOnAStickItem));
        more_warped_fungus_on_a_stick_variants.add(warpedFungusOnAStickItem);
        more_warped_fungus_on_a_stick_sticks.put(warpedFungusOnAStickItem, stickItem);
    }
    private static void registerWarpedFungusOnABambooItem(Item warpedFungusOnAStickItem, Item warpedFungusOnAStickAfter) {
        String warpedFungusOnAStickPath = "warped_fungus_on_a_bamboo_stick";
        Registry.register(BuiltInRegistries.ITEM, MoreFishingRodVariants.asId(warpedFungusOnAStickPath), warpedFungusOnAStickItem);
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> entries.addAfter(warpedFungusOnAStickAfter, warpedFungusOnAStickItem));
        more_warped_fungus_on_a_stick_variants.add(warpedFungusOnAStickItem);
    }

}
