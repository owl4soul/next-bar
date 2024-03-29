package bar.products;

import bar.tools.Nomenclature;
import bar.tools.observatory.AbstractSubject;
import bar.tools.observatory.Observer;

import java.util.HashMap;
import java.util.Map;

public class DataBase implements Observer, AbstractSubject {
    static Map<String, Map<String, Product>> GRAND_MAP = new HashMap<>();

    public DataBase() {
        //registration as observer
        AbstractSubject.super.registerObserver(this);
    }

    public static Map<String, Map<String, Product>> getGrandMap() {
        return GRAND_MAP;
    }

    @Override
    public void update(Product product) {
        String productName = product.getName();
        if (productName != "NULL") {
            System.out.println("Новый продукт добавлен в базу данных: " + productName);
            Nomenclature.ADD_TO_GRAND_MAP(product);
        }
    }
}
