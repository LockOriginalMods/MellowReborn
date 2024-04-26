package com.LockOriginalMods.Mellow;

import com.LockOriginalMods.Mellow.Init.BlockInit;
import com.LockOriginalMods.Mellow.Init.ItemInit;

import com.LockOriginalMods.Mellow.Init.TagInit;
import com.LockOriginalMods.Mellow.block.charger_station.ChargingStationScreen;
import com.LockOriginalMods.Mellow.block.compat.TopCompatibility;
import com.LockOriginalMods.Mellow.block.crusher.CrusherMenu;
import com.LockOriginalMods.Mellow.block.crusher.CrusherScreen;
import com.LockOriginalMods.Mellow.block.furnace.ElectricFurnaceScreen;
import com.LockOriginalMods.Mellow.block.generator.GeneratorScreen;
import com.LockOriginalMods.Mellow.block.grinder.ScreenGrinder;
import com.LockOriginalMods.Mellow.data.GrindEvents;
import com.LockOriginalMods.Mellow.data.MellowMessages;
import com.LockOriginalMods.Mellow.loot.MellowdLootModifiers;
import com.LockOriginalMods.Mellow.network.Channel;
import com.LockOriginalMods.Mellow.recipe.MellowRecipe;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.LockOriginalMods.Mellow.Registry.*;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Mellow.MOD_ID)
public class Mellow
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "mellow";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogManager.getLogger();


    public Mellow()
    {
        new Config();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MELLOW_TABS.register(eventBus);
        ItemInit.ITEMS.register(eventBus);
        BlockInit.BLOCKS.register(eventBus);
        Registry.ITEMS.register(eventBus);
        Registry.BLOCKS.register(eventBus);
        Registry.MENUS.register(eventBus);
        Registry.TILES.register(eventBus);
        Registry.RECIPE_TYPES.register(eventBus);
        Registry.RECIPE_SERIALIZERS.register(eventBus);
        MellowRecipe.SERIALIZERS.register(eventBus);
        MellowdLootModifiers.register(eventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Cfg.SERVER_CONFIG);
        TagInit.init();
    }

    public static final DeferredRegister<CreativeModeTab> MELLOW_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final RegistryObject<CreativeModeTab> MELLOW_TAB = MELLOW_TABS.register("mellow_tab", ()->CreativeModeTab.builder().icon(()-> new ItemStack(ItemInit.RAW_TIN.get())).title(Component.translatable("creative.mellow_tab")).displayItems(((p_270258_, p_259752_) -> {
        p_259752_.accept(ItemInit.TIN_INGOT.get());
        p_259752_.accept(ItemInit.STEEL_DUST.get());
        p_259752_.accept(ItemInit.RAW_TIN.get());
        p_259752_.accept(BlockInit.TIN_BLOCK.get());
        p_259752_.accept(BlockInit.DEEPSLATE_TIN_ORE.get());
        p_259752_.accept(BlockInit.Electric_Furnace.get());
        p_259752_.accept(BlockInit.RAW_TIN_BLOCK.get());
        p_259752_.accept(BlockInit.TIN_ORE.get());
        p_259752_.accept(ItemInit.ALUMINIUM_DUST.get());
        p_259752_.accept(ItemInit.AMETHYST_DUST.get());
        p_259752_.accept(ItemInit.BRASS_DUST.get());
        p_259752_.accept(ItemInit.COAL_DUST.get());
        p_259752_.accept(ItemInit.COPPER_DUST.get());
        p_259752_.accept(ItemInit.DEEPSLATE_DUST.get());
        p_259752_.accept(ItemInit.GOLD_DUST.get());
        p_259752_.accept(ItemInit.IRON_DUST.get());
        p_259752_.accept(ItemInit.STONE_DUST.get());
        p_259752_.accept(ItemInit.TIN_DUST.get());
        p_259752_.accept(ItemInit.CORN_OIL.get());
        p_259752_.accept(ItemInit.ELECTRONIC_CIRCUIT.get());
        p_259752_.accept(ItemInit.ADVANCED_CIRCUIT.get());
        p_259752_.accept(ItemInit.CORN.get());
        p_259752_.accept(ItemInit.FLAX_FIBER.get());
        p_259752_.accept(ItemInit.MIXED_METAL_BLEND.get());
        p_259752_.accept(ItemInit.CLAY_DUST.get());
        p_259752_.accept(ItemInit.ALUMINUM_GEAR.get());
        p_259752_.accept(ItemInit.BRASS_GEAR.get());
        p_259752_.accept(ItemInit.GOLD_GEAR.get());
        p_259752_.accept(ItemInit.COPPER_GEAR.get());
        p_259752_.accept(ItemInit.IRON_GEAR.get());
        p_259752_.accept(ItemInit.TIN_GEAR.get());
        p_259752_.accept(ItemInit.ADVANCED_ALLOY.get());
        p_259752_.accept(ItemInit.ALUMINUM_INGOT.get());
        p_259752_.accept(ItemInit.STEEL_INGOT.get());
        p_259752_.accept(ItemInit.BRASS_INGOT.get());
        p_259752_.accept(ItemInit.ALUMINUM_NUGGET.get());
        p_259752_.accept(ItemInit.COPPER_NUGGET.get());
        p_259752_.accept(ItemInit.BRASS_NUGGET.get());
        p_259752_.accept(ItemInit.TIN_NUGGET.get());
        p_259752_.accept(ItemInit.BRASS_PLATE.get());
        p_259752_.accept(ItemInit.ALUMINUM_PLATE.get());
        p_259752_.accept(ItemInit.COPPER_PLATE.get());
        p_259752_.accept(ItemInit.GOLD_PLATE.get());
        p_259752_.accept(ItemInit.IRON_PLATE.get());
        p_259752_.accept(ItemInit.TIN_PLATE.get());
        p_259752_.accept(ItemInit.ENERGY_CRYSTAL.get());
        p_259752_.accept(ItemInit.GRAPHENE.get());
        p_259752_.accept(ItemInit.RUBBER.get());
        p_259752_.accept(ItemInit.SILICON.get());
        p_259752_.accept(ItemInit.CORN_SEEDS.get());
        p_259752_.accept(ItemInit.FLAX_CROP_SEEDS.get());
        p_259752_.accept(ItemInit.CUTTER.get());
        p_259752_.accept(ItemInit.HAMMER.get());
        p_259752_.accept(ItemInit.MORTAR.get());
        p_259752_.accept(ItemInit.COPPER_WIRE.get());
        p_259752_.accept(ItemInit.CRUSHED_KELP.get());
        p_259752_.accept(ItemInit.STEEL_DUST.get());
        p_259752_.accept(ItemInit.RAW_ALUMINUM.get());
        p_259752_.accept(ItemInit.RAW_ZINC.get());
        p_259752_.accept(ItemInit.ZINC_INGOT.get());
        p_259752_.accept(ItemInit.BRONZE_DUST.get());
        p_259752_.accept(ItemInit.BRONZE_INGOT.get());
        p_259752_.accept(ItemInit.BRONZE_NUGGET.get());
        p_259752_.accept(ItemInit.ZINC_DUST.get());
        p_259752_.accept(BlockInit.ZINC_ORE.get());
        p_259752_.accept(BlockInit.DEEPSLATE_ZINC_ORE.get());
        p_259752_.accept(BlockInit.ALUMINUM_ORE.get());
        p_259752_.accept(BlockInit.DEEPSLATE_ALUMINUM_ORE.get());
        p_259752_.accept(GENERATOR_BLOCK.get());
        p_259752_.accept(CHARGER_BLOCK.get());
        p_259752_.accept(ItemInit.BATTERY.get());
        p_259752_.accept(Registry.CHARGING_STATION.get());
        p_259752_.accept(Registry.GRINDER.get());
        p_259752_.accept(Registry.handle.get());
        p_259752_.accept(Registry.RUBBER_SAPLING.get());
        p_259752_.accept(Registry.RUBBER_LOG.get());
        p_259752_.accept(Registry.RUBBER_WOOD.get());
        p_259752_.accept(Registry.STRIPPED_RUBBER_LOG.get());
        p_259752_.accept(Registry.STRIPPED_RUBBER_WOOD.get());
        p_259752_.accept(ItemInit.RESIN.get());
        p_259752_.accept(Registry.RUBBER_LEAVES.get());
        p_259752_.accept(Registry.RUBBER_SLAB.get());
        p_259752_.accept(Registry.RUBBER_STAIRS.get());
        p_259752_.accept(Registry.RUBBER_PLANKS.get());
        p_259752_.accept(ItemInit.RUBBER_SEEDS.get());
        p_259752_.accept(Registry.CABLE_BLOCK.get());

    })).build());


    private void setup(final FMLCommonSetupEvent event) {
        //now all blocks/items exist
        MinecraftForge.EVENT_BUS.register(new GrindEvents());
        TopCompatibility.register();
        Channel.register();
        MellowMessages.register();

        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Registry.RUBBER_SAPLING.getId(), Registry.POTTED_RUBBER_SAPLING);
        });
    }

    private void setupClient(final FMLClientSetupEvent event) {
        //for client side only setup
        event.enqueueWork(() -> {
            MenuScreens.register(Registry.MENU.get(), ScreenGrinder::new);
        });
        event.enqueueWork(() -> {
            MenuScreens.register(Registry.GENERATOR_CONTAINER.get(), GeneratorScreen::new);
        });
        MenuScreens.register(Registry.CHARGING_STATION_CONTAINER.get(), ChargingStationScreen::new);

        MenuScreens.register(Registry.Electric_Furnace_Menu.get(), ElectricFurnaceScreen::new);

        MenuScreens.register(Registry.Crusher_Menu.get(), CrusherScreen::new);

    }
}
