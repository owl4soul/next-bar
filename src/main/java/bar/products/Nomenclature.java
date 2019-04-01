package bar.products;

import java.util.HashMap;
import java.util.Map;

public interface Nomenclature {

    static void ADD_TO_GRAND_MAP(Map<String, Product> nomenclature, Product product) {
        String outerKeyClassName = product.getClass().getSimpleName();

        DataBase.GRAND_MAP.put(outerKeyClassName, nomenclature);
    }

    static void mapProduct(Map<String, Product> nomenclature, Product product) {
        nomenclature.put(product.name, product);
        ADD_TO_GRAND_MAP(nomenclature, product);

    }

//    void removeFromNomenclature();
//
//    void showNomenclature();

}
