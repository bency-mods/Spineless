package net.bency.spineless;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SpinelessItems {
    public static final Item CACTUS_FLESH = new Item
            ((new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.25f).build())));
    public static final Item CACTUS_SPINE = new Item((new FabricItemSettings()));
    public static final Item COOKED_CACTUS_FLESH = new Item
            ((new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(4f).build())));

    static void initializeItems(){
        Registry.register(Registries.ITEM, new Identifier("spineless", "cactus_flesh"), CACTUS_FLESH);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(Items.DRIED_KELP, CACTUS_FLESH);
        });
        Registry.register(Registries.ITEM, new Identifier("spineless", "cactus_spine"), CACTUS_SPINE);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.BONE, CACTUS_SPINE);
        });
        Registry.register(Registries.ITEM, new Identifier("spineless", "cooked_cactus_flesh"), COOKED_CACTUS_FLESH);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(content -> {
            content.addAfter(CACTUS_FLESH, COOKED_CACTUS_FLESH);
        });
    }
}
