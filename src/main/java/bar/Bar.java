package bar;

import bar.products.Ingredient;
import bar.products.Product;
import bar.products.drinks.Drink;
import bar.tools.Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bar {
    public static Product orderByRecipe() {
        System.out.println("Какой напиток закажете?");
        System.out.println();
        for (int i = 0; i < Recipe.values().length; i++) {
            System.out.println(i + " - " + Recipe.values()[i]);
        }
        int userInput = Tools.readInteger();
        if (userInput >= 0 & userInput < Recipe.values().length) {
            return new Drink.DrinkBuilder().addName("COFFEE").addCost(100).setConsist(Recipe.values()[userInput]).build();
        } else {
            return null;
        }
    }

    public static void orderAddition(Product product) {
        List<String> productsList = new ArrayList<>();
        for (String prodName : Ingredient.ingredients.keySet()) {
            productsList.add(prodName);
        }
        System.out.println("Выберите добавки к напитку: ");
        System.out.println();
        for (int i = 0; i < productsList.size(); i++) {
            System.out.println(i + " - " + productsList.get(i));
        }
        int userInput = Tools.readInteger();
        if (userInput >= 0 & userInput < productsList.size()) {
            String nameOFSelected = productsList.get(userInput);
            Product selectedAddition = Ingredient.ingredients.get(nameOFSelected);
            ((Drink) product).addAddition((Ingredient) selectedAddition, 1);
            orderAddition(product);
        } else {
            return;
        }

    }
}
