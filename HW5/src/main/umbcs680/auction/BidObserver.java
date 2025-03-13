package umbcs680.auction;

public interface BidObserver {
    void updateBid(BidEvent event);
}