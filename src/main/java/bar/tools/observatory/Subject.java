package bar.tools.observatory;

import bar.products.Product;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(Product product);
}
