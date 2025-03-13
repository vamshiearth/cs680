package umbcs680.auction;

public class AuctionEndEvent {
    private final String item;
    private final double highestBid;

    public AuctionEndEvent(String item, double highestBid) {
        this.item = item;
        this.highestBid = highestBid;
    }

    public String getItem() { return item; }
    public double getHighestBid() { return highestBid; }
}