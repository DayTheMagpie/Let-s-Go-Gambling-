package net.daythemagpie.letsgogambling.block;

import net.daythemagpie.letsgogambling.LetsGoGambling;
import net.daythemagpie.letsgogambling.block.custom.PokerTableBlockEntity;
import net.daythemagpie.letsgogambling.block.custom.RouletteTableBlockEntity;
import net.daythemagpie.letsgogambling.block.custom.SlotMachineBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public interface ModBlockEntities {
    DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES=DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, LetsGoGambling.MOD_ID);





    Supplier<BlockEntityType<SlotMachineBlockEntity>> SLOT_MACHINE_BLOCK_ENTITY=
            BLOCK_ENTITIES.register("slot_machine",() -> BlockEntityType.Builder.of(SlotMachineBlockEntity::new,ModBlocks.SLOT_MACHINE.get())
                    .build(null));

    Supplier<BlockEntityType<PokerTableBlockEntity>> POKER_TABLE_BLOCK_ENTITY=
            BLOCK_ENTITIES.register("poker_table", () -> BlockEntityType.Builder.of(PokerTableBlockEntity::new,ModBlocks.POKER_TABLE.get())
                    .build(null));
    Supplier<BlockEntityType<RouletteTableBlockEntity>> ROULETTE_TABLE_BLOCK_ENTITY=
            BLOCK_ENTITIES.register("roulette_table", () -> BlockEntityType.Builder.of(RouletteTableBlockEntity::new,ModBlocks.ROULETTE_TABLE.get())
                    .build(null));

    static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
