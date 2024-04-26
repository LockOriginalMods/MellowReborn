package com.LockOriginalMods.Mellow.utils.jei;

import com.LockOriginalMods.Mellow.Registry;
import com.LockOriginalMods.Mellow.block.grinder.GrindRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class RecipeCat implements IRecipeCategory<GrindRecipe> {

    public static final ResourceLocation ID = new ResourceLocation(Registry.GRINDER_RECIPE_TYPE.getId().toString());
    private IDrawable gui;
    private IDrawable icon;

    public RecipeCat(IGuiHelper helper) {
        gui = helper.drawableBuilder(new ResourceLocation(MOD_ID, "textures/gui/jei.png"), 0, 0, 169, 69).setTextureSize(169, 69).build();
        icon = helper.drawableBuilder(new ResourceLocation(MOD_ID, "textures/block/grinder_top.png"), 0, 0, 16, 16).setTextureSize(16, 16).build();
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public IDrawable getBackground() {
        return gui;
    }

    @Override
    public Component getTitle() {
        return Component.translatable(Registry.GRINDER.get().getDescriptionId());
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, GrindRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 4, 19).addIngredients(recipe.getInput());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 19).addItemStack(recipe.getResultForDisplay());
    }

    @Override
    public RecipeType<GrindRecipe> getRecipeType() {
        return PluginJEI.recipeTypeJei;
    }
}