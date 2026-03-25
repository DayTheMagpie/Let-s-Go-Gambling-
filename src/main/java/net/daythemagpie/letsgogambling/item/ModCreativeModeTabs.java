package net.daythemagpie.letsgogambling.item;

import net.daythemagpie.letsgogambling.LetsGoGambling;
import net.daythemagpie.letsgogambling.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LetsGoGambling.MOD_ID);

    public static final Supplier<CreativeModeTab> GAMBLING_TAB = CREATIVE_MODE_TABS.register("letsgogambling_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SLOT_MACHINE))
                    .title(Component.translatable("creativetab.letsgogambling_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //Machines
                        output.accept(ModBlocks.SLOT_MACHINE);
                        output.accept(ModBlocks.POKER_TABLE);
                        output.accept(ModBlocks.ROULETTE_TABLE);

                        //Carpet blocks
                        output.accept(ModBlocks.EXPENSIVE_TWIST_WOOL);
                        output.accept(ModBlocks.EXPENSIVE_STRIPED_WOOL);
                        output.accept(ModBlocks.EXPENSIVE_TILED_WOOL);
                        output.accept(ModBlocks.EXPENSIVE_RETRO_WOOL);

                        //Misc. blocks
                        output.accept(ModBlocks.TICKET_STACK);

                        //Items
                        output.accept(ModItems.PRIZE_TICKET);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
