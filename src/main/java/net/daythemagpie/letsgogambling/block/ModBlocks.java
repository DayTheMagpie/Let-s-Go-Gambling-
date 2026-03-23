package net.daythemagpie.letsgogambling.block;

import net.daythemagpie.letsgogambling.LetsGoGambling;
import net.daythemagpie.letsgogambling.block.custom.PokerTableBlock;
import net.daythemagpie.letsgogambling.block.custom.SlotMachineBlock;
import net.daythemagpie.letsgogambling.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModBlocks {
    DeferredRegister.Blocks BLOCKS=
            DeferredRegister.createBlocks(LetsGoGambling.MOD_ID);


    //Game Blocks
    DeferredBlock<Block> SLOT_MACHINE = registerBlock("slot_machine", SlotMachineBlock::new);
    DeferredBlock<Block> POKER_TABLE = registerBlock("poker_table", PokerTableBlock::new);

    //Expensive Wool Blocks
    DeferredBlock<Block> EXPENSIVE_TWIST_WOOL = registerBlock("expensive_twist_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    DeferredBlock<Block> EXPENSIVE_STRIPED_WOOL = registerBlock("expensive_striped_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    DeferredBlock<Block> EXPENSIVE_TILED_WOOL = registerBlock("expensive_tiled_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    DeferredBlock<Block> EXPENSIVE_RETRO_WOOL = registerBlock("expensive_retro_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));

    DeferredBlock<RotatedPillarBlock> TICKET_STACK = registerBlock("ticket_stack", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_ROOTS).sound(SoundType.SPONGE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
