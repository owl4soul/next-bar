package bar.products.drinks;

import bar.Recipe;
import bar.products.Ingredient;
import bar.products.Product;

import bar.tools.Calculator;
import bar.tools.observatory.AbstractSubject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Drink extends Product implements AbstractSubject {
    public Recipe drinkRecipe;
    public Map<Product, Integer> consist;


    public Drink(DrinkBuilder drinkBuilder) {
        super(drinkBuilder);
        this.drinkRecipe = drinkBuilder.drinkRecipe;
        this.consist = drinkBuilder.consist;

        AbstractSubject.super.notifyObserver(this); //TODO BUG IS HERE
    }


    //BUILDER
    public static class DrinkBuilder extends Builder {
        public Recipe drinkRecipe;
        public Map<Product, Integer> consist = new HashMap<>();
//        public ArrayList<String> noWayAdd = new ArrayList<>();


        public DrinkBuilder addName(String name) {
            return (DrinkBuilder) super.addName(name);
        }

        public DrinkBuilder addCost(int cost) {
            return (DrinkBuilder) super.addCost(cost);
        }


        public DrinkBuilder setConsist(Recipe recipe) {
            drinkRecipe = recipe;
            consist = recipe.recipe;
            return this;
        }

        @Override
        public Product build() {
            return new Drink(this);
        }
    }

    //Add addition to drink
    public Drink addAddition(Ingredient ingredient, int count) {
        if (this.drinkRecipe.noWayAdd.contains(ingredient)) {
            System.out.println("В данный напиток нельзя добавить ингредиент: " + ingredient.getName());
        } else {
            int countPrimordial = 0;
            if (this.consist.containsKey(ingredient)) {
                countPrimordial = this.consist.get(ingredient);
            }
            int countAdded = count;
            int countUpdated = countPrimordial + countAdded;
            this.consist.put(ingredient, countUpdated);
        }
        return this;
    }


    @Override
    public void show() {
        Product.showDefault(this);
        String s1 = "Напиток изготовлен по рецепту: " + this.drinkRecipe.nameRecipe + "\n";
        String s2 = "Полный состав напитка: " + this.consist + "\n";
        int fullPrice = Calculator.calcPrice(this);
        String s3 = "Итоговая стоимость напитка: " + fullPrice + "$" + "\n";
        System.out.println(s1 + s2 + s3);
    }

    @Override
    public String toString() {
        String output = super.toString() + " -> "
                + drinkRecipe.nameRecipe + ": "
                + consist + "]";
        return output;
    }
}
