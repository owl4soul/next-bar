package bar.products;

import java.util.HashMap;
import java.util.Map;

public class Ingredient extends Product {
    static Map<String, Ingredient> ingredientsNomenclature = new HashMap<>();

    public Ingredient() {

    }

    public Ingredient(IngredientBuilder ingredientBuilder) {
        this.name = ingredientBuilder.name;
        this.id = ingredientBuilder.id;
        this.cost = ingredientBuilder.cost;
    }

    public static Ingredient createIngredient() {
        return (Ingredient) new IngredientBuilder().addName("Spoom").addCost(899).addId(9).build();
    }


    @Override
    public Ingredient createProduct() {
        return createIngredient();
    }

    //SUB-BUILDER
    public static class IngredientBuilder extends Builder {
        @Override
        public Ingredient build() {
            return new Ingredient(this);
        }
    }
}
