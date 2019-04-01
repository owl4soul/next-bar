package bar;

import bar.products.Product;
import bar.tools.Stockable;
import bar.tools.Tools;
import bar.tools.observatory.Observer;

import java.util.HashMap;
import java.util.Map;

public class Stock implements Stockable, Observer {
    private Map<String, Integer> stock = new HashMap<>();// String productName = Integer countInStock

    public static Stock generalStock = getInstance();



    //PRIVATE CONSTRUCTOR
    public Stock() {

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
        String productName = product.getName();
        System.out.println("В перечне появился новый продукт: " + productName);
        System.out.println("Введите его изначальное количество на складе: ");
        int count = Tools.readInteger();
        stock.put(productName, count);
    }
}
