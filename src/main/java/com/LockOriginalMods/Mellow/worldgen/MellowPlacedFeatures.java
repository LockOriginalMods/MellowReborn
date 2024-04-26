package com.LockOriginalMods.Mellow.worldgen;

import com.LockOriginalMods.Mellow.Init.BlockInit;
import com.LockOriginalMods.Mellow.Registry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class MellowPlacedFeatures {

    public static final ResourceKey<PlacedFeature> RUBBER_PLACED_KEY = createKey("rubber_placed");

        public static final ResourceKey<PlacedFeature> OWERWORLD_TIN_ORE_KEY = createKey("tin_ore");
    public static final ResourceKey<PlacedFeature> OWERWORLD_ZINC_ORE_KEY = createKey("zinc_ore");
    public static final ResourceKey<PlacedFeature> OWERWORLD_ALUMINUM_ORE_KEY = createKey("aluminum_ore");

        public static void bootstrap(BootstapContext<PlacedFeature> context) {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

            register(context, OWERWORLD_TIN_ORE_KEY, configuredFeatures.getOrThrow(MellowConfiguredFeatures.OWERWORLD_TIN_ORE_KEY),
                    MellowOrePlacement.commonOrePlacement(16, // veins per chunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(80))));

            register(context, OWERWORLD_ZINC_ORE_KEY, configuredFeatures.getOrThrow(MellowConfiguredFeatures.OWERWORLD_TIN_ORE_KEY),
                    MellowOrePlacement.commonOrePlacement(16, // veins per chunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(80))));

            register(context, OWERWORLD_ALUMINUM_ORE_KEY, configuredFeatures.getOrThrow(MellowConfiguredFeatures.OWERWORLD_ALUMINUM_ORE_KEY),
                    MellowOrePlacement.commonOrePlacement(16, // veins per chunk
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(80))));

            register(context, RUBBER_PLACED_KEY, configuredFeatures.getOrThrow(MellowConfiguredFeatures.RUBBER_KEY),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1f, 1), Registry.RUBBER_SAPLING.get()));
        }


        private static ResourceKey<PlacedFeature> createKey(String name) {
            return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MOD_ID, name));
        }

        private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                     List<PlacementModifier> modifiers) {
            context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
        }


    }

