package bar.tools.observatory;

import bar.products.Product;

import java.util.ArrayList;
import java.util.List;

public interface AbstractSubject extends Subject {
    List<Observer> observers = new ArrayList<>();

    @Override
    default void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    default void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    default void notifyObserver(Product product) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(product);
        }

    }
}
