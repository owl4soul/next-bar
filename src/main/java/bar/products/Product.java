package bar.products;


public abstract class Product implements Production {
    protected String name;
    protected int id;
    protected int cost;

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


}
