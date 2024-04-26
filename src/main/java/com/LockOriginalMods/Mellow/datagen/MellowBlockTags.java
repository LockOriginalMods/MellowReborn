package com.LockOriginalMods.Mellow.datagen;

import com.LockOriginalMods.Mellow.Init.BlockInit;
import com.LockOriginalMods.Mellow.Registry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;
import static net.minecraft.tags.TagEntry.tag;

public class MellowBlockTags extends BlockTagsProvider {

    public MellowBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(Registry.RUBBER_LOG.get(),Registry.RUBBER_WOOD.get(),Registry.FULL_RUBBER_LOG.get(),Registry.FULL_RUBBER_WOOD.get(),Registry.FULL_STRIPPED_RUBBER_LOG.get(),Registry.FULL_STRIPPED_RUBBER_WOOD.get());
        tag(BlockTags.LOGS)
                .add(Registry.RUBBER_LOG.get());
        tag(BlockTags.LOGS)
                .add(Registry.FULL_RUBBER_LOG.get());
        tag(BlockTags.LEAVES)
                .add(Registry.RUBBER_LEAVES.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registry.GENERATOR_BLOCK.get(), Registry.CHARGER_BLOCK.get(), BlockInit.TIN_BLOCK.get(), BlockInit.RAW_TIN_BLOCK.get(), BlockInit.DEEPSLATE_TIN_ORE.get(),BlockInit.ALUMINUM_ORE.get(),BlockInit.DEEPSLATE_ALUMINUM_ORE.get(),BlockInit.ZINC_ORE.get(),BlockInit.DEEPSLATE_ZINC_ORE.get(),Registry.GRINDER.get(),Registry.handle.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(Registry.GENERATOR_BLOCK.get(), Registry.CHARGER_BLOCK.get());
        tag(BlockTags.NEEDS_STONE_TOOL).add(BlockInit.TIN_BLOCK.get(),BlockInit.RAW_TIN_BLOCK.get(),BlockInit.DEEPSLATE_TIN_ORE.get(),BlockInit.ALUMINUM_ORE.get(),BlockInit.DEEPSLATE_ALUMINUM_ORE.get(),BlockInit.ZINC_ORE.get(),BlockInit.DEEPSLATE_ZINC_ORE.get(),Registry.GRINDER.get(),Registry.handle.get());
    }
}

