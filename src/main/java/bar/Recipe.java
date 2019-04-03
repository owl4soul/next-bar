package bar;

import bar.products.Ingredient;
import bar.products.Product;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    static Map<String, Recipe> recipeBook = new HashMap<>(); //Consist all recipes

    public String nameRecipe;
    public Map<Product, Integer> recipe;

    public static final Recipe ESPRESSO = new RecipeBuilder().setNameRecipe("espresso").addToRecipe(Ingredient.SHOT, 1).build();
    public static final Recipe DOPPIO = new RecipeBuilder().setNameRecipe("espresso").addToRecipe(Ingredient.SHOT, 2).build();



    private Recipe(RecipeBuilder builder) {
        this.nameRecipe = builder.nameRecipe;
        this.recipe = builder.recipe;

        recipeBook.put("default", this);
    }


    //BUILDER
    public static class RecipeBuilder {
        protected String nameRecipe;
        protected Map<Product, Integer> recipe = new HashMap<>();

        public RecipeBuilder setNameRecipe(String nameRecipe) {
            this.nameRecipe = nameRecipe;
            return this;
        }


        public RecipeBuilder addToRecipe(Product product, int count) {
            recipe.put(product, count);
            return this;
        }

        public Recipe build() {
            return new Recipe(this);
        }

    }


}
