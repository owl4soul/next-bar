package bar.products;

import bar.Stock;
import bar.tools.Nomenclature;
import bar.tools.observatory.AbstractSubject;

import java.util.HashMap;
import java.util.Map;

public class Ingredient extends Product implements AbstractSubject, Nomenclature {
    static Map<String, Product> ingredients = new HashMap<>();
    public static final Ingredient SHOT = (Ingredient) new IngredientBuilder().addName("SHOT").addCost(8).build();
    public static final Ingredient MILK = (Ingredient) new IngredientBuilder().addName("MILK").addCost(8).build();



    public Ingredient(IngredientBuilder ingredientBuilder) {
        super(ingredientBuilder);
        Nomenclature.mapProduct(ingredients, this);
        AbstractSubject.super.notifyObserver(this);

    }

    public static Ingredient createIngredient(String name, int cost) {
        return (Ingredient) new IngredientBuilder().addName(name).addCost(cost).build();
    }


    //extends Product
    @Override
    public Ingredient createProduct(String name, int cost) {
        return createIngredient(name, cost);
    }
    /////////////

    //SUB-BUILDER
    public static class IngredientBuilder extends Builder {


        @Override
        public Ingredient build() {
            return new Ingredient(this);
        }
    }
    //////////



}
