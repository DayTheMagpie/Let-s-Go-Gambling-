package net.daythemagpie.letsgogambling.block;

import net.daythemagpie.letsgogambling.LetsGoGambling;
import net.daythemagpie.letsgogambling.block.custom.SlotMachineBlock;
import net.daythemagpie.letsgogambling.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModBlocks {
    DeferredRegister.Blocks BLOCKS=
            DeferredRegister.createBlocks(LetsGoGambling.MOD_ID);



    DeferredBlock<Block> SLOT_MACHINE = registerBlock("slot_machine",
            SlotMachineBlock::new);


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
