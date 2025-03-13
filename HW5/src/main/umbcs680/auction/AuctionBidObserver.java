package umbcs680.auction;

public interface AuctionBidObserver {
    void updateBid(AuctionBidEvent event);
}
