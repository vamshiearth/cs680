package umbcs680.auction;

public class AuctionEndEvent {
    private final String item;
    private final double winningBid;

    public AuctionEndEvent(String item, double winningBid) {
        this.item = item;
        this.winningBid = winningBid;
    }

    public String getItem() {
        return item;
    }

    public double getWinningBid() {
        return winningBid;
    }
}
