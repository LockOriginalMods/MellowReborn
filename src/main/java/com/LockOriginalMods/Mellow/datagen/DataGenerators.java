package com.LockOriginalMods.Mellow.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

       generator.addProvider(true, new MellowRecipeProvider(packOutput));

        generator.addProvider(event.includeServer(), MellowLootTableProvider.create(packOutput));
        generator.addProvider(true, new MellowBlockStateProvider(packOutput, existingFileHelper));

         generator.addProvider(true, new MellowItemModelProvider(packOutput, fileHelper));
        generator.addProvider(event.includeServer(), new MellowGlobalLootModifiersProvider(packOutput));


        generator.addProvider(event.includeClient(), new MellowLangUsProvider(generator.getPackOutput()));
        generator.addProvider(event.includeClient(), new MellowLangRuProvider(generator.getPackOutput()));
       generator.addProvider(event.includeServer(), new MellowWorldGenProvider(packOutput, lookupProvider));

        MellowBlockTags blockTags = new MellowBlockTags(packOutput, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);

        generator.addProvider(event.includeServer(), new MellowItemTags(packOutput, lookupProvider, blockTags, event.getExistingFileHelper()));



    }
}









