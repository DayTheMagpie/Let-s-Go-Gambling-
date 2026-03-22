package net.daythemagpie.letsgogambling.item;

import net.daythemagpie.letsgogambling.LetsGoGambling;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public interface ModItems {
    DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(LetsGoGambling.MOD_ID);

    DeferredItem<Item> PRIZE_TICKET = ITEMS.register("prize_ticket", () -> new Item(new Item.Properties()));

    static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
