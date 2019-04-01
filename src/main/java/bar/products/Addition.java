package bar.products;

public class Addition extends Product implements Build {

    public Addition() {

    }

    public Addition(Buildd buildd) {
        this.name = buildd.name;
        this.id = buildd.id;
        this.cost = buildd.cost;

    }

    public Addition(Product sure) {
        super();
    }


    //BUILD
    public static class Buildd extends Build.Builder {
        @Override
        public Addition buildd() {
            return new Addition(this);
        }
    }

    public static Addition create() {
        return new Addition();//////////
    }



    @Override
    public Product createProduct() {
        return create();///////////
    }
}
