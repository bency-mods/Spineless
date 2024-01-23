package net.bency.spineless.custom;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class Stripped_Cactus_Block extends Block{

    //Shape stuff cos of custom model
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(1, 0, 1, 15, 16, 15);
    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(1, 0, 1, 15, 16, 15);
    }

    public Stripped_Cactus_Block(Settings settings) {
        super(settings);
    }

    //Making it act like a cactus should


    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        if (world.getBlockState(pos.down(1)).isAir()){
            world.breakBlock(pos, true);
        }
        return state;
    }

    //Adding the block and its block item
    public static final Stripped_Cactus_Block STRIPPED_CACTUS = new Stripped_Cactus_Block((FabricBlockSettings.copyOf(Blocks.CACTUS)));
    //The Initialization method
    public static void initStrippedCactus(){
        Registry.register(Registries.BLOCK, new Identifier("spineless", "stripped_cactus"), STRIPPED_CACTUS);
        Registry.register(Registries.ITEM, new Identifier("spineless", "stripped_cactus"), new BlockItem(STRIPPED_CACTUS, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
            content.addAfter(Items.CACTUS, STRIPPED_CACTUS);
        });
    }

}
