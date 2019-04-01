package bar.products;

public class Option extends Product implements Build {

        public Option() {

        }

        public Option(bar.products.Option.Buildd buildd) {
            this.name = buildd.name;
            this.id = buildd.id;
            this.cost = buildd.cost;

        }

        public Option(Product sure) {
            super();
        }


        //BUILD
        public static class Buildd extends Build.Builder {
            @Override
            public bar.products.Option buildd() {
                return new bar.products.Option(this);
            }
        }

        public static bar.products.Option create() {
            return new bar.products.Option();//////////
        }



        @Override
        public Product createProduct() {
            return create();///////////
        }
    }


