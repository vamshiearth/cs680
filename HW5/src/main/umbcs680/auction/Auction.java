package umbcs680.auction;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    private List<BidObserver> bidObservers = new ArrayList<>();
    private List<AuctionEndObserver> auctionEndObservers = new ArrayList<>();

    public void addBidObserver(BidObserver ob) {
        bidObservers.add(ob);
    }

    public void addAuctionEndObserver(AuctionEndObserver ob) {
        auctionEndObservers.add(ob);
    }

    public void notifyBidObservers(BidEvent event) {
        for (BidObserver ob : bidObservers) {
            ob.updateBid(event);
        }
    }

    public void notifyAuctionEndObservers(AuctionEndEvent event) {
        for (AuctionEndObserver ob : auctionEndObservers) {
            ob.updateAuctionEnd(event);
        }
    }
}
