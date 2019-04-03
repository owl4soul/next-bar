package bar.products.drinks;

public class Espresso extends Drink {


    public Espresso(EspressoBuilder espressoBuilder) {
        super(espressoBuilder);
    }

//    public static Espresso getEspresso(String name, int id, int cost) {
//        new Espresso(name, id, cost);
//    }

    //BUILDER
    public static class EspressoBuilder extends DrinkBuilder {

        public EspressoBuilder(String name, int id, int cost) {
            super(name, id, cost);
        }

        public Espresso build() {
            return new Espresso(this);
        }
    }


}
