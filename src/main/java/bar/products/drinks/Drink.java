package bar.products.drinks;

import bar.Recipe;
import bar.products.Ingredient;
import bar.products.Product;
import bar.products.Production;
import bar.tools.observatory.AbstractSubject;

import java.util.HashMap;
import java.util.Map;

public class Drink extends Product implements Production, AbstractSubject {
    public Map<Product, Integer> consist = new HashMap<>();


    public Drink(DrinkBuilder drinkBuilder) {
        super(drinkBuilder);//todo or variables need to be put as args?
        this.consist = drinkBuilder.consist;
        AbstractSubject.super.notifyObserver(this);
    }

    @Override
    public Product createProduct(String name, int id, int cost) {
        return new DrinkBuilder().addName(name).addId(id).addCost(cost).build();
    }

    //BUILDER
    public static class DrinkBuilder extends Builder {
        public Map<Product, Integer> consist = new HashMap<>();

        public DrinkBuilder addName(String name) {
            return (DrinkBuilder) super.addName(name);
        }

        public DrinkBuilder addId(int id) {
            return (DrinkBuilder) super.addId(id);
        }
        public DrinkBuilder addCost(int cost) {
            return (DrinkBuilder) super.addCost(cost);
        }

        public DrinkBuilder setConsist(Recipe recipe) {
            consist = recipe.recipe;
            return this;
        }

        public Product build() {
            return new Drink(this);
        }

    }


}
