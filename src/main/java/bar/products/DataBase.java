package bar.products;

import java.util.HashMap;
import java.util.Map;

public abstract class DataBase {
        static Map<String, Map<String, Product>> GRAND_MAP = new HashMap<>();

    public static Map<String, Map<String, Product>> getGrandMap() {
        return GRAND_MAP;
    }

}
