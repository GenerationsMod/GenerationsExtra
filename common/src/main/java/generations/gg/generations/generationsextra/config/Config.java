package generations.gg.generations.generationsextra.config;

import generations.gg.generations.core.generationscore.common.world.level.block.entities.BallLootBlockEntity;

public class Config {
    public BallLoot ballLoot = new BallLoot();


    public Config() {}

    public static class BallLoot {
        public boolean enabled = true;
        public BallLootBlockEntity.LootMode lootMode = BallLootBlockEntity.LootMode.UNLIMITED;
    }
}
