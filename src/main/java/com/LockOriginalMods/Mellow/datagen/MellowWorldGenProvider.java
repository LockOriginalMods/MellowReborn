package com.LockOriginalMods.Mellow.datagen;

import com.LockOriginalMods.Mellow.worldgen.MellowBiomeModifiers;
import com.LockOriginalMods.Mellow.worldgen.MellowConfiguredFeatures;
import com.LockOriginalMods.Mellow.worldgen.MellowPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class  MellowWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, MellowConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, MellowPlacedFeatures::bootstrap)
      .add(ForgeRegistries.Keys.BIOME_MODIFIERS, MellowBiomeModifiers::bootstrap);


    public MellowWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MOD_ID));
    }
}

