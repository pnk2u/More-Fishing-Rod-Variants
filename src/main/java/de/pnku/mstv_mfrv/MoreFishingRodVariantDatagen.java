package de.pnku.mstv_mfrv;

import de.pnku.mstv_mfrv.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;


public class MoreFishingRodVariantDatagen implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();

		//pack.addProvider(MoreFishingRodVariantRecipeGenerator::new);
		//pack.addProvider(MoreFishingRodVariantLangGenerator::new);
	}

}
