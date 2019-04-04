package bar;

import bar.products.*;
import bar.products.drinks.Drink;
import bar.tools.Calculator;

public class Program {
    public static void main(String[] args) {
        Stock gen = Stock.getGeneralStock();
        DataBase db = new DataBase();






        Product d = new Drink.DrinkBuilder().addName("Latte-latte").addCost(12).setConsist(Recipe.LATTE).build();
        ((Drink) d).addAddition(Ingredient.SHOT, 99);

        System.out.println(DataBase.getGrandMap());

        System.out.println(gen.getStock().toString());

        Product dd = new Drink.DrinkBuilder().addName("Double espresso").addCost(12)
                .setConsist(Recipe.DOPPIO).build();

        System.out.println(dd);
        System.out.println(gen.getStock().values());

        Calculator.calcPrice(dd);

        dd.toString();

        dd.show();
        System.out.println("_____________");
        d.show();


    }

    public static void init() {
        Stock gen = Stock.getGeneralStock();
        DataBase db = new DataBase();
    }
}
