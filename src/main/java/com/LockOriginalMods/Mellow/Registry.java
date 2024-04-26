package com.LockOriginalMods.Mellow;

import com.LockOriginalMods.Mellow.Init.BlockInit;
import com.LockOriginalMods.Mellow.Init.ItemInit;
import com.LockOriginalMods.Mellow.block.cables.*;
import com.LockOriginalMods.Mellow.block.charger_plate.ChargerBlock;
import com.LockOriginalMods.Mellow.block.charger_plate.ChargerBlockEntity;
import com.LockOriginalMods.Mellow.block.charger_station.ChargingStationBlock;
import com.LockOriginalMods.Mellow.block.charger_station.ChargingStationContainer;
import com.LockOriginalMods.Mellow.block.charger_station.ChargingStationItem;
import com.LockOriginalMods.Mellow.block.charger_station.ChargingStationTile;
import com.LockOriginalMods.Mellow.block.crusher.CrusherBlockEntity;
import com.LockOriginalMods.Mellow.block.crusher.CrusherMenu;
import com.LockOriginalMods.Mellow.block.furnace.ElectricFurnaceBlockEntity;
import com.LockOriginalMods.Mellow.block.furnace.ElectricFurnaceMenu;
import com.LockOriginalMods.Mellow.block.generator.GeneratorBlock;
import com.LockOriginalMods.Mellow.block.generator.GeneratorBlockEntity;
import com.LockOriginalMods.Mellow.block.generator.GeneratorContainer;
import com.LockOriginalMods.Mellow.block.grinder.BlockEntityGrinder;
import com.LockOriginalMods.Mellow.block.grinder.BlockGrinder;
import com.LockOriginalMods.Mellow.block.grinder.ContainerGrinder;
import com.LockOriginalMods.Mellow.block.grinder.GrindRecipe;
import com.LockOriginalMods.Mellow.block.handle.BlockHandle;
import com.LockOriginalMods.Mellow.block.rubber.*;
import com.LockOriginalMods.Mellow.utils.RubberWoodBlockItem;
import com.LockOriginalMods.Mellow.worldgen.RubberTreeGrower;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registry {
    static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);
    static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(ForgeRegistries.MENU_TYPES,MOD_ID);
    static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MOD_ID);
    static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, MOD_ID);
    private static final ResourceKey<CreativeModeTab> TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(MOD_ID, "tab"));

    /*
    @SubscribeEvent
    public static void onCreativeModeTabRegister(RegisterEvent event) {
        event.register(Registries.CREATIVE_MODE_TAB, helper -> {
            helper.register(TAB, CreativeModeTab.builder().icon(() -> new ItemStack(ihandle.get()))
                    .title(Component.translatable("itemGroup." + MOD_ID))
                    .displayItems((enabledFlags, populator) -> {
                        for (RegistryObject<Item> entry : ITEMS.getEntries()) {
                            populator.accept(entry.get());
                        }
                    }).build());
        });
    }*/
    public static final RegistryObject<FacadeBlock> FACADE_BLOCK = BLOCKS.register("facade", FacadeBlock::new);
  public static final RegistryObject<Item> FACADE_BLOCK_ITEM = ITEMS.register("facade", () -> new FacadeBlockItem(FACADE_BLOCK.get(), new Item.Properties()));
  public static final RegistryObject<BlockEntityType<FacadeBlockEntity>> FACADE_BLOCK_ENTITY = TILES.register("facade",
          () -> BlockEntityType.Builder.of(FacadeBlockEntity::new, FACADE_BLOCK.get()).build(null));

  public static final RegistryObject<CableBlock> CABLE_BLOCK = BLOCKS.register("cable", CableBlock::new);
  public static final RegistryObject<Item> CABLE_BLOCK_ITEM = ITEMS.register("cable", () -> new BlockItem(CABLE_BLOCK.get(), new Item.Properties()));
  public static final RegistryObject<BlockEntityType<CableBlockEntity>> CABLE_BLOCK_ENTITY = TILES.register("cable",
          () -> BlockEntityType.Builder.of(CableBlockEntity::new, CABLE_BLOCK.get()).build(null));
  public static final RegistryObject<Block> RUBBER_LOG = registerRubberWoodBlock("rubber_log", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
  public static final RegistryObject<Block> RUBBER_WOOD = registerRubberWoodBlock("rubber_wood", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
  public static final RegistryObject<Block> STRIPPED_RUBBER_LOG = registerRubberWoodBlock("stripped_rubber_log", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
  public static final RegistryObject<Block> STRIPPED_RUBBER_WOOD = registerRubberWoodBlock("stripped_rubber_wood", () -> new RubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));

  // Full Rubber Wood
  public static final RegistryObject<Block> FULL_RUBBER_LOG = registerRubberWoodBlock("full_rubber_log", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_LOG)));
  public static final RegistryObject<Block> FULL_RUBBER_WOOD = registerRubberWoodBlock("full_rubber_wood", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
  public static final RegistryObject<Block> FULL_STRIPPED_RUBBER_LOG = registerRubberWoodBlock("full_stripped_rubber_log", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
  public static final RegistryObject<Block> FULL_STRIPPED_RUBBER_WOOD = registerRubberWoodBlock("full_stripped_rubber_wood", () -> new FullRubberWoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));

  // Other Rubber Tree Pieces
  public static final RegistryObject<Block> RUBBER_LEAVES = registerBlock("rubber_leaves", () -> new RubberLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).strength(.2f).sound(SoundType.GRASS)));
  public static final RegistryObject<Block> RUBBER_SAPLING = registerBlock("rubber_sapling", () -> new SaplingBlock(new RubberTreeGrower(), BlockBehaviour.Properties.copy(Blocks.JUNGLE_SAPLING).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
  public static final RegistryObject<Block> POTTED_RUBBER_SAPLING = BLOCKS.register("potted_rubber_sapling", () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), Registry.RUBBER_SAPLING, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT).instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

  public static final RegistryObject<Block> RUBBER_SLAB = registerBlock("rubber_slab", ()-> new RubberSlab());

  public static final RegistryObject<Block> RUBBER_STAIRS = registerBlock("rubber_stairs", ()-> new RubberStairs());
  public static final RegistryObject<Block> RUBBER_PLANKS = registerBlock("rubber_planks", ()-> new RubberPlanks());


  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
    return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(),
            new Item.Properties()));
  }

  /**************************** Specific Registry ****************************/
  public static <T extends Block> RegistryObject<T> registerRubberWoodBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerRubberWoodBlockItem(name, toReturn);
    return toReturn;
  }

  private static <T extends Block> RegistryObject<Item> registerRubberWoodBlockItem(String name, RegistryObject<T> block) {
    return ItemInit.ITEMS.register(name, () -> new RubberWoodBlockItem(block.get(), new Item.Properties()));
  }



  /*
  public static final RegistryObject<Block> ELECTRIC_FURNACE = BLOCKS.register("electric_furnace", ()-> new ElectricFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.FURNACE).sound(SoundType.DEEPSLATE).noOcclusion()));
   */


  public static final RegistryObject<Block> GRINDER = BLOCKS.register("grinder", () -> new BlockGrinder(Block.Properties.of().strength(0.9F)));
  public static final RegistryObject<Block> handle = BLOCKS.register("handle", () -> new BlockHandle(Block.Properties.of().strength(0.4F)));
  public static final RegistryObject<Item> igrinder = ITEMS.register("grinder", () -> new BlockItem(GRINDER.get(), new Item.Properties()));
  public static final RegistryObject<Item> ihandle = ITEMS.register("handle", () -> new BlockItem(handle.get(), new Item.Properties()));
  //block entity and container
  public static final RegistryObject<BlockEntityType<BlockEntityGrinder>> TE_GRINDER = TILES.register("grinder", () -> BlockEntityType.Builder.of(BlockEntityGrinder::new, GRINDER.get()).build(null));    public static final RegistryObject<MenuType<ContainerGrinder>> MENU = MENUS.register("grinder", () -> IForgeMenuType.create(ContainerGrinder::new));
    public static final RegistryObject<RecipeType<GrindRecipe>> GRINDER_RECIPE_TYPE = RECIPE_TYPES.register("grinder", () -> new RecipeType<GrindRecipe>() {
    });
    public static final RegistryObject<GrindRecipe.SerializeGrinderRecipe> GRINDER_RECIPE_SERIALIZER = RECIPE_SERIALIZERS.register("grinder", GrindRecipe.SerializeGrinderRecipe::new);
    public static final RegistryObject<GeneratorBlock> GENERATOR_BLOCK = BLOCKS.register("generator_block", GeneratorBlock::new);
    public static final RegistryObject<Item> GENERATOR_BLOCK_ITEM = ITEMS.register("generator_block", () -> new BlockItem(GENERATOR_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<BlockEntityType<GeneratorBlockEntity>> GENERATOR_BLOCK_ENTITY = TILES.register("generator_block",
            () -> BlockEntityType.Builder.of(GeneratorBlockEntity::new, GENERATOR_BLOCK.get()).build(null));
    public static final RegistryObject<MenuType<GeneratorContainer>> GENERATOR_CONTAINER = MENUS.register("generator_block",
            () -> IForgeMenuType.create((windowId, inv, data) -> new GeneratorContainer(windowId, inv.player, data.readBlockPos())));
    public static final RegistryObject<ChargerBlock> CHARGER_BLOCK = BLOCKS.register("charger_block", ChargerBlock::new);
    public static final RegistryObject<Item> CHARGER_BLOCK_ITEM = ITEMS.register("charger_block", () -> new BlockItem(CHARGER_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<BlockEntityType<ChargerBlockEntity>> CHARGER_BLOCK_ENTITY = TILES.register("charger_block",
            () -> BlockEntityType.Builder.of(ChargerBlockEntity::new, CHARGER_BLOCK.get()).build(null));
    public static final RegistryObject<Block> CHARGING_STATION = BLOCKS.register("charging_station", ChargingStationBlock::new);
    public static final RegistryObject<BlockEntityType<ChargingStationTile>> CHARGING_STATION_TILE =
            TILES.register("charging_station_tile", () -> BlockEntityType.Builder.of(ChargingStationTile::new, CHARGING_STATION.get()).build(null));
    public static final RegistryObject<MenuType<ChargingStationContainer>> CHARGING_STATION_CONTAINER = MENUS.register("charging_station_container", () -> IForgeMenuType.create(ChargingStationContainer::new));
    public static final RegistryObject<Item> CHARGING_STATION_BI = ITEMS.register("charging_station", () -> new ChargingStationItem(CHARGING_STATION.get(), new Item.Properties()));

    public static final RegistryObject<BlockEntityType<ElectricFurnaceBlockEntity>> Electric_Furnace = TILES.register("electric_furnace",()->BlockEntityType.Builder.of(ElectricFurnaceBlockEntity::new,
            BlockInit.Electric_Furnace.get()).build(null));

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name){
      return MENUS.register(name, ()-> IForgeMenuType.create(factory));
    }

    public static final RegistryObject<MenuType<ElectricFurnaceMenu>> Electric_Furnace_Menu = registerMenuType(ElectricFurnaceMenu::new,"electric_furnace_menu");

  public static final RegistryObject<BlockEntityType<CrusherBlockEntity>> CRUSHER = TILES.register("crusher",()->BlockEntityType.Builder.of(CrusherBlockEntity::new,
          BlockInit.CRUSHER.get()).build(null));

  public static final RegistryObject<MenuType<CrusherMenu>> Crusher_Menu = registerMenuType(CrusherMenu::new,"crusher_menu");
}

