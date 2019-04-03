package bar.products;


public abstract class Product implements Production {
    protected String name;
    protected int id;
    protected int cost;

    public Product(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
        this.cost = builder.cost;
    }

    public abstract Product createProduct(String name, int id, int cost);

    //BUILDER
    public abstract static class Builder {
        protected String name;
        protected int id;
        protected int cost;

        public Builder addName(String name) {
            this.name = name;
            return this;
        }

        public Builder addId(int id) {
            this.id = id;
            return this;
        }

        public Builder addCost(int cost) {
            this.cost = cost;
            return this;
        }

        abstract public Product build();
    }
    ////////////////


    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    //////////////////
}
