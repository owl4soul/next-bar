package bar;

import bar.products.*;

public class Program {
    public static void main(String[] args) {
        Product i = new Ingredient((Ingredient.IngredientBuilder) new Ingredient.IngredientBuilder().addName("Salvia").addCost(999).addId(6));
        System.out.println(i);

        Build a = new Addition(new Addition.Buildd().addName("Sure").addId(99).addCost(888).buildd());
        System.out.println(a);
        System.out.println(a.getClass().getSimpleName());

        Build o = new Option(new Option.Buildd().addName("HYUY").addId(555).addCost(9).buildd());
        System.out.println(o);

        Build aa = new Addition.Buildd().addName("POLL").addId(8888).buildd();
        System.out.println(aa);


    }
}
