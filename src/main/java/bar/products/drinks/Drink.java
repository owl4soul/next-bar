package bar.products.drinks;

import bar.Recipe;
import bar.products.Ingredient;
import bar.products.Product;
import bar.products.Production;

import java.util.HashMap;
import java.util.Map;

public class Drink extends Product implements Production {
//    {
//        Drink d = (Drink) new DrinkBuilder("G", 9, 88).addToConsist(Ingredient.SHOT, 2).build();
//        System.out.println(d);
//    }

    protected Map<Product, Integer> consist = new HashMap<>();

//    public Drink(String name, int id, int cost) {
//        this.name = name;
//        this.id = id;
//        this.cost = cost;
//    }

    public Drink(DrinkBuilder drinkBuilder) {
        this.name = drinkBuilder.name;
        this.id = drinkBuilder.id;
        this.cost = drinkBuilder.cost;
//        this.consist = drinkBuilder.consist;
    }

    @Override
    public Product createProduct(String name, int id, int cost) {
        return new DrinkBuilder(name, id, cost).build();
    }

    //BUILDER
    public static class DrinkBuilder extends Recipe.RecipeBuilder {
        public String name;
        public int id;
        public int cost;
        Map<Product, Integer> consist = new HashMap<>();

        public DrinkBuilder(String name, int id, int cost) {
            this.name = name;
            this.id = id;
            this.cost = cost;
        }

        public Product build() {
            return new Drink(this);
        }

    }


}
