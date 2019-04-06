package bar;

import bar.products.*;
import bar.products.drinks.Drink;

public class Program {
    static Stock generalStock;
    static DataBase generalDataBase;
    static Bar bar;

    public static void main(String[] args) {
        init();

        Product ddd = bar.createDrink();

        ddd.show();

        System.out.println(generalStock.getStock().values());
        generalStock.showStock();
        System.out.println(DataBase.getGrandMap());

        Product coff = bar.createDrink();

        System.out.println("________after modification______");
        coff.show();

        System.out.println("______stock show values______");
        System.out.println(generalStock.getStock().values());
        generalStock.showStock();
        System.out.println(DataBase.getGrandMap());
    }

    public static void init() {
        generalStock = Stock.getGeneralStock();
        generalDataBase = new DataBase();
        bar = new Bar();
    }
}
