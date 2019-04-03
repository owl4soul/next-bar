package bar.products.drinks;

import bar.Recipe;
import bar.products.Ingredient;
import bar.products.Product;
import bar.products.Production;
import bar.tools.observatory.AbstractSubject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Drink extends Product implements Production, AbstractSubject {
    public Map<Product, Integer> consist = new HashMap<>();
    public ArrayList<String> noWayAdd = new ArrayList<>();


    public Drink(DrinkBuilder drinkBuilder) {
        super(drinkBuilder);
        this.consist = drinkBuilder.consist;
        this.noWayAdd = drinkBuilder.noWayAdd;
        AbstractSubject.super.notifyObserver(this);
    }

    @Override
    public Product createProduct(String name, int cost) {
        return new DrinkBuilder().addName(name).addCost(cost).build();
    }

    //BUILDER
    public static class DrinkBuilder extends Builder {
        public Map<Product, Integer> consist = new HashMap<>();
        public ArrayList<String> noWayAdd = new ArrayList<>();


        public DrinkBuilder addName(String name) {
            return (DrinkBuilder) super.addName(name);
        }

        public DrinkBuilder addCost(int cost) {
            return (DrinkBuilder) super.addCost(cost);
        }

        public DrinkBuilder setConsist(Recipe recipe) {
            consist = recipe.recipe;
            return this;
        }

        public DrinkBuilder setNoWayAdd(String... productNames) {
            for (String nameProduct : productNames) {
                noWayAdd.add(nameProduct);
            }
            return this;
        }

        public DrinkBuilder addAddition(Ingredient ingredient, int count) {
            if (noWayAdd.contains(ingredient.getName())) {
                System.out.println("В данный напиток нельзя добавить ингредиент: " + ingredient.getName());
            } else {
                int countPresent = consist.get(ingredient);
                int countAdded = count;
                int countUpdated = countPresent + countAdded;
                consist.put(ingredient, countUpdated);
            }
            return this;
        }

            @Override
            public Product build () {
                return new Drink(this);
            }
        }

    }
