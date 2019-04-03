package bar;

import bar.products.Ingredient;
import bar.products.Product;
import bar.products.drinks.Drink;
import bar.tools.Stockable;
import bar.tools.Tools;
import bar.tools.observatory.AbstractSubject;
import bar.tools.observatory.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Stock implements Stockable, Observer, AbstractSubject {

    public Map<String, Integer> stock = new HashMap<>();// String productName = Integer countInStock

    public static Stock generalStock = getInstance();


    //PRIVATE CONSTRUCTOR
    public Stock() {
        AbstractSubject.super.registerObserver(this);         //register observers: generalStock;

    }

    //Static initialization
    public static Stock getInstance() {

        return new Stock();
    }

    public static Stock getGeneralStock() {
        return generalStock;
    }


    public Map<String, Integer> getStock() {
        return stock;
    }

    //implements Observer

    @Override
    public void update(Product product) {
        if (product instanceof Ingredient) {
            String productName = product.getName();
            System.out.println("В перечне появился новый продукт: " + productName);
            System.out.println("Введите его изначальное количество на складе: ");
            int count = Tools.readInteger();
//            Stockable.addCountToStock(generalStock, product, count);
            stock.put(productName, count);
        } else if (product instanceof Drink) {
            System.out.println("Создан новый напиток");
            Stockable.removeFromStock(generalStock, product);


        }
    }
}

