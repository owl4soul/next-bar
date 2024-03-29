package bar;

import bar.products.Ingredient;
import bar.products.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum Recipe {
    ESPRESSO(new RecipeBuilder().setNameRecipe("ESPRESSO").addToRecipe(Ingredient.SHOT, 1).setNoWayAdd()),
    DOPPIO(new RecipeBuilder().setNameRecipe("DOPPIO").addToRecipe(Ingredient.SHOT, 2).setNoWayAdd()),
    CAPPUCCINO(new RecipeBuilder().setNameRecipe("CAPPUCCINO").addToRecipe(Ingredient.SHOT, 2).addToRecipe(Ingredient.MILK, 3).setNoWayAdd()),
    LATTE(new RecipeBuilder().setNameRecipe("LATTE").addToRecipe(Ingredient.SHOT, 1).addToRecipe(Ingredient.MILK, 4).setNoWayAdd(Ingredient.SHOT));

    public String nameRecipe;
    public Map<Product, Integer> recipe;
    public ArrayList<Product> noWayAdd;

    Recipe(RecipeBuilder builder) {
        this.nameRecipe = builder.nameRecipe;
        this.recipe = builder.recipe;
        this.noWayAdd = builder.noWayAdd;
    }


    //BUILDER
    public static class RecipeBuilder {
        protected String nameRecipe;
        protected Map<Product, Integer> recipe = new HashMap<>();
        public ArrayList<Product> noWayAdd = new ArrayList<>();


        public RecipeBuilder setNameRecipe(String nameRecipe) {
            this.nameRecipe = nameRecipe;
            return this;
        }


        public RecipeBuilder setNoWayAdd(Product... productNames) {
            for (Product nameProduct : productNames) {
                noWayAdd.add(nameProduct);
            }
            return this;
        }

        public RecipeBuilder addToRecipe(Product product, int count) {
            recipe.put(product, count);
            return this;
        }

    }

}
