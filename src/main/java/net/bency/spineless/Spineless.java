package net.bency.spineless;

import net.bency.spineless.custom.Stripped_Cactus_Block;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Spineless implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("spineless");
	Random rand = new Random();

	@Override
	public void onInitialize() {
		Stripped_Cactus_Block.initStrippedCactus();
		LOGGER.info("Blocks registered!");
		SpinelessItems.initializeItems();
		LOGGER.info("Items registered!");
		{
			//Fuel Registry
			FuelRegistry.INSTANCE.add(SpinelessItems.CACTUS_SPINE, 100);
		}
		{	//Events
			//Cactus Right-Clicked
			UseBlockCallback.EVENT.register(((player, world, hand, hitResult) -> {
				BlockPos pos = hitResult.getBlockPos();
				if (world.getBlockState(pos).getBlock() == Blocks.CACTUS) {
					if ((player.getStackInHand(hand).getItem() == Items.SHEARS) |
							(player.getStackInHand(hand).getItem() == Items.DIAMOND_AXE) |
							(player.getStackInHand(hand).getItem() == Items.NETHERITE_AXE) |
							(player.getStackInHand(hand).getItem() == Items.IRON_AXE) |
							(player.getStackInHand(hand).getItem() == Items.STONE_AXE) |
							(player.getStackInHand(hand).getItem() == Items.WOODEN_AXE) |
							(player.getStackInHand(hand).getItem() == Items.GOLDEN_AXE)) {
						BlockPos oneAbovePos = pos.up();
						BlockPos twoAbovePos = pos.up(2);
						BlockPos threeAbovePos = pos.up(3);
						BlockPos oneBelowPos = pos.down();
						BlockPos twoBelowPos = pos.down(2);
						BlockPos threeBelowPos = pos.down(3);

						{
							if (world.getBlockState(pos).getBlock() == Blocks.CACTUS) {
								world.setBlockState(pos, Stripped_Cactus_Block.STRIPPED_CACTUS.getDefaultState());
								player.giveItemStack(new ItemStack(SpinelessItems.CACTUS_SPINE, rand.nextInt(4)));
							}
							if (world.getBlockState(oneAbovePos).getBlock() == Blocks.CACTUS) {
								world.setBlockState(oneAbovePos, Stripped_Cactus_Block.STRIPPED_CACTUS.getDefaultState());
								player.giveItemStack(new ItemStack(SpinelessItems.CACTUS_SPINE, rand.nextInt(4)));
							}
							if (world.getBlockState(twoAbovePos).getBlock() == Blocks.CACTUS) {
								world.setBlockState(twoAbovePos, Stripped_Cactus_Block.STRIPPED_CACTUS.getDefaultState());
								player.giveItemStack(new ItemStack(SpinelessItems.CACTUS_SPINE, rand.nextInt(4)));
							}
							if (world.getBlockState(threeAbovePos).getBlock() == Blocks.CACTUS) {
								world.setBlockState(threeAbovePos, Stripped_Cactus_Block.STRIPPED_CACTUS.getDefaultState());
								player.giveItemStack(new ItemStack(SpinelessItems.CACTUS_SPINE, rand.nextInt(4)));
							}
							if (world.getBlockState(oneBelowPos).getBlock() == Blocks.CACTUS) {
								world.setBlockState(oneBelowPos, Stripped_Cactus_Block.STRIPPED_CACTUS.getDefaultState());
								player.giveItemStack(new ItemStack(SpinelessItems.CACTUS_SPINE, rand.nextInt(4)));
							}
							if (world.getBlockState(twoBelowPos).getBlock() == Blocks.CACTUS) {
								world.setBlockState(twoBelowPos, Stripped_Cactus_Block.STRIPPED_CACTUS.getDefaultState());
								player.giveItemStack(new ItemStack(SpinelessItems.CACTUS_SPINE, rand.nextInt(4)));
							}
							if (world.getBlockState(threeBelowPos).getBlock() == Blocks.CACTUS) {
								world.setBlockState(threeBelowPos, Stripped_Cactus_Block.STRIPPED_CACTUS.getDefaultState());
								player.giveItemStack(new ItemStack(SpinelessItems.CACTUS_SPINE, rand.nextInt(4)));
							}
						}
						player.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1, 1);
						return ActionResult.SUCCESS;
					}
				}else {
					return ActionResult.PASS;
				}
                return ActionResult.PASS;
            }));
		}
	}
}