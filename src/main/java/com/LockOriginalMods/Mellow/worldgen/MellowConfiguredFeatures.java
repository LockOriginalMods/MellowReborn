package com.LockOriginalMods.Mellow.worldgen;

import com.LockOriginalMods.Mellow.Init.BlockInit;
import com.LockOriginalMods.Mellow.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class MellowConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBBER_KEY = registerkey("rubber");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OWERWORLD_TIN_ORE_KEY = registerkey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OWERWORLD_ZINC_ORE_KEY = registerkey("zinc_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OWERWORLD_ALUMINUM_ORE_KEY = registerkey("aluminum_ore");


    private static ResourceKey<ConfiguredFeature<?,?>> registerkey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(MOD_ID, name));
    }


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);


        List<OreConfiguration.TargetBlockState> overworldBlackTinOres = List.of(OreConfiguration.target(stoneReplaceables,
                        BlockInit.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockInit.DEEPSLATE_TIN_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldBlackZincOres = List.of(OreConfiguration.target(stoneReplaceables,
                        BlockInit.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockInit.DEEPSLATE_ZINC_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldBlackAluminumOres = List.of(OreConfiguration.target(stoneReplaceables,
                        BlockInit.ALUMINUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockInit.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState()));


        register(context, OWERWORLD_TIN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBlackTinOres, 9));
        register(context, OWERWORLD_ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBlackZincOres, 9));
        register(context, OWERWORLD_ALUMINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBlackAluminumOres, 9));

        register(context, RUBBER_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Registry.FULL_RUBBER_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(Registry.RUBBER_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

    }



    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}