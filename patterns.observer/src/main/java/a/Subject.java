package a;

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer remove);

    void notifyObservers();

}
