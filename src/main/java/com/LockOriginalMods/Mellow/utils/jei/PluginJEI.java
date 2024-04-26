package com.LockOriginalMods.Mellow.utils.jei;

import java.util.List;
import java.util.Objects;

import com.LockOriginalMods.Mellow.Registry;
import com.LockOriginalMods.Mellow.block.grinder.GrindRecipe;
import com.LockOriginalMods.Mellow.block.grinder.ScreenGrinder;
import com.LockOriginalMods.Mellow.recipe.CrusherRecipe;
import com.LockOriginalMods.Mellow.recipe.ElectricFurnaceRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.item.crafting.RecipeManager;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

@JeiPlugin
public class PluginJEI implements IModPlugin {

    private static final ResourceLocation ID = new ResourceLocation(MOD_ID, "jei");

    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }

    public static RecipeType<ElectricFurnaceRecipe> ELECTRIC_FURNACE_TYPE = new RecipeType<>(ElectricFurnaceCategory.UID, ElectricFurnaceRecipe.class);
    public static RecipeType<CrusherRecipe> CRUSHER_TYPE = new RecipeType<>(CrusherCategory.UID, CrusherRecipe.class);

    static RecipeType<GrindRecipe> recipeTypeJei = RecipeType.create(MOD_ID, "grinder", GrindRecipe.class);

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(Registry.igrinder.get()), recipeTypeJei);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(new RecipeCat(guiHelper));
        registry.addRecipeCategories(new ElectricFurnaceCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new CrusherCategory(registry.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        assert recipeTypeJei != null;

        registry.addRecipes(recipeTypeJei, List.copyOf(GrindRecipe.RECIPES));

        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<ElectricFurnaceRecipe> electric_furnace = rm.getAllRecipesFor(ElectricFurnaceRecipe.Type.INSTANCE);
        registry.addRecipes(ELECTRIC_FURNACE_TYPE, electric_furnace);

        List<CrusherRecipe> crusher = rm.getAllRecipesFor(CrusherRecipe.Type.INSTANCE);
        registry.addRecipes(CRUSHER_TYPE, crusher);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registry) {
        registry.addRecipeClickArea(ScreenGrinder.class,
                72, 10,
                34, 36, recipeTypeJei);
    }
    //?? its gone. ok so its broken?
    //  @Override
    //  public void registerRecipeTransferHandlers(IRecipeTransferRegistration registry) {
    //    registry.addRecipeTransferHandler(ContainerGrinder.class, WTFISTHIS,
    //        0, 1, //recipeSLotStart, recipeSlotCount
    //        1, PLAYER_INV_SIZE); // inventorySlotStart, inventorySlotCount
    //  }
}
