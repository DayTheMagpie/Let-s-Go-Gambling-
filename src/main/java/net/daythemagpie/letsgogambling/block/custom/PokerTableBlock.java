package net.daythemagpie.letsgogambling.block.custom;

import net.daythemagpie.letsgogambling.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.nikdo53.tinymultiblocklib.block.AbstractMultiBlock;
import net.nikdo53.tinymultiblocklib.block.IPreviewableMultiblock;
import net.nikdo53.tinymultiblocklib.components.IBlockPosOffsetEnum;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Function;

public class PokerTableBlock extends AbstractMultiBlock implements IPreviewableMultiblock {
    public PokerTableBlock() {
        super(Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion());
        registerDefaultState(defaultBlockState().setValue(PART, TablePart.BACK));
    }

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<PokerTableBlock.TablePart> PART = EnumProperty.create("part", PokerTableBlock.TablePart.class);
    public enum TablePart implements StringRepresentable, IBlockPosOffsetEnum {
        BACK("back", pos -> pos),
        FRONT("front", BlockPos::north),
        BACK_LEFT("back_left", BlockPos::east),
        BACK_RIGHT("back_right", BlockPos::west),
        FRONT_LEFT("front_left", pos -> pos.north().east()),
        FRONT_RIGHT("front_right", pos -> pos.north().west());

        TablePart(String name, Function<BlockPos,BlockPos> offset){
            this.name = name;
            this.offset = offset;
    }

        private final String name;
        private final Function<BlockPos,BlockPos> offset;

        @Override
        public String getSerializedName() {return name;}

        @Override
        public Function<BlockPos, BlockPos> getOffsetFunction() {return offset;}

        @Override
        public String toString() {return name;}
    }

    @Override
    public List<BlockPos> makeFullBlockShape(Level level, BlockPos center, BlockState blockState, @Nullable BlockEntity blockEntity, @Nullable Direction direction) {
        assert direction !=null;
        return List.of(
                center,
                center.relative(direction),
                center.relative(direction.getClockWise()),
                center.relative(direction.getCounterClockWise()),
                center.relative(direction).relative(direction.getClockWise()),
                center.relative(direction).relative(direction.getCounterClockWise())
        );
    }

    //Make Hitbox
    private static final VoxelShape SHAPE_NORTH = makeShapeNorth();
    private static final VoxelShape SHAPE_EAST = makeShapeEast();
    private static final VoxelShape SHAPE_SOUTH = makeShapeSouth();
    private static final VoxelShape SHAPE_WEST = makeShapeWest();

    public static VoxelShape makeShapeNorth()
    {
        VoxelShape shape = Shapes.empty();
        //base
        shape = Shapes.join(shape, Shapes.box(-.5625, .125, .1875, 1.5625, .25, 1.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-.25, 0, .5, 1.25, .875, 1.5), BooleanOp.OR);
        //top
        shape = Shapes.join(shape, Shapes.box(-1, .875, 0, 2, 1, 2), BooleanOp.OR);
        //edges
        shape = Shapes.join(shape,Shapes.box(0, 1, 0, 1, 1.0625, .625), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(-1, 1, 0, 2, 1.0625, .125), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(-1, 1, 0, -.875, 1.0625, 2), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(1.875, 1, 0, 2, 1.0625, 2), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(-1, 1, 1.875, 2, 1.0625, 2), BooleanOp.OR);

        return shape;
    }









    public static VoxelShape makeShapeEast()
    {
        VoxelShape shape = Shapes.empty();
        //base
        shape = Shapes.join(shape, Shapes.box(-.8125, .125, -.5625, .8125, .25, 1.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-.5, 0, -.25, .5, .875, 1.25), BooleanOp.OR);
        //top
        shape = Shapes.join(shape, Shapes.box(-1, .875, -1, 1, 1, 2), BooleanOp.OR);
        //edges
        shape = Shapes.join(shape,Shapes.box(.375, 1, 0, 1, 1.0625, 1), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(.875, 1, -1, 1, 1.0625, 2), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(-1, 1, 1.875, 1, 1.0625, 2), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(-1, 1, -1, 1, 1.0625, -.875), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(-1, 1, -1, -.875, 1.0625, 2), BooleanOp.OR);

        return shape;
    }








    public static VoxelShape makeShapeSouth()
    {
        VoxelShape shape = Shapes.empty();
        //base
        shape = Shapes.join(shape, Shapes.box(-.5625, .125, -.8125, 1.5625, .25, .8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-.25, 0, -.5, 1.25, .875, .5), BooleanOp.OR);
        //top
        shape = Shapes.join(shape, Shapes.box(-1, .875, -1, 2, 1, 1), BooleanOp.OR);
        //edges
        shape = Shapes.join(shape,Shapes.box(0, 1, .375, 1, 1.0625,1), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(-1, 1, -1, 2, 1.0625, -.875), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(-1, 1, -1, -.875, 1.0625, 1), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(1.875, 1, -1, 2, 1.0625, 1), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(-1, 1, .875, 2, 1.0625, 1), BooleanOp.OR);

        return shape;
    }

    public static VoxelShape makeShapeWest()
    {
        VoxelShape shape = Shapes.empty();
        //base
        shape = Shapes.join(shape, Shapes.box(.1875, .125, -.5625, 1.8125, .25, 1.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(.5, 0, -.25, 1.5, .875, 1.25), BooleanOp.OR);
        //top
        shape = Shapes.join(shape, Shapes.box(0, .875, -1, 2, 1, 2), BooleanOp.OR);
        //edges
        shape = Shapes.join(shape,Shapes.box(0, 1, 0, .625, 1.0625, 1), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(1.875, 1, -1, 2, 1.0625, 2), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(0, 1, 1.875, 2, 1.0625, 2), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(0, 1, -1, 2, 1.0625, -.875), BooleanOp.OR);
        shape = Shapes.join(shape,Shapes.box(0, 1, -1, .125, 1.0625, 2), BooleanOp.OR);

        return shape;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        VoxelShape shape = switch (getDirection(state).getOpposite())
        {
            case NORTH -> SHAPE_NORTH;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            case EAST -> SHAPE_EAST;
            default -> null;
        };

        return voxelShapeHelper(state, level, pos, shape);
    }

    @Override
    public @Nullable DirectionProperty getDirectionProperty() {return FACING;}

    @Override
    public RenderShape getMultiblockRenderShape(BlockState blockState, boolean b) {return RenderShape.MODEL;}

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {return ModBlockEntities.POKER_TABLE_BLOCK_ENTITY.get().create(pPos,pState);}

    @Override
    public BlockState getStateForEachBlock(BlockState state, BlockPos pos, BlockPos centerOffset, Level level, @Nullable Direction direction) {
        state = state.setValue(PokerTableBlock.PART, IBlockPosOffsetEnum.fromOffset(PokerTableBlock.TablePart.class, centerOffset, direction, TablePart.BACK));
        return state;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(PART);
    }

    @Override
    public boolean hasCustomBE() {return true;}
}
