package bar;

import bar.products.Ingredient;
import bar.products.Product;
import bar.products.drinks.Drink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Recipe {
    static Map<String, Recipe> recipeBook = new HashMap<>(); //Consist all recipes

    public String nameRecipe;
    public Map<Product, Integer> recipe;
    public ArrayList<String> noWayAdd = new ArrayList<>();

    public static final Recipe ESPRESSO = new RecipeBuilder().setNameRecipe("ESPRESSO").addToRecipe(Ingredient.SHOT, 1).build();
    public static final Recipe DOPPIO = new RecipeBuilder().setNameRecipe("DOPPIO").addToRecipe(Ingredient.SHOT, 2).build();
    public static final Recipe CAPPUCCINO = new RecipeBuilder().setNameRecipe("CAPPUCCINO").addToRecipe(Ingredient.SHOT, 2).build();
    public static final Recipe LATTE = new RecipeBuilder().setNameRecipe("LATTE").addToRecipe(Ingredient.SHOT, 2).addToRecipe(Ingredient.MILK, 3).setNoWayAdd("SHOT").build(); //TODO change noWay




    private Recipe(RecipeBuilder builder) {
        this.nameRecipe = builder.nameRecipe;
        this.recipe = builder.recipe;
        this.noWayAdd = builder.noWayAdd;

        recipeBook.put("default", this);
    }


    //BUILDER
    public static class RecipeBuilder {
        protected String nameRecipe;
        protected Map<Product, Integer> recipe = new HashMap<>();
        public ArrayList<String> noWayAdd = new ArrayList<>();


        public RecipeBuilder setNameRecipe(String nameRecipe) {
            this.nameRecipe = nameRecipe;
            return this;
        }


        public RecipeBuilder addToRecipe(Product product, int count) {
            recipe.put(product, count);
            return this;
        }

        public RecipeBuilder setNoWayAdd(String... productNames) {
            for (String nameProduct : productNames) {
                noWayAdd.add(nameProduct);
            }
            return this;
        }

        public Recipe build() {
            return new Recipe(this);
        }

    }


}
