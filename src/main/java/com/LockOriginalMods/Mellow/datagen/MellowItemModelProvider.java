package com.LockOriginalMods.Mellow.datagen;

import com.LockOriginalMods.Mellow.Init.ItemInit;
import com.LockOriginalMods.Mellow.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;
import java.util.function.Supplier;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class MellowItemModelProvider extends ItemModelProvider {
    public MellowItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MOD_ID, existingFileHelper);
    }
    @Override
    public String getName() {
        return "Mellow Item Models";
    }

    @Override
    protected void registerModels() {
        rawItem(ItemInit.RAW_TIN);
        ingotItem(ItemInit.TIN_INGOT);
        dustItem(ItemInit.ALUMINIUM_DUST);
        dustItem(ItemInit.TIN_DUST);
        dustItem(ItemInit.AMETHYST_DUST);
        dustItem(ItemInit.COAL_DUST);
        dustItem(ItemInit.COPPER_DUST);
        dustItem(ItemInit.IRON_DUST);
        dustItem(ItemInit.BRASS_DUST);
        dustItem(ItemInit.GOLD_DUST);
        dustItem(ItemInit.DEEPSLATE_DUST);
        dustItem(ItemInit.STONE_DUST);
        bottleItem(ItemInit.CORN_OIL);
        circuitItem(ItemInit.ADVANCED_CIRCUIT);
        circuitItem(ItemInit.ELECTRONIC_CIRCUIT);
        cropItem(ItemInit.CORN);
        cropItem(ItemInit.FLAX_FIBER);
        dustItem(ItemInit.MIXED_METAL_BLEND);
        dustItem(ItemInit.CLAY_DUST);
        gearItem(ItemInit.ALUMINUM_GEAR);
        gearItem(ItemInit.GOLD_GEAR);
        gearItem(ItemInit.BRASS_GEAR);
        gearItem(ItemInit.IRON_GEAR);
        gearItem(ItemInit.TIN_GEAR);
        gearItem(ItemInit.COPPER_GEAR);
        ingotItem(ItemInit.ALUMINUM_INGOT);
        ingotItem(ItemInit.ADVANCED_ALLOY);
        ingotItem(ItemInit.STEEL_INGOT);
        ingotItem(ItemInit.BRASS_INGOT);
        nuggetItem(ItemInit.ALUMINUM_NUGGET);
        nuggetItem(ItemInit.BRASS_NUGGET);
        nuggetItem(ItemInit.TIN_NUGGET);
        nuggetItem(ItemInit.COPPER_NUGGET);
        plateItem(ItemInit.ALUMINUM_PLATE);
        plateItem(ItemInit.BRASS_PLATE);
        plateItem(ItemInit.COPPER_PLATE);
        plateItem(ItemInit.IRON_PLATE);
        plateItem(ItemInit.TIN_PLATE);
        plateItem(ItemInit.GOLD_PLATE);
        resourcesItem(ItemInit.ENERGY_CRYSTAL);
        resourcesItem(ItemInit.GRAPHENE);
        resourcesItem(ItemInit.RUBBER);
        resourcesItem(ItemInit.SILICON);
        seedsItem(ItemInit.CORN_SEEDS);
        seedsItem(ItemInit.FLAX_CROP_SEEDS);
        toolsItem(ItemInit.CUTTER);
        toolsItem(ItemInit.MORTAR);
        toolsItem(ItemInit.HAMMER);
        wireItem(ItemInit.COPPER_WIRE);
        resourcesItem(ItemInit.CRUSHED_KELP);
        dustItem(ItemInit.STEEL_DUST);
        rawItem(ItemInit.RAW_ALUMINUM);
        rawItem(ItemInit.RAW_ZINC);
        ingotItem(ItemInit.ZINC_INGOT);
        ingotItem(ItemInit.BRONZE_INGOT);
        dustItem(ItemInit.BRONZE_DUST);
        nuggetItem(ItemInit.BRONZE_NUGGET);
        dustItem(ItemInit.ZINC_DUST);
        withExistingParent(Registry.GENERATOR_BLOCK.getId().getPath(), modLoc("block/generator_block_off"));
        withExistingParent(Registry.CHARGER_BLOCK.getId().getPath(), modLoc("block/charger_block_on"));
        batteryItem(ItemInit.BATTERY);
        rubberseedItem(ItemInit.RUBBER_SEEDS);
        withExistingParent(Registry.CABLE_BLOCK.getId().getPath(), modLoc("block/cable"));
        withExistingParent(Registry.FACADE_BLOCK.getId().getPath(), modLoc("block/facade"));
    }


    private ItemModelBuilder ingotItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/ingot/" + item.getId().getPath()));
    }

    private ItemModelBuilder dustItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/dust/" + item.getId().getPath()));
    }

    private ItemModelBuilder batteryItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/battery/" + item.getId().getPath()));
    }

    private ItemModelBuilder bottleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/bottle/" + item.getId().getPath()));
    }

    private ItemModelBuilder circuitItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/circuit/" + item.getId().getPath()));
    }

    private ItemModelBuilder cropItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/crop/" + item.getId().getPath()));
    }

    private ItemModelBuilder gearItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/gear/" + item.getId().getPath()));
    }

    private ItemModelBuilder nuggetItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/nugget/" + item.getId().getPath()));
    }

    private ItemModelBuilder plateItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/plate/" + item.getId().getPath()));
    }

    private ItemModelBuilder rawItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/raw/" + item.getId().getPath()));
    }

    private ItemModelBuilder resourcesItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/resources/" + item.getId().getPath()));
    }

    private ItemModelBuilder seedsItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/seeds/" + item.getId().getPath()));
    }

    private ItemModelBuilder toolsItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/tools/" + item.getId().getPath()));
    }

    private ItemModelBuilder wireItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/wire/" + item.getId().getPath()));
    }




    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/" + item.getId().getPath()));


    }

    private ItemModelBuilder rubberseedItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MOD_ID,"item/" + item.getId().getPath()));


    }


}


