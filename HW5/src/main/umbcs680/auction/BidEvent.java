package umbcs680.auction;

public class BidEvent {
    private final String item;
    private final double bidAmount;

    public BidEvent(String item, double bidAmount) {
        this.item = item;
        this.bidAmount = bidAmount;
    }

    public String getItem() {
        return item;
    }

    public double getBidAmount() {
        return bidAmount;
    }
}
