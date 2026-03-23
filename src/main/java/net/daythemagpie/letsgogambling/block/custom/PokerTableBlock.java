package net.daythemagpie.letsgogambling.block.custom;

import net.daythemagpie.letsgogambling.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.nikdo53.tinymultiblocklib.block.AbstractMultiBlock;
import net.nikdo53.tinymultiblocklib.block.IPreviewableMultiblock;
import net.nikdo53.tinymultiblocklib.components.IBlockPosOffsetEnum;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class PokerTableBlock extends AbstractMultiBlock implements IPreviewableMultiblock {
    public PokerTableBlock(Properties properties) {
        super(Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
        registerDefaultState(defaultBlockState().setValue(PART, TablePart.BACK));
    }

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<PokerTableBlock.TablePart> PART = EnumProperty.create("part", PokerTableBlock.TablePart.class);
    ;public enum TablePart implements StringRepresentable, IBlockPosOffsetEnum {
        BACK("back", pos -> pos),
        FRONT("front", pos -> pos.north());

        TablePart(String name, Function<BlockPos,BlockPos> offset){
            this.name = name;
            this.offset = offset;
    }

        private final String name;
        private final Function<BlockPos,BlockPos> offset;

        @Override
        public String getSerializedName() {
            return name;
        }

        @Override
        public Function<BlockPos, BlockPos> getOffsetFunction() {
            return offset;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    @Override
    public @Nullable DirectionProperty getDirectionProperty() {
        return FACING;
    }

    @Override
    public RenderShape getMultiblockRenderShape(BlockState blockState, boolean b) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return ModBlockEntities.POKER_TABLE_BLOCK_ENTITY.get().create(pPos,pState);
    }

    @Override
    public List<BlockPos> makeFullBlockShape(Level level, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity, @Nullable Direction direction) {
        return List.of(blockPos, blockPos.north());
    }

    @Override
    public BlockState getStateForEachBlock(BlockState state, BlockPos pos, BlockPos centerOffset, Level level, @Nullable Direction direction) {
        state = state.setValue(PokerTableBlock.PART, IBlockPosOffsetEnum.fromOffset(PokerTableBlock.TablePart.class, centerOffset, direction, PokerTableBlock.TablePart.FRONT));

        return state;
    }





    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return getStateForPlacementHelper(context, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState getDefaultStateForPreviews(Direction direction) {
        return IPreviewableMultiblock.super.getDefaultStateForPreviews(direction.getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(PART);
    }

    @Override
    public boolean hasCustomBE() {
        return true;
    }
}
