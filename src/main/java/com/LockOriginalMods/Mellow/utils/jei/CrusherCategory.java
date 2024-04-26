package com.LockOriginalMods.Mellow.utils.jei;

import com.LockOriginalMods.Mellow.Init.BlockInit;
import com.LockOriginalMods.Mellow.recipe.CrusherRecipe;
import com.LockOriginalMods.Mellow.recipe.ElectricFurnaceRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class CrusherCategory implements IRecipeCategory<CrusherRecipe> {

    public final static ResourceLocation UID = new ResourceLocation(MOD_ID, "crusher");
    public final static ResourceLocation TEXTURE = new ResourceLocation(MOD_ID, "textures/gui/crusher_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CrusherCategory(IGuiHelper helper){
        this.background = helper.createDrawable(TEXTURE, 0, 0,176, 86);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockInit.CRUSHER.get()));
    }

    @Override
    public RecipeType<CrusherRecipe> getRecipeType() {
        return PluginJEI.CRUSHER_TYPE;
    }

    /**
     * Returns a text component representing the name of this recipe type.
     * Drawn at the top of the recipe GUI pages for this category.
     *
     * @since 7.6.4
     */
    @Override
    public Component getTitle() {
        return Component.literal("Crusher");
    }

    /**
     * Returns the drawable background for a single recipe in this category.
     */
    @Override
    public IDrawable getBackground() {
        return this.background;
    }


    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    /**
     * Sets all the recipe's ingredients by filling out an instance of {@link IRecipeLayoutBuilder}.
     * This is used by JEI for lookups, to figure out what ingredients are inputs and outputs for a recipe.
     *
     * @param builder
     * @param recipe
     * @param focuses
     * @since 9.4.0
     */
    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CrusherRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResult());
    }
}
