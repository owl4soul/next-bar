package bar;

import bar.products.Product;
import bar.products.Production;

import java.util.HashMap;
import java.util.Map;

public abstract class Recipe implements Production {
    String nameRecipe;
    Map<Product, Integer> consist;

    static Map<String, Recipe> recipeBook = new HashMap<>();


    private Recipe(RecipeBuilder builder) {
//        this.nameRecipe = builder.nameRecipe;
        this.consist.putAll(builder.consist);

        recipeBook.put("default", this);
    }

//    static generation method of Recipe's objects
//    public static Recipe getInstance() {
//
//    }



    //BUILDER
    public abstract static class RecipeBuilder {
        protected String nameRecipe;
        protected Map<Product, Integer> consist = new HashMap<>();

        public RecipeBuilder setNameRecipe(String nameRecipe) {
            this.nameRecipe = nameRecipe;
            return this;
        }



        public RecipeBuilder addToConsist(Product product, int count) {
            consist.put(product, count);
            return this;
        }

        public abstract Production build();

    }



}
