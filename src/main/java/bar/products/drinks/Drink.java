package bar.products.drinks;

import bar.Recipe;
import bar.products.Ingredient;
import bar.products.Product;
import bar.products.Production;
import bar.tools.Calculator;
import bar.tools.observatory.AbstractSubject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Drink extends Product implements Production, AbstractSubject {
    public Recipe drinkRecipe;
    public Map<Product, Integer> consist = new HashMap<>();


    public Drink(DrinkBuilder drinkBuilder) {
        super(drinkBuilder);
        this.drinkRecipe = drinkBuilder.drinkRecipe;
        this.consist = drinkBuilder.consist;
//        this.noWayAdd = drinkBuilder.noWayAdd;
        AbstractSubject.super.notifyObserver(this);
    }

    @Override
    public Product createProduct(String name, int cost) {
        return new DrinkBuilder().addName(name).addCost(cost).build();
    }

    //BUILDER
    public static class DrinkBuilder extends Builder {
        public Recipe drinkRecipe;
        public Map<Product, Integer> consist = new HashMap<>();
        public ArrayList<String> noWayAdd = new ArrayList<>();


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



//        public DrinkBuilder addAddition(Ingredient ingredient, int count) {
//            if (drinkRecipe.noWayAdd.contains(ingredient.getName())) {
//                System.out.println("В данный напиток нельзя добавить ингредиент: " + ingredient.getName());
//            } else {
//                int countPresent = consist.get(ingredient);
//                int countAdded = count;
//                int countUpdated = countPresent + countAdded;
//                consist.put(ingredient, countUpdated);
//            }
//            return this;
//        }

            @Override
            public Product build () {
                return new Drink(this);
            }
        }

        //Add addition to drink
        public Drink addAddition(Ingredient ingredient, int count) {
            if (this.drinkRecipe.noWayAdd.contains(ingredient)) {
                System.out.println("В данный напиток нельзя добавить ингредиент: " + ingredient.getName());
            } else {
                int countPresent = this.consist.get(ingredient);
                int countAdded = count;
                int countUpdated = countPresent + countAdded;
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
