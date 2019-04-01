package bar.tools;

import bar.Stock;
import bar.products.Product;

public interface Stockable {

    static void addCountToStock(Stock s, Product product, int countToStock) {
        for (int i = 0; i < countToStock; i++) {
            addOneToStock(s, product);
        }
    }

    static void addOneToStock(Stock s, Product product) {
        String productName = product.getName();
        s.getStock().put(productName, 1);
    }
}
