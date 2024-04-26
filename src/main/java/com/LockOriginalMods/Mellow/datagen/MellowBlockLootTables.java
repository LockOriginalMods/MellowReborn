package com.LockOriginalMods.Mellow.datagen;

import com.LockOriginalMods.Mellow.Init.BlockInit;
import com.LockOriginalMods.Mellow.Init.ItemInit;
import com.LockOriginalMods.Mellow.Registry;
import com.LockOriginalMods.Mellow.block.RubberCropBlock.RubberCropBlock;
import com.LockOriginalMods.Mellow.block.cables.CableBlockEntity;
import com.LockOriginalMods.Mellow.block.cables.FacadeBlockEntity;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetContainerContents;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

public class MellowBlockLootTables extends BlockLootSubProvider {

    protected MellowBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }



    @Override
    protected void generate() {
        dropSelf(BlockInit.TIN_BLOCK.get());
        dropSelf(BlockInit.RAW_TIN_BLOCK.get());
        dropSelf(BlockInit.Electric_Furnace.get());
        dropSelf(BlockInit.CRUSHER.get());

        add(BlockInit.DEEPSLATE_TIN_ORE.get(),(block -> createOreDrop(BlockInit.DEEPSLATE_TIN_ORE.get(), ItemInit.RAW_TIN.get())));
        add(BlockInit.TIN_ORE.get(),(block -> createOreDrop(BlockInit.TIN_ORE.get(), ItemInit.RAW_TIN.get())));
        add(BlockInit.DEEPSLATE_ZINC_ORE.get(),(block -> createOreDrop(BlockInit.DEEPSLATE_ZINC_ORE.get(), ItemInit.RAW_ZINC.get())));
        add(BlockInit.ZINC_ORE.get(),(block -> createOreDrop(BlockInit.ZINC_ORE.get(), ItemInit.RAW_ZINC.get())));
        add(BlockInit.DEEPSLATE_ALUMINUM_ORE.get(),(block -> createOreDrop(BlockInit.DEEPSLATE_ALUMINUM_ORE.get(), ItemInit.RAW_ALUMINUM.get())));
        add(BlockInit.ALUMINUM_ORE.get(),(block -> createOreDrop(BlockInit.ALUMINUM_ORE.get(), ItemInit.RAW_ALUMINUM.get())));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(BlockInit.RUBBER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RubberCropBlock.AGE, 5));

        this.add(BlockInit.RUBBER_CROP.get(), createCropDrops(BlockInit.RUBBER_CROP.get(), ItemInit.RESIN.get(),
                ItemInit.RUBBER_SEEDS.get(), lootitemcondition$builder));

    }



    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
         return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
