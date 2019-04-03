package bar;

import bar.products.*;
import bar.products.drinks.Drink;

public class Program {
    public static void main(String[] args) {
        Stock gen = Stock.getGeneralStock();
        DataBase db = new DataBase();



        Product d = new Drink.DrinkBuilder().addName("Latte-latte").addCost(12).setConsist(Recipe.LATTE).setNoWayAdd("SHOT").addAddition(Ingredient.SHOT, 99).build();

        System.out.println(DataBase.getGrandMap());

        System.out.println(gen.getStock().toString());

        Product dd = new Drink.DrinkBuilder().addName("Double espresso").addCost(12)
                .setConsist(Recipe.DOPPIO).build();

        System.out.println(dd);
        System.out.println(gen.getStock().values());



    }
}
