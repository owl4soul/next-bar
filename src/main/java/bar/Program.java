package bar;

import bar.products.*;
import bar.products.drinks.Drink;
import bar.tools.Calculator;

public class Program {
    static Stock generalStock;
    static DataBase generalDataBase;

    public static void main(String[] args) {
        init();

        Product ddd = new Drink.DrinkBuilder().addName("My coffee").addCost(99).setConsist(Recipe.LATTE).build();
        ((Drink) ddd).addAddition(Ingredient.SHOT, 333);

        ddd.show();

        System.out.println(generalStock.getStock().values());
        System.out.println(DataBase.getGrandMap());

        Product coff = Bar.orderByRecipe();
        System.out.println("________first instance_______");
        coff.show();
        Bar.orderAddition(coff);
//        coff = Bar.orderAddition(coff);

        System.out.println("________after modification______");
        coff.show();


//
//
//        Product d = new Drink.DrinkBuilder().addName("Latte-latte").addCost(12).setConsist(Recipe.LATTE).build();
//        ((Drink) d).addAddition(Ingredient.SHOT, 99);
//
//        System.out.println(DataBase.getGrandMap());
//
//        System.out.println(generalStock.getStock().toString());
//
//        Product dd = new Drink.DrinkBuilder().addName("Double espresso").addCost(12)
//                .setConsist(Recipe.DOPPIO).build();
//
//        System.out.println(dd);
//        System.out.println(generalStock.getStock().values());
//
//        Calculator.calcPrice(dd);
//
//        dd.toString();
//
//        dd.show();
//        System.out.println("_____________");
//        d.show();


    }

    public static void init() {
        generalStock = Stock.getGeneralStock();
        generalDataBase = new DataBase();
    }
}
