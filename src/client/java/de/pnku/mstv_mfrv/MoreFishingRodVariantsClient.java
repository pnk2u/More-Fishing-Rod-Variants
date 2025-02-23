package de.pnku.mstv_mfrv;

import de.pnku.mstv_mfrv.client.renderer.MfrvItemProperties;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(value = EnvType.CLIENT)
public class MoreFishingRodVariantsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		MfrvItemProperties.registerFishingRodPredicates();
	}
}
