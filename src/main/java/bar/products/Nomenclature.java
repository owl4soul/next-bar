package bar.products;

import java.util.HashMap;
import java.util.Map;

public interface Nomenclature {

    static void ADD_TO_GRAND_MAP(Product product) {
        String outerKey = product.getClass().getSimpleName();
        String innerKey = product.name;
        if (DataBase.GRAND_MAP.containsKey(outerKey)) {
            DataBase.GRAND_MAP.get(outerKey).put(innerKey, product);
        } else {
            Map<String, Product> initialEntry = new HashMap<>();
            initialEntry.put(innerKey, product);
            DataBase.GRAND_MAP.put(outerKey, initialEntry);
        }
    }

    static void mapProduct(Map<String, Product> nomenclature, Product product) {
        nomenclature.put(product.name, product);
        ADD_TO_GRAND_MAP(product);

    }

//    void removeFromNomenclature();
//
//    void showNomenclature();

}
