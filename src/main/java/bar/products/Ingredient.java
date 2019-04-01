package bar.products;

import bar.Stock;
import bar.tools.Nomenclature;
import bar.tools.Stockable;
import bar.tools.observatory.AbstractSubject;
import bar.tools.observatory.Observer;
import bar.tools.observatory.Subject;

import java.util.HashMap;
import java.util.Map;

public class Ingredient extends Product implements AbstractSubject {
    {
        //register observers: generalStock;
        Stock generalStock = Stock.getGeneralStock();
        AbstractSubject.super.registerObserver(generalStock);
    }
    static Map<String, Product> ingredients = new HashMap<>();


    public Ingredient(IngredientBuilder ingredientBuilder) {
        this.name = ingredientBuilder.name;
        this.id = ingredientBuilder.id;
        this.cost = ingredientBuilder.cost;
        Nomenclature.mapProduct(ingredients, this);
        Nomenclature.ADD_TO_GRAND_MAP(this);
        AbstractSubject.super.notifyObserver(this);

    }

    public static Ingredient createIngredient(String name, int id, int cost) {
        return (Ingredient) new IngredientBuilder().addName(name).addCost(cost).addId(id).build();
    }


    //extends Product
    @Override
    public Ingredient createProduct(String name, int id, int cost) {
        return createIngredient(name, id, cost);
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
