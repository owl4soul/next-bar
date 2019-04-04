package bar;

import bar.products.*;
import bar.products.drinks.Drink;

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

        System.out.println("________after modification______");
        coff.show();

        System.out.println("______stock show values______");
        System.out.println(generalStock.getStock().values());
    }

    public static void init() {
        generalStock = Stock.getGeneralStock();
        generalDataBase = new DataBase();
    }
}
