package net.daythemagpie.letsgogambling.block.custom;

import net.daythemagpie.letsgogambling.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.nikdo53.tinymultiblocklib.blockentities.AbstractMultiBlockEntity;

public class PokerTableBlockEntity extends AbstractMultiBlockEntity {
    public PokerTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POKER_TABLE_BLOCK_ENTITY.get(), pos, state);
    }
}
