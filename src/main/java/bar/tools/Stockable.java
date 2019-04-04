package bar.tools;

import bar.Stock;
import bar.products.Product;
import bar.products.drinks.Drink;

import java.util.Set;

public interface Stockable {

    static void addCountToStock(Stock s, Product product, int countToAdd) {
        for (int i = 0; i < countToAdd; i++) {
            addOneToStock(s, product);
        }
    }

    static void addOneToStock(Stock s, Product product) {
        String productName = product.getName();
        s.getStock().put(productName, 1);
    }

    static void removeFromStock(Stock s, Product product) {
        System.out.println("Следующие ингредиенты списаны: ");
        Set<Product> ingredients = ((Drink) product).consist.keySet();
        for (Product ingredient : ingredients) {
            String name = ingredient.getName();
            int countToRemove = ((Drink) product).consist.get(ingredient);
            int lastCountValue = s.stock.get(name);
            int resultCountValue = lastCountValue - countToRemove;
            s.stock.put(name, resultCountValue);

        }
    }

    static void removeCountFromStock(Stock s, String name, int countToRemove) {
        for (int i = 0; i < countToRemove; i++) {
            s.stock.remove(name);
        }
    }
}
