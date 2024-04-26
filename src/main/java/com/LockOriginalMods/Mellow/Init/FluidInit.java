package com.LockOriginalMods.Mellow.Init;

import com.LockOriginalMods.Mellow.utils.FluidRegistryContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class FluidInit {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(
            ForgeRegistries.Keys.FLUID_TYPES, MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS,
            MOD_ID);

    public static final FluidRegistryContainer LATEX = new FluidRegistryContainer("latex",
            FluidType.Properties.create().canSwim(false).canDrown(true).canPushEntity(true).supportsBoating(false)
                    .canConvertToSource(false).density(4300).viscosity(4600).temperature(285),
            () -> FluidRegistryContainer.createExtension(
                    new FluidRegistryContainer.ClientExtensions(MOD_ID, "latex").overlay("latex")),
            BlockBehaviour.Properties.copy(Blocks.WATER), new Item.Properties().stacksTo(1));
}