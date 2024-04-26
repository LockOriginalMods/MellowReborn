package com.LockOriginalMods.Mellow.recipe;

import net.minecraft.core.RegistryAccess;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class MellowRecipe {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MOD_ID);

    public static final RegistryObject<RecipeSerializer<ElectricFurnaceRecipe>> ELECTRIC_FURNACE_SERIALIZER = SERIALIZERS.register("electric_furnace", ()->ElectricFurnaceRecipe.Serializer.INSTANCE);

    public static final RegistryObject<CrusherRecipe.Serializer> CRUSHER_SERIALIZER = SERIALIZERS.register("crusher", ()->CrusherRecipe.Serializer.INSTANCE);







    public static void register(IEventBus eventBus){
        SERIALIZERS.register(eventBus);
    }

}
