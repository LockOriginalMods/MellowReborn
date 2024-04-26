package com.LockOriginalMods.Mellow.Init;

import com.LockOriginalMods.Mellow.utils.BatteryItem;
import com.LockOriginalMods.Mellow.utils.HammerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);


    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_DUST = ITEMS.register("tin_dust",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALUMINIUM_DUST = ITEMS.register("aluminum_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_DUST = ITEMS.register("amethyst_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_DUST = ITEMS.register("brass_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> COAL_DUST = ITEMS.register("coal_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_DUST = ITEMS.register("copper_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_DUST = ITEMS.register("deepslate_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_DUST = ITEMS.register("gold_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_DUST = ITEMS.register("iron_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> STONE_DUST = ITEMS.register("stone_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> CORN_OIL = ITEMS.register("corn_oil",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ELECTRONIC_CIRCUIT = ITEMS.register("electronic_circuit",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADVANCED_CIRCUIT = ITEMS.register("advanced_circuit",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLAX_FIBER = ITEMS.register("flax_fiber",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> MIXED_METAL_BLEND = ITEMS.register("mixed_metal_blend",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAY_DUST = ITEMS.register("clay_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_GEAR = ITEMS.register("brass_gear",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_GEAR = ITEMS.register("aluminum_gear",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_GEAR = ITEMS.register("copper_gear",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_GEAR = ITEMS.register("gold_gear",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_GEAR = ITEMS.register("iron_gear",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_GEAR = ITEMS.register("tin_gear",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADVANCED_ALLOY = ITEMS.register("advanced_alloy",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_INGOT = ITEMS.register("brass_ingot",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_NUGGET = ITEMS.register("brass_nugget",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALUMINUM_PLATE = ITEMS.register("aluminum_plate",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRASS_PLATE = ITEMS.register("brass_plate",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_PLATE = ITEMS.register("gold_plate",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_PLATE = ITEMS.register("copper_plate",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIN_PLATE = ITEMS.register("tin_plate",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENERGY_CRYSTAL = ITEMS.register("energy_crystal",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> GRAPHENE = ITEMS.register("graphene",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBBER = ITEMS.register("rubber",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILICON = ITEMS.register("silicon",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> FLAX_CROP_SEEDS = ITEMS.register("flax_crop_seeds",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> CUTTER = ITEMS.register("cutter",()->new HammerItem(new Item.Properties().durability(69).setNoRepair()));


    public static final RegistryObject<Item> HAMMER = ITEMS.register("hammer", () -> new HammerItem(new Item.Properties().durability(69).setNoRepair()));
    public static final RegistryObject<Item> MORTAR = ITEMS.register("mortar",()->new HammerItem(new Item.Properties().durability(69).setNoRepair()));
    public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRUSHED_KELP = ITEMS.register("crushed_kelp",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ZINC = ITEMS.register("raw_zinc",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_DUST = ITEMS.register("bronze_dust",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget",()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZINC_DUST = ITEMS.register("zinc_dust",()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> RUBBER_SEEDS = ITEMS.register("rubber_seeds",()->new ItemNameBlockItem(BlockInit.RUBBER_CROP.get(),new Item.Properties()));


    public static final RegistryObject<Item> BATTERY = ITEMS.register("battery",
            () -> new BatteryItem(BatteryItem.Tier.BATTERY_1));


    public static final RegistryObject<Item> RESIN = ITEMS.register("resin", () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        RegistryObject<T> itemRegObj = ITEMS.register(name, item);
        return itemRegObj;
    }

    private static RegistryObject<Item> register(String name, Item.Properties properties) {
        return register(name, () -> new Item(properties));
    }

    private static RegistryObject<Item> register(String name) {
        return register(name, properties());
    }

    private static Item.Properties properties() {
        return new Item.Properties();
    }

    public static RegistryObject<BlockItem> registerBlockItem(String name, RegistryObject<? extends Block> block) {
        return register(name, () -> new BlockItem(block.get(), properties()));
    }
}
