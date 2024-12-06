package generations.gg.generations.generationsextra.fabric;

import generations.gg.generations.generationsextra.GenerationsExtra;
import net.fabricmc.api.ModInitializer;

public class GenerationsExtraFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GenerationsExtra.init();
    }
}
