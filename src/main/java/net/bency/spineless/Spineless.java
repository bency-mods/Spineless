package net.bency.spineless;

import net.bency.spineless.custommodels.Stripped_Cactus_Block;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Spineless implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("spineless");

	@Override
	public void onInitialize() {
		Stripped_Cactus_Block.initStrippedCactus();
		LOGGER.info("Blocks registered!");
	}
}