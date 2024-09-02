package de.pnku.mstv_mfrv.item;

import de.pnku.mstv_base.item.MoreStickVariantItem;
import de.pnku.mstv_mfrv.MoreFishingRodVariants;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.core.Registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static de.pnku.mstv_base.item.MoreStickVariantItems.*;


public class MoreFishingRodVariantItems {

    // Fishing Rods
    public static final Item ACACIA_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(64));
    public static final Item BAMBOO_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(64));
    public static final Item BIRCH_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(64));
    public static final Item CHERRY_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(64));
    public static final Item CRIMSON_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(65).fireResistant());
    public static final Item DARK_OAK_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(64));
    public static final Item JUNGLE_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(64));
    public static final Item MANGROVE_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(64));
    public static final Item SPRUCE_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(64));
    public static final Item WARPED_FISHING_ROD = new FishingRodItem(new Item.Properties().durability(65).fireResistant());

    public static final Item CARROT_ON_AN_ACACIA_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(25), EntityType.PIG, 7);
    public static final Item CARROT_ON_A_BAMBOO_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(25), EntityType.PIG, 7);
    public static final Item CARROT_ON_A_BIRCH_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(25), EntityType.PIG, 7);
    public static final Item CARROT_ON_A_CHERRY_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(25), EntityType.PIG, 7);
    public static final Item CARROT_ON_A_CRIMSON_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(26).fireResistant(), EntityType.PIG, 7);
    public static final Item CARROT_ON_A_DARK_OAK_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(25), EntityType.PIG, 7);
    public static final Item CARROT_ON_A_JUNGLE_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(25), EntityType.PIG, 7);
    public static final Item CARROT_ON_A_MANGROVE_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(25), EntityType.PIG, 7);
    public static final Item CARROT_ON_A_SPRUCE_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(25), EntityType.PIG, 7);
    public static final Item CARROT_ON_A_WARPED_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(26).fireResistant(), EntityType.PIG, 7);

    public static final Item WARPED_FUNGUS_ON_AN_ACACIA_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(100), EntityType.STRIDER, 1);
    public static final Item WARPED_FUNGUS_ON_A_BAMBOO_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(100), EntityType.STRIDER, 1);
    public static final Item WARPED_FUNGUS_ON_A_BIRCH_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(100), EntityType.STRIDER, 1);
    public static final Item WARPED_FUNGUS_ON_A_CHERRY_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(100), EntityType.STRIDER, 1);
    public static final Item WARPED_FUNGUS_ON_A_CRIMSON_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(101).fireResistant(), EntityType.STRIDER, 1);
    public static final Item WARPED_FUNGUS_ON_A_DARK_OAK_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(100), EntityType.STRIDER, 1);
    public static final Item WARPED_FUNGUS_ON_A_JUNGLE_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(100), EntityType.STRIDER, 1);
    public static final Item WARPED_FUNGUS_ON_A_MANGROVE_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(100), EntityType.STRIDER, 1);
    public static final Item WARPED_FUNGUS_ON_A_SPRUCE_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(100), EntityType.STRIDER, 1);
    public static final Item WARPED_FUNGUS_ON_A_WARPED_STICK = new FoodOnAStickItem<>(new Item.Properties().durability(101).fireResistant(), EntityType.STRIDER, 1);

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
