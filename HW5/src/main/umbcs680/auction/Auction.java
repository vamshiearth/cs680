package umbcs680.auction;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    private List<AuctionBidObserver> bidObservers = new ArrayList<>();
    private List<AuctionEndObserver> endObservers = new ArrayList<>();
    private final String item;
    private double highestBid;

    public Auction(String item) {
        this.item = item;
        this.highestBid = 0;
    }

    public void placeBid(double bid) {
        if (bid > highestBid) {
            highestBid = bid;
            notifyBidObservers(new AuctionBidEvent(item, highestBid));
        } else {
            notifyBidObservers(new AuctionBidEvent(item, -1)); // Indicates a failed bid
        }
    }

    public void endAuction() {
        notifyEndObservers(new AuctionEndEvent(item, highestBid));
    }

    public void addBidObserver(AuctionBidObserver observer) {
        bidObservers.add(observer);
    }

    public void addEndObserver(AuctionEndObserver observer) {
        endObservers.add(observer);
    }

    private void notifyBidObservers(AuctionBidEvent event) {
        for (AuctionBidObserver ob : bidObservers) {
            ob.updateBid(event);
        }
    }

    private void notifyEndObservers(AuctionEndEvent event) {
        for (AuctionEndObserver ob : endObservers) {
            ob.updateEnd(event);
        }
    }
}
