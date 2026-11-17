package com.joy187.re8joymod.common.recipe;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.joy187.re8joymod.Utils;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class VirusGeneratorRecipe implements IRecipe<Inventory> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public VirusGeneratorRecipe(ResourceLocation id, ItemStack output,
                                NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }


    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

//    @Override
//    public ItemStack assemble(ItemStackHandler pContainer) {
//        return output;
//    }

    @Override
    public boolean matches(Inventory pContainer, World p_77569_2_) {
        return recipeItems.get(0).test(pContainer.getItem(1))
                && recipeItems.get(1).test(pContainer.getItem(0));
    }

    @Override
    public ItemStack assemble(Inventory p_77572_1_) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public IRecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements IRecipeType<VirusGeneratorRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "virus_generator";
    }

    public static class Serializer implements IRecipeSerializer<VirusGeneratorRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Utils.MOD_ID,"virus_generator");

        @Override
        public VirusGeneratorRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "output"));

            JsonArray ingredients = JSONUtils.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new VirusGeneratorRecipe(id, output, inputs);
        }

        @Override
        public VirusGeneratorRecipe fromNetwork(ResourceLocation id, PacketBuffer buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack output = buf.readItem();
            return new VirusGeneratorRecipe(id, output, inputs);
        }

        @Override
        public void toNetwork(PacketBuffer buf, VirusGeneratorRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }

        @Override
        public IRecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<IRecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(IRecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
