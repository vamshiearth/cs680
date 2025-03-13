package umbcs680.auction;

import java.util.ArrayList;
import java.util.List;

public class Auction extends Observable<String> { // Specify String as the type for Observable
    private final List<Observer<String>> observers = new ArrayList<>();
    private final String item;
    private double highestBid;

    public Auction(String item) {
        this.item = item;
        this.highestBid = 0;
    }

    public void placeBid(double bid) {
        if (bid > highestBid) {
            highestBid = bid;
            notifyObservers("New highest bid of " + highestBid + " on " + item);
        } else {
            notifyObservers("Bid of " + bid + " is too low for " + item);
        }
    }

    public void endAuction() {
        notifyObservers("Auction for " + item + " has ended. Highest bid: " + highestBid);
    }

    @Override
    public void addObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer<String> observer : observers) {
            observer.update(this, message);
        }
    }
}
