package com.LockOriginalMods.Mellow.datagen;

import com.LockOriginalMods.Mellow.Init.BlockInit;
import com.LockOriginalMods.Mellow.Init.ItemInit;
import com.LockOriginalMods.Mellow.Registry;
import com.LockOriginalMods.Mellow.recipe.ElectricFurnaceRecipe;
import com.LockOriginalMods.Mellow.recipe.MellowRecipe;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class MellowRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public MellowRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {




        oreSmelting(consumer, List.of(ItemInit.RAW_TIN.get()), RecipeCategory.MISC,
                ItemInit.TIN_INGOT.get(), 0.7f, 200, "tin");


        oreSmelting(consumer, List.of(ItemInit.RESIN.get()), RecipeCategory.MISC,
                ItemInit.RUBBER.get(), 0.7f, 200, "rubber");


        oreSmelting(consumer, List.of(ItemInit.IRON_DUST.get()), RecipeCategory.MISC,
                Items.IRON_INGOT, 0.7f, 200, "iron");

        oreSmelting(consumer, List.of(ItemInit.GOLD_DUST.get()), RecipeCategory.MISC,
                Items.GOLD_INGOT, 0.7f, 200, "gold");




        oreSmelting(consumer, List.of(ItemInit.RAW_ALUMINUM.get()), RecipeCategory.MISC,
                ItemInit.ALUMINUM_INGOT.get(), 0.7f, 200, "aluminum");

        oreSmelting(consumer, List.of(ItemInit.RAW_ZINC.get()), RecipeCategory.MISC,
                ItemInit.ZINC_INGOT.get(), 0.7f, 200, "zinc");

        oreSmelting(consumer, List.of(ItemInit.BRONZE_DUST.get()), RecipeCategory.MISC,
                ItemInit.BRONZE_INGOT.get(), 0.7f, 200, "bronze");

        oreSmelting(consumer, List.of(ItemInit.STEEL_DUST.get()), RecipeCategory.MISC,
                ItemInit.STEEL_INGOT.get(), 0.7f, 200, "steel");

        oreSmelting(consumer, List.of(ItemInit.MIXED_METAL_BLEND.get()), RecipeCategory.MISC,
                ItemInit.ADVANCED_ALLOY.get(), 0.7f, 200, "advanced_alloy");

        oreSmelting(consumer, List.of(ItemInit.ALUMINIUM_DUST.get()), RecipeCategory.MISC,
                ItemInit.ALUMINUM_INGOT.get(), 0.7f, 200, "aluminum");

        oreSmelting(consumer, List.of(ItemInit.BRASS_DUST.get()), RecipeCategory.MISC,
                ItemInit.BRASS_INGOT.get(), 0.7f, 200, "brass");

        oreSmelting(consumer, List.of(Items.COAL), RecipeCategory.MISC,
                ItemInit.GRAPHENE.get(), 0.7f, 200, "tin");

        oreSmelting(consumer, List.of(Items.QUARTZ), RecipeCategory.MISC,
                ItemInit.SILICON.get(), 0.7f, 200, "silicon");

        oreSmelting(consumer, List.of(ItemInit.CRUSHED_KELP.get()), RecipeCategory.MISC,
                ItemInit.RUBBER.get(), 0.7f, 200, "rubber");

        oreBlasting(consumer, List.of(ItemInit.RAW_TIN.get()), RecipeCategory.MISC,
                ItemInit.TIN_INGOT.get(), 0.7f, 100, "tin");

        oreSmelting(consumer, List.of(BlockInit.TIN_ORE.get()), RecipeCategory.MISC,
                ItemInit.TIN_INGOT.get(), 0.7f, 200, "tin");

        oreBlasting(consumer, List.of(BlockInit.TIN_ORE.get()), RecipeCategory.MISC,
                ItemInit.TIN_INGOT.get(), 0.7f, 100, "tin");

        oreSmelting(consumer, List.of(BlockInit.DEEPSLATE_TIN_ORE.get()), RecipeCategory.MISC,
                ItemInit.TIN_INGOT.get(), 0.7f, 200, "tin");

        oreSmelting(consumer, List.of(Registry.RUBBER_LOG.get()), RecipeCategory.MISC,
               Items.CHARCOAL, 0.7f, 200, "char");
        oreSmelting(consumer, List.of(Registry.RUBBER_WOOD.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.7f, 200, "char");
        oreSmelting(consumer, List.of(Registry.STRIPPED_RUBBER_LOG.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.7f, 200, "char");
        oreSmelting(consumer, List.of(Registry.STRIPPED_RUBBER_WOOD.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.7f, 200, "char");
        oreSmelting(consumer, List.of(Registry.FULL_RUBBER_LOG.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.7f, 200, "char");
        oreSmelting(consumer, List.of(Registry.FULL_RUBBER_WOOD.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.7f, 200, "char");
        oreSmelting(consumer, List.of(Registry.FULL_STRIPPED_RUBBER_LOG.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.7f, 200, "char");
        oreSmelting(consumer, List.of(Registry.FULL_STRIPPED_RUBBER_WOOD.get()), RecipeCategory.MISC,
                Items.CHARCOAL, 0.7f, 200, "char");


        oreBlasting(consumer, List.of(BlockInit.DEEPSLATE_TIN_ORE.get()), RecipeCategory.MISC,
                ItemInit.TIN_INGOT.get(), 0.7f, 100, "tin");


        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ItemInit.TIN_INGOT.get(), RecipeCategory.MISC,
                BlockInit.TIN_BLOCK.get());
        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ItemInit.RAW_TIN.get(), RecipeCategory.MISC,
                BlockInit.RAW_TIN_BLOCK.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.TIN_PLATE.get(), 1)
                .requires(ItemInit.TIN_INGOT.get())
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registry.RUBBER_PLANKS.get(), 4)
                .requires(Registry.RUBBER_LOG.get())
                .unlockedBy("has_planks", has(Registry.RUBBER_LOG.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registry.RUBBER_PLANKS.get(), 4)
                .requires(Registry.RUBBER_WOOD.get())
                .unlockedBy("has_planks", has(Registry.RUBBER_LOG.get()))
                .save(finishedRecipe -> Registry.RUBBER_PLANKS.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registry.RUBBER_PLANKS.get(), 4)
                .requires(Registry.FULL_RUBBER_LOG.get())
                .unlockedBy("has_planks", has(Registry.RUBBER_LOG.get()))
                .save(finishedRecipe -> Registry.RUBBER_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registry.RUBBER_PLANKS.get(), 4)
                .requires(Registry.FULL_RUBBER_WOOD.get())
                .unlockedBy("has_planks", has(Registry.RUBBER_LOG.get()))
                .save(finishedRecipe -> Registry.RUBBER_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registry.RUBBER_PLANKS.get(), 4)
                .requires(Registry.STRIPPED_RUBBER_WOOD.get())
                .unlockedBy("has_planks", has(Registry.RUBBER_LOG.get()))
                .save(finishedRecipe -> Registry.RUBBER_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registry.RUBBER_PLANKS.get(), 4)
                .requires(Registry.STRIPPED_RUBBER_LOG.get())
                .unlockedBy("has_planks", has(Registry.RUBBER_LOG.get()))
                .save(finishedRecipe -> Registry.RUBBER_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registry.RUBBER_PLANKS.get(), 4)
                .requires(Registry.FULL_STRIPPED_RUBBER_WOOD.get())
                .unlockedBy("has_planks", has(Registry.RUBBER_LOG.get()))
                .save(finishedRecipe -> Registry.RUBBER_PLANKS.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Registry.RUBBER_PLANKS.get(), 4)
                .requires(Registry.FULL_STRIPPED_RUBBER_LOG.get())
                .unlockedBy("has_planks", has(Registry.RUBBER_LOG.get()))
                .save(finishedRecipe -> Registry.RUBBER_LOG.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.CRUSHED_KELP.get(), 1)
                .requires(Items.KELP)
                .requires(ItemInit.MORTAR.get())
                .unlockedBy("has_mortar", has(ItemInit.MORTAR.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.IRON_PLATE.get(), 1)
                .requires(Items.IRON_INGOT)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.AMETHYST_DUST.get(), 1)
                .requires(Items.AMETHYST_SHARD)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.CLAY_DUST.get(), 1)
                .requires(Items.CLAY_BALL)
                .requires(ItemInit.MORTAR.get())
                .unlockedBy("has_mortar", has(ItemInit.MORTAR.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.COPPER_DUST.get(), 1)
                .requires(Items.RAW_COPPER)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.DEEPSLATE_DUST.get(), 1)
                .requires(Items.COBBLED_DEEPSLATE)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.GOLD_DUST.get(), 1)
                .requires(Items.RAW_GOLD)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.IRON_DUST.get(), 1)
                .requires(Items.RAW_IRON)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.STONE_DUST.get(), 1)
                .requires(Items.COBBLESTONE)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.TIN_DUST.get(), 1)
                .requires(ItemInit.RAW_TIN.get())
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.GOLD_PLATE.get(), 1)
                .requires(Items.GOLD_INGOT)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.BRASS_PLATE.get(), 1)
                .requires(ItemInit.BRASS_INGOT.get())
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.ZINC_DUST.get(), 1)
                .requires(ItemInit.RAW_ZINC.get())
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.COPPER_WIRE.get(), 3)
                .requires(ItemInit.COPPER_PLATE.get())
                .requires(ItemInit.CUTTER.get())
                .unlockedBy("has_cutter", has(ItemInit.CUTTER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.ALUMINUM_NUGGET.get(), 9)
                .requires(ItemInit.ALUMINUM_INGOT.get())
                .unlockedBy("has_aluminum_ingot", has(ItemInit.ALUMINUM_INGOT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.BRASS_NUGGET.get(), 9)
                .requires(ItemInit.BRASS_INGOT.get())
                .unlockedBy("has_brass_ingot", has(ItemInit.BRASS_INGOT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.COPPER_NUGGET.get(), 9)
                .requires(Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.TIN_NUGGET.get(), 9)
                .requires(ItemInit.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", has(ItemInit.TIN_INGOT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.BRONZE_NUGGET.get(), 9)
                .requires(ItemInit.BRONZE_INGOT.get())
                .unlockedBy("has_bronze_ingot", has(ItemInit.BRONZE_INGOT.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.STEEL_DUST.get(), 1)
                .requires(ItemInit.IRON_DUST.get())
                .requires(ItemInit.COAL_DUST.get())
                .requires(ItemInit.COAL_DUST.get())
                .requires(ItemInit.MORTAR.get())
                .unlockedBy("has_mortar", has(ItemInit.MORTAR.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.CORN_OIL.get(), 1)
                .requires(ItemInit.CORN_SEEDS.get())
                .requires(ItemInit.CORN_SEEDS.get())
                .requires(Items.GLASS_BOTTLE)
                .requires(ItemInit.MORTAR.get())
                .unlockedBy("has_mortar", has(ItemInit.MORTAR.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.BRONZE_DUST.get(), 1)
                .requires(ItemInit.COPPER_DUST.get())
                .requires(ItemInit.TIN_DUST.get())
                .requires(ItemInit.TIN_DUST.get())
                .requires(ItemInit.MORTAR.get())
                .unlockedBy("has_mortar", has(ItemInit.MORTAR.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.MIXED_METAL_BLEND.get(), 1)
                .requires(ItemInit.BRASS_DUST.get())
                .requires(ItemInit.ALUMINIUM_DUST.get())
                .requires(ItemInit.TIN_DUST.get())
                .requires(ItemInit.MORTAR.get())
                .unlockedBy("has_mortar", has(ItemInit.MORTAR.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.BRASS_DUST.get(), 1)
                .requires(ItemInit.IRON_DUST.get())
                .requires(ItemInit.ZINC_DUST.get())
                .requires(ItemInit.ZINC_DUST.get())
                .requires(ItemInit.MORTAR.get())
                .unlockedBy("has_mortar", has(ItemInit.MORTAR.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.ALUMINUM_PLATE.get(), 1)
                .requires(ItemInit.ALUMINUM_INGOT.get())
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.COPPER_PLATE.get(), 1)
                .requires(Items.COPPER_INGOT)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.ALUMINIUM_DUST.get(), 1)
                .requires(ItemInit.RAW_ALUMINUM.get())
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.COAL_DUST.get(), 1)
                .requires(Items.COAL)
                .requires(ItemInit.HAMMER.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.HAMMER.get(), 1)
                .pattern(" X ")
                .pattern(" RX")
                .pattern("R  ")
                .define('X', Items.IRON_INGOT)
                .define('R', Items.STICK)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registry.handle.get(), 1)
                .pattern("XXX")
                .pattern("X  ")
                .pattern("X  ")
                .define('X', Items.STICK)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registry.GRINDER.get(), 1)
                .pattern("RRR")
                .pattern("ZXZ")
                .pattern("RRR")
                .define('X', ItemInit.HAMMER.get())
                .define('R', ItemInit.COPPER_PLATE.get())
                .define('Z', ItemInit.COPPER_GEAR.get())
                .unlockedBy("has_hammer", has(ItemInit.HAMMER.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registry.CHARGING_STATION.get(), 1)
                .pattern("RRR")
                .pattern("XXX")
                .pattern("RRR")
                .define('X', ItemInit.BATTERY.get())
                .define('R', ItemInit.COPPER_PLATE.get())
                .unlockedBy("has_battery", has(ItemInit.BATTERY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registry.CHARGER_BLOCK.get(), 1)
                .pattern("RRR")
                .pattern("ZXZ")
                .pattern("RRR")
                .define('X', ItemInit.BATTERY.get())
                .define('R', ItemInit.COPPER_PLATE.get())
                .define('Z', ItemInit.TIN_PLATE.get())
                .unlockedBy("has_battery", has(ItemInit.BATTERY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockInit.Electric_Furnace.get(), 1)
                .pattern("RRR")
                .pattern("ZXZ")
                .pattern("RYR")
                .define('X', ItemInit.BATTERY.get())
                .define('R', ItemInit.COPPER_PLATE.get())
                .define('Z', ItemInit.TIN_PLATE.get())
                .define('Y', Items.FURNACE)
                .unlockedBy("has_battery", has(ItemInit.BATTERY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registry.CABLE_BLOCK.get(), 4)
                .pattern("RRR")
                .pattern("ZXZ")
                .pattern("RRR")
                .define('X', ItemInit.GRAPHENE.get())
                .define('R', ItemInit.COPPER_WIRE.get())
                .define('Z', ItemInit.RUBBER.get())

                .unlockedBy("has_copper", has(Items.COPPER_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.BATTERY.get(), 1)
                .pattern(" Z ")
                .pattern("XRX")
                .pattern("XRX")
                .define('X', ItemInit.TIN_PLATE.get())
                .define('R', ItemInit.ENERGY_CRYSTAL.get())
                .define('Z', ItemInit.GRAPHENE.get())
                .unlockedBy("has_energy", has(ItemInit.ENERGY_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registry.GENERATOR_BLOCK.get(), 1)
                .pattern("ZXZ")
                .pattern("XRX")
                .pattern("XSX")
                .define('X', ItemInit.IRON_PLATE.get())
                .define('R', ItemInit.BATTERY.get())
                .define('Z', ItemInit.TIN_PLATE.get())
                .define('S', Items.FURNACE)
                .unlockedBy("has_furnace", has(Items.FURNACE))
                .save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.ENERGY_CRYSTAL.get(), 1)
                .pattern(" X ")
                .pattern("XRX")
                .pattern(" X ")
                .define('X', Items.REDSTONE)
                .define('R', ItemInit.GRAPHENE.get())
                .unlockedBy("has_graphene", has(ItemInit.GRAPHENE.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registry.RUBBER_STAIRS.get(), 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .define('X', Registry.RUBBER_PLANKS.get())
                .unlockedBy("has_stairs", has(Registry.RUBBER_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Registry.RUBBER_SLAB.get(), 6)
                .pattern("   ")
                .pattern("RRR")
                .pattern("   ")
                .define('R', Registry.RUBBER_PLANKS.get())
                .unlockedBy("has_slab", has(Registry.RUBBER_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.CUTTER.get(), 1)
                .pattern(" RX")
                .pattern("  R")
                .pattern("   ")
                .define('X', Items.IRON_INGOT)
                .define('R', Items.STICK)
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.MORTAR.get(), 1)
                .pattern("XR ")
                .pattern("QC ")
                .pattern("   ")
                .define('X', Items.BOWL)
                .define('R', Items.STICK)
                .define('Q', Items.FLINT)
                .define('C', ItemInit.COAL_DUST.get())
                .unlockedBy("has_stick", has(Items.STICK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.IRON_GEAR.get(), 1)
                .pattern(" X ")
                .pattern("XCX")
                .pattern(" X ")
                .define('X', Items.IRON_NUGGET)
                .define('C', Items.IRON_INGOT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.TIN_GEAR.get(), 1)
                .pattern(" X ")
                .pattern("XCX")
                .pattern(" X ")
                .define('X', ItemInit.TIN_NUGGET.get())
                .define('C', ItemInit.TIN_INGOT.get())
                .unlockedBy("has_stick", has(ItemInit.TIN_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.COPPER_GEAR.get(), 1)
                .pattern(" X ")
                .pattern("XCX")
                .pattern(" X ")
                .define('X', ItemInit.COPPER_NUGGET.get())
                .define('C', Items.COPPER_INGOT)
                .unlockedBy("has_copper", has(Items.COPPER_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.GOLD_GEAR.get(), 1)
                .pattern(" X ")
                .pattern("XCX")
                .pattern(" X ")
                .define('X', Items.GOLD_NUGGET)
                .define('C', Items.GOLD_INGOT)
                .unlockedBy("has_gold", has(Items.GOLD_INGOT))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.BRASS_GEAR.get(), 1)
                .pattern(" X ")
                .pattern("XCX")
                .pattern(" X ")
                .define('X', ItemInit.BRASS_NUGGET.get())
                .define('C', ItemInit.BRASS_INGOT.get())
                .unlockedBy("has_brass", has(ItemInit.BRASS_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.ALUMINUM_GEAR.get(), 1)
                .pattern(" X ")
                .pattern("XCX")
                .pattern(" X ")
                .define('X', ItemInit.ALUMINUM_NUGGET.get())
                .define('C', ItemInit.ALUMINUM_INGOT.get())
                .unlockedBy("has_aluminum", has(ItemInit.ALUMINUM_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.ELECTRONIC_CIRCUIT.get(), 1)
                .pattern("XXX")
                .pattern("SCS")
                .pattern("XXX")
                .define('S', ItemInit.GRAPHENE.get())
                .define('X', ItemInit.COPPER_WIRE.get())
                .define('C', ItemInit.ENERGY_CRYSTAL.get())
                .unlockedBy("has_energy_crystal", has(ItemInit.ENERGY_CRYSTAL.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.ADVANCED_CIRCUIT.get(), 1)
                .pattern("FXF")
                .pattern("SCS")
                .pattern("FXF")
                .define('S', ItemInit.ELECTRONIC_CIRCUIT.get())
                .define('F', ItemInit.BRASS_GEAR.get())
                .define('X', ItemInit.ADVANCED_ALLOY.get())
                .define('C', ItemInit.SILICON.get())
                .unlockedBy("has_electronic_circuit", has(ItemInit.ELECTRONIC_CIRCUIT.get()))
                .save(consumer);
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_, RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_, String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_)).save(p_250423_, new ResourceLocation(MOD_ID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_).unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(MOD_ID,p_250475_));
    }
    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oneToOneConversionRecipe(Consumer<FinishedRecipe> p_176552_, ItemLike p_176553_, ItemLike p_176554_, @Nullable String p_176555_) {
        oneToOneConversionRecipe(p_176552_, p_176553_, p_176554_, p_176555_, 1);
    }

    protected static void oneToOneConversionRecipe(Consumer<FinishedRecipe> p_176557_, ItemLike p_176558_, ItemLike p_176559_, @Nullable String p_176560_, int p_176561_) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, p_176558_, p_176561_).requires(p_176559_).group(p_176560_).unlockedBy(getHasName(p_176559_), has(p_176559_)).save(p_176557_, getConversionRecipeName(p_176558_, p_176559_));
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for (ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_).unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, new ResourceLocation(MOD_ID,getItemName(p_250066_)) + p_249236_ + "_" + getItemName(itemlike));
        }
    }



}


