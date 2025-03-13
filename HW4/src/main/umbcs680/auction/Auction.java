package umbcs680.auction;

import java.util.ArrayList;
import java.util.List;

public class Auction extends Observable<String> { // Auction extends Observable
    private final String item;
    private double highestBid;

    public Auction(String item) {
        this.item = item;
        this.highestBid = 0;
    }

    public void placeBid(double bid) {
        if (bid > highestBid) {
            highestBid = bid;
            super.notifyObservers("New highest bid of " + highestBid + " on " + item); // ✅ Use Observable’s notifyObservers
        } else {
            super.notifyObservers("Bid of " + bid + " is too low for " + item);
        }
    }

    public void endAuction() {
        super.notifyObservers("Auction for " + item + " has ended. Highest bid: " + highestBid);
    }
}
