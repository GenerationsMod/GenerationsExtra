package generations.gg.generations.generationsextra;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.extensions.injected.InjectedGameEventExtension;
import dev.architectury.platform.Platform;
import generations.gg.generations.core.generationscore.common.config.ConfigLoader;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.BallLootBlockEntity;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.GenerationsBlockEntities;
import generations.gg.generations.generationsextra.config.Config;
import net.minecraft.server.level.ServerLevel;

public class GenerationsExtra {

    /** The mod id for the Generations-Extra mod. */
    public static final String MOD_ID = "generationsextra";

    /** The config for the Generations-Extra mod. */
    public static Config CONFIG;

    public static void init() {
        ConfigLoader.setConfigDirectory(Platform.getConfigFolder());
//        ConfigLoader.loadConfig(Config.class, "extra", "config"); TODO: Figure out config being derpy...

        InteractionEvent.RIGHT_CLICK_BLOCK.register((player, interactionHand, blockPos, direction) -> {
            if(/*CONFIG.ballLoot.enabled && TODO: Figure out config being derpy...*/player.level() instanceof ServerLevel world) {
                world.getBlockEntity(blockPos, GenerationsBlockEntities.BALL_LOOT.get()).filter(a -> !player.getUUID().equals(a.getOwner())).ifPresent(ballLootBlockEntity -> {
                    if(ballLootBlockEntity.getLootMode() != BallLootBlockEntity.LootMode.ONCE_PER_PLAYER) {
                        ballLootBlockEntity.setLootMode(BallLootBlockEntity.LootMode.ONCE_PER_PLAYER);
                    }
                });
            }

            return EventResult.pass();
        });
    }
}
