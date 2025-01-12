package de.pnku.mstv_mfrv;

import de.pnku.mstv_mfrv.item.MoreFishingRodVariantItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MoreFishingRodVariants implements ModInitializer {

	public static final String MOD_ID = "mstv-mfrv";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		MoreFishingRodVariantItems.registerRodItems();
	}

	public static ResourceLocation asId(String path) {
		return new ResourceLocation(MOD_ID, path);
	}

}