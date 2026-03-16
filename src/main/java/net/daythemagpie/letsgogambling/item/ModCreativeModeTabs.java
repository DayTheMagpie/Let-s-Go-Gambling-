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

    public static final Supplier<CreativeModeTab> CASINO_MACHINES_TAB = CREATIVE_MODE_TABS.register("casino_machines_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SLOT_MACHINE))
                    .title(Component.translatable("creativetab.casino_machines_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.SLOT_MACHINE);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
