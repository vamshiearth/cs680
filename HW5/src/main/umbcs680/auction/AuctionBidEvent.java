package umbcs680.auction;

public class AuctionBidEvent {
    private final String item;
    private final double bidAmount;

    public AuctionBidEvent(String item, double bidAmount) {
        this.item = item;
        this.bidAmount = bidAmount;
    }

    public String getItem() { return item; }
    public double getBidAmount() { return bidAmount; }
}
