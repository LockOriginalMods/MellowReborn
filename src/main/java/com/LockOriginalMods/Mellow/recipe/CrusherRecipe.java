package com.LockOriginalMods.Mellow.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import static com.LockOriginalMods.Mellow.Mellow.MOD_ID;

public class CrusherRecipe implements Recipe<SimpleContainer> {
private final ResourceLocation id;
private final ItemStack output;
private final NonNullList<Ingredient> recipeItems;

public CrusherRecipe(ResourceLocation id, ItemStack output,
        NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        }

@Override
public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
        return false;
        }

        return recipeItems.get(0).test(pContainer.getItem(1));
}

@Override
public ItemStack assemble(SimpleContainer pContainer, RegistryAccess p_267165_) {
        return output;
        }

@Override
public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
        }


@Override
public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
        }

@Override
public ItemStack getResultItem(RegistryAccess access) {
        return output.copy();
        }


public ItemStack getResult() {
        return output.copy();
        }

@Override
public ResourceLocation getId() {
        return id;
        }

@Override
public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
        }

@Override
public RecipeType<?> getType() {
        return Type.INSTANCE;
        }

public static class Type implements RecipeType<CrusherRecipe> {
    private Type() { }
    public static final CrusherRecipe.Type INSTANCE = new CrusherRecipe.Type();
    public static final String ID = "crusher";
}


public static class Serializer implements RecipeSerializer<CrusherRecipe> {
    public static final CrusherRecipe.Serializer INSTANCE = new CrusherRecipe.Serializer();
    public static final ResourceLocation ID =
            new ResourceLocation(MOD_ID, "crusher");

    @Override
    public CrusherRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
        ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));

        JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "input");
        NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);


        for (int i = 0; i < inputs.size(); i++) {
            inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
        }
        return new CrusherRecipe(pRecipeId, output, inputs);
    }

    @Override
    public @Nullable CrusherRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

        for (int i = 0; i < inputs.size(); i++) {
            inputs.set(i, Ingredient.fromNetwork(buf));
        }

        ItemStack output = buf.readItem();
        return new CrusherRecipe(id, output, inputs);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, CrusherRecipe recipe) {
        buf.writeInt(recipe.getIngredients().size());

        for (Ingredient ing : recipe.getIngredients()) {
            ing.toNetwork(buf);
        }
        buf.writeItemStack(recipe.getResult(), false);
    }
  }
 }