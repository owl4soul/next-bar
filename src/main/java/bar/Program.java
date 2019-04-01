package bar;

import bar.products.Ingredient;
import bar.products.Product;
import bar.products.Production;

public class Program {
    public static void main(String[] args) {
        Product i = new Ingredient((Ingredient.IngredientBuilder) new Ingredient.IngredientBuilder().addName("Salvia").addCost(999).addId(6));
        System.out.println(i);
    }
}
