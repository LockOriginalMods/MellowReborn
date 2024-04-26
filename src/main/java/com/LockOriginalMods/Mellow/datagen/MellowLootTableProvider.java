package com.LockOriginalMods.Mellow.datagen;

import com.LockOriginalMods.Mellow.Init.ItemInit;
import com.LockOriginalMods.Mellow.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.List;
import java.util.Set;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;



public class MellowLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(MellowBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}