package umbcs680.auction;


public class Auction {
    private final String item;
    private double highestBid;

    public Auction(String item) {
        this.item = item;
        this.highestBid = 0;
    }

    public void placeBid(double bid) {
        if (bid > highestBid) {
            highestBid = bid;
            MulticastManager.notifyBidObservers(this, new AuctionBidEvent(item, highestBid));
        } else {
            MulticastManager.notifyBidObservers(this, new AuctionBidEvent(item, -1));
        }
    }

    public void endAuction() {
        MulticastManager.notifyEndObservers(this, new AuctionEndEvent(item, highestBid));
    }

    public String getItem() {
        return item;
    }
}

