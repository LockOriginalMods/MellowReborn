package com.LockOriginalMods.Mellow.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class MellowItemTags extends ItemTagsProvider {

    public MellowItemTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, ExistingFileHelper helper) {
        super(packOutput, lookupProvider, blockTags.contentsGetter(), MOD_ID, helper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}


