package bar.tools;

import bar.products.Ingredient;
import bar.products.Product;
import bar.products.drinks.Drink;

import java.util.Map;

public abstract class Calculator {
    public static Integer calcPrice(Product product) {
        int addedCost = product.getCost();
        int primeCost = 0;

        //here we set the price to the NULL-ingredient-drink to zero instead of it's prime cost
        if (((Drink) product).consist.containsKey(Ingredient.NULL)) {
            return 0;
        }


        for (Map.Entry entry : ((Drink) product).consist.entrySet()) {
            Product p = (Product) entry.getKey();
            int costIngredient = p.getCost();
            int mult = (Integer) entry.getValue();
            primeCost += costIngredient * mult;
        }

        int result = addedCost + primeCost;
        return result;
    }
}
