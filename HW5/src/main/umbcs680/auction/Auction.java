package umbcs680.auction;

public class Auction {
    private final String item;
    private double highestBid;

    public Auction(String item) {
        this.item = item;
        this.highestBid = 0;
    }

    public void placeBid(Bidder bidder, double bid) {
        if (bid > highestBid) {
            highestBid = bid;
            MulticastManager.notifyBidders(this, bidder.getName() + " placed the highest bid: $" + highestBid + " on " + item);
        } else {
            MulticastManager.notifyBidders(this, "Bid of $" + bid + " is too low for " + item);
        }
    }

    public void endAuction() {
        MulticastManager.notifyBidders(this, "Auction for " + item + " has ended. Final bid: $" + highestBid);
    }

    public String getItem() {
        return item;
    }
}
