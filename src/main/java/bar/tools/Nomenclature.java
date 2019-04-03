package bar.tools;

import bar.products.DataBase;
import bar.products.Product;

import java.util.HashMap;
import java.util.Map;

public interface Nomenclature {

    static void ADD_TO_GRAND_MAP(Product product) {
        String outerKey = product.getClass().getSimpleName();
        String innerKey = product.getName();
        if (DataBase.getGrandMap().containsKey(outerKey)) {
            DataBase.getGrandMap().get(outerKey).put(innerKey, product);
        } else {
            Map<String, Product> initialEntry = new HashMap<>();
            initialEntry.put(innerKey, product);
            DataBase.getGrandMap().put(outerKey, initialEntry);
        }
    }

    static void mapProduct(Map<String, Product> nomenclature, Product product) {
        nomenclature.put(product.getName(), product);
//        ADD_TO_GRAND_MAP(product);

    }


    default void showMap() {
        ////////////////////////////////////////////----------------
    }





//    void removeFromNomenclature();
//
//    void showNomenclature();

}
