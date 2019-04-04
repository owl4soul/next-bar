package bar.products;


public abstract class Product implements Production {
    protected String name;
    protected int cost;

    public Product(Builder builder) {
        this.name = builder.name;
        this.cost = builder.cost;
    }

    public abstract Product createProduct(String name, int cost);

    //BUILDER
    public abstract static class Builder {
        protected String name;
        protected int cost;

        public Builder addName(String name) {
            this.name = name;
            return this;
        }


        public Builder addCost(int cost) {
            this.cost = cost;
            return this;
        }



        abstract public Product build();
    }
    ////////////////


    public static void showDefault(Product product) {
        String s1 = "Класс продукта: " + product.getClass().getSimpleName() + "\n";
        String s2 = "Имя продукта: " + product.getName();
        System.out.println(s1 + s2);
    }

    public abstract void show();


    @Override
    public String toString() {
        String output = "[" + this.getClass().getSimpleName()
                + "."+ this.getName()
                + "_" + this.getCost() + "$" + "]";
        return output;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    //////////////////
}
