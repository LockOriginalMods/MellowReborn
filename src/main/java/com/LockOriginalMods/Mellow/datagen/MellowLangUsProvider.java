package com.LockOriginalMods.Mellow.datagen;

import com.LockOriginalMods.Mellow.Registry;
import com.LockOriginalMods.Mellow.block.generator.GeneratorBlock;
import com.LockOriginalMods.Mellow.block.grinder.BlockEntityGrinder;
import com.LockOriginalMods.Mellow.block.grinder.BlockGrinder;
import com.LockOriginalMods.Mellow.block.grinder.ScreenGrinder;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class MellowLangUsProvider extends LanguageProvider {
    public MellowLangUsProvider(PackOutput output) {
        super(output, MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        /*add("item.mellow.battery","Battery";*/

        /*Items*/
        add("item.mellow.raw_aluminum","Raw aluminum");
        add("item.mellow.raw_zinc", "Raw zinc");
        add("item.mellow.zinc_ingot", "Zinc ingot");
        add("item.mellow.bronze_dust", "Bronze dust");
        add("item.mellow.zinc_dust", "Zinc dust");
        add("item.mellow.bronze_nugget", "Bronze nugget");
        add("item.mellow.bronze_ingot", "Bronze ingot");
        add("item.mellow.mortar","Mortar");
        add("item.mellow.hammer", "Hammer");
        add("item.mellow.cutter","Cutter");
        add("item.mellow.copper_wire", "Copper wire");
        add("item.mellow.flax_crop_seeds","Flax seeds");
        add("item.mellow.corn_seeds","Corn seeds");
        add("item.mellow.silicon", "Silicon");
        add("item.mellow.rubber","Rubber");
        add("item.mellow.graphene","Graphene");
        add("item.mellow.energy_crystal","Energy crystal");
        add("item.mellow.tin_plate","Tin plate");
        add("item.mellow.tin_ingot", "Tin ingot");
        add("item.mellow.raw_tin", "Raw tin");
        add("item.mellow.copper_plate","Copper plate");
        add("item.mellow.gold_plate","Gold plate");
        add("item.mellow.iron_plate", "Iron plate");
        add("item.mellow.brass_plate", "Brass plate");
        add("item.mellow.aluminum_plate", "Aluminum plate");
        add("item.mellow.aluminum_nugget","Aluminum nugget");
        add("item.mellow.tin_nugget","Tin nugget");
        add("item.mellow.brass_nugget","Brass nugget");
        add("item.mellow.brass_ingot","Brass ingot");
        add("item.mellow.steel_ingot","Steel ingot");
        add("item.mellow.aluminum_ingot","Aluminum ingot");
        add("item.mellow.advanced_alloy","Advanced alloy");
        add("item.mellow.tin_gear","Tin gear");
        add("item.mellow.iron_gear","Iron gear");
        add("item.mellow.gold_gear","Gold gear");
        add("item.mellow.copper_gear","Copper gear");
        add("item.mellow.aluminum_gear", "Aluminum gear");
        add("item.mellow.brass_gear","Brass gear");
        add("item.mellow.clay_dust", "Clay dust");
        add("item.mellow.mixed_metal_blend","Mixed Metal Blend");
        add("item.mellow.flax_fiber","Flax fiber");
        add("item.mellow.corn","corn");
        add("item.mellow.advanced_circuit","Advanced Circuit");
        add("item.mellow.electronic_circuit","Electronic Circuit");
        add("item.mellow.corn_oil","Corn Oil");
        add("item.mellow.resin","Resin");
        add("item.mellow.copper_nugget", "Copper nugget");
        /*Dusts*/
        add("item.mellow.aluminum_dust", "Aluminum dust");
        add("item.mellow.amethyst_dust", "Amethyst dust");
        add("item.mellow.brass_dust", "Brass dust");
        add("item.mellow.crushed_kelp","Crushed kelp");
        add("item.mellow.steel_dust","Steel dust");
        add("item.mellow.coal_dust", "Coal dust");
        add("item.mellow.copper_dust", "Copper dust");
        add("item.mellow.deepslate_dust", "Deepslate dust");
        add("item.mellow.gold_dust", "Gold dust");
        add("item.mellow.iron_dust", "Iron dust");
        add("item.mellow.stone_dust", "Stone dust");
        add("item.mellow.tin_dust","Tin dust");
        add("item.mellow.rubber_seeds","Rubber seeds");
        /*Blocks*/
        add("block.mellow.tin_block","Tin block");
        add("block.mellow.tin_ore", "Tin ore");
        add("block.mellow.rubber_crop","Rubber crop");
        add("block.mellow.raw_tin_block", "Raw tin block");
        add("block.mellow.deepslate_tin_ore", "Deepslate tin ore");
        add("block.mellow.zinc_ore", "Zinc ore");
        add("block.mellow.electric_furnace", "Electric furnace");
        add("block.mellow.deepslate_zinc_ore", "Deepslate zinc ore");
        add("block.mellow.aluminum_ore", "Aluminum ore");
        add("block.mellow.deepslate_aluminum_ore", "Deepslate aluminum ore");
        add(Registry.GENERATOR_BLOCK.get(), "Power Generator");
        add(Registry.CHARGER_BLOCK.get(), "Charger");
        add(Registry.CABLE_BLOCK.get(), "Cable");
        add(GeneratorBlock.SCREEN_MELLOW_GENERATOR, "Generator");
        add(Registry.GRINDER.get(), "Grinder");

        add(Registry.handle.get(), "Handle");
        add("block.mellow.rubber_sapling","Rubber sapling");
        add("block.mellow.rubber_wood","Rubber wood");
        add("block.mellow.rubber_log","Rubber log");
        add("block.mellow.stripped_rubber_log","Stripped rubber log");
        add("block.mellow.stripped_rubber_wood","Stripped rubber wood");

        add("block.mellow.rubber_leaves","Rubber leaves");
        add("block.mellow.rubber_stairs","Rubber stairs");
        add("block.mellow.rubber_planks","Rubber planks");
        add("block.mellow.rubber_slab","Rubber slab");

        add("block.mellow.full_rubber_wood","Full rubber wood");
        add("block.mellow.full_rubber_log","Full rubber log");
        add("block.mellow.full_stripped_rubber_log","Full stripped rubber log");
        add("block.mellow.full_stripped_rubber_wood","Full stripped rubber wood");

        add("tooltip.mellow.battery.txt.shift.1", "This battery can transfer %s/t.");
        add("tooltip.mellow.shift_details.txt", "Press [SHIFT] for details");
        add("tooltip.mellow.energy_meter.content.txt", "%s / %s");
        add("item.mellow.battery","Battery");
        addBlock(Registry.CHARGING_STATION, "Charging Station");
        add("itemGroup.mellow", "Charging Gad");
        add("screen.mellow.energy", "Energy: %s/%s FE");
        add("screen.mellow.no_fuel", "Fuel source empty");
        add("screen.mellow.burn_time", "Burn time left: %ss");
        /*Creative tab*/
        add("creative.mellow_tab", "Mellow");

    }
}
