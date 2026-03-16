package net.daythemagpie.letsgogambling;

import com.mojang.logging.LogUtils;
import net.daythemagpie.letsgogambling.block.ModBlockEntities;
import net.daythemagpie.letsgogambling.block.ModBlocks;
import net.daythemagpie.letsgogambling.item.ModCreativeModeTabs;
import net.daythemagpie.letsgogambling.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LetsGoGambling.MOD_ID)
public class LetsGoGambling
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "letsgogambling";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public LetsGoGambling(IEventBus modEventBus)
    {
        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
    }

}
