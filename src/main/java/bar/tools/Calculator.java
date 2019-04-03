package bar.tools;

import bar.products.Ingredient;
import bar.products.Product;
import bar.products.drinks.Drink;

import java.util.ArrayList;
import java.util.Map;

public abstract class Calculator {
    public static Integer calcPrice(Product product) {
        int addedCost = product.getCost();
        int primeCost = 0;

        for (Map.Entry entry : ((Drink) product).consist.entrySet()) {
            Product p = (Product) entry.getKey();
            int costIngredient = p.getCost();
            int mult = (Integer) entry.getValue();
            primeCost += costIngredient * mult;
        }

        int result = addedCost + primeCost;
        System.out.println(result);
        return result;
    }
}
