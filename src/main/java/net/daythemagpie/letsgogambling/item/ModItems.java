package net.daythemagpie.letsgogambling.item;

import net.daythemagpie.letsgogambling.LetsGoGambling;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(LetsGoGambling.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
