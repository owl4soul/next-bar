package bar.products;

import bar.Stock;
import bar.tools.Nomenclature;
import bar.tools.observatory.AbstractSubject;

import java.util.HashMap;
import java.util.Map;

public class Ingredient extends Product implements AbstractSubject, Nomenclature {
    static Map<String, Product> ingredients = new HashMap<>();
    public static final Ingredient SHOT = (Ingredient) new IngredientBuilder().addName("SHOT").addCost(20).build();
    public static final Ingredient MILK = (Ingredient) new IngredientBuilder().addName("MILK").addCost(30).build();
    public static final Ingredient SUGAR = (Ingredient) new IngredientBuilder().addName("SUGAR").addCost(1).build();
    public static final Ingredient CINNAMON = (Ingredient) new IngredientBuilder().addName("CINNAMON").addCost(3).build();
    public static final Ingredient ICE = (Ingredient) new IngredientBuilder().addName("ICE").addCost(2).build();




    public Ingredient(IngredientBuilder ingredientBuilder) {
        super(ingredientBuilder);
        Nomenclature.mapProduct(ingredients, this);
        AbstractSubject.super.notifyObserver(this);

    }

    public static Ingredient createIngredient(String name, int cost) {
        return (Ingredient) new IngredientBuilder().addName(name).addCost(cost).build();
    }


    //extends Product which implements Production
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


    @Override
    public void show() {
        Product.showDefault(this);
        String s1 = "Стоимость ингредиента за единицу измерения: " + this.getCost() + "\n";
        System.out.println(s1);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
