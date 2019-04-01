package bar;

import bar.products.*;

public class Program {
    public static void main(String[] args) {

        Product ii = new Ingredient.IngredientBuilder().build();
        System.out.println(ii);
        Product v = Ingredient.createIngredient("Husk", 66, 33);
        Product i = Ingredient.createIngredient("Mesk", 99, 88);
        System.out.println(i);
        System.out.println(i.getClass().getSimpleName());


        System.out.println(DataBase.GRAND_MAP);

    }
}
