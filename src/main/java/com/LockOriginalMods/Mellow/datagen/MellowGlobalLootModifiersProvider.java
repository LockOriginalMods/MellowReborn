package com.LockOriginalMods.Mellow.datagen;

import com.LockOriginalMods.Mellow.Init.ItemInit;
import com.LockOriginalMods.Mellow.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;


public class MellowGlobalLootModifiersProvider  extends GlobalLootModifierProvider {
    public MellowGlobalLootModifiersProvider(PackOutput output) {
        super(output, MOD_ID);
    }

    @Override
    protected void start() {
        add("pine_cone_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ItemInit.BRONZE_INGOT.get()));


    }
}