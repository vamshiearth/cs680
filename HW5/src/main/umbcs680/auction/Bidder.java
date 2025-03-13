package umbcs680.auction;

public class Bidder implements BidObserver, AuctionEndObserver {
    private final String name;

    public Bidder(String name) {
        this.name = name;
    }

    @Override
    public void updateBid(BidEvent event) {
        System.out.println(name + " received bid update: " + event.getBidAmount());
    }

    @Override
    public void updateAuctionEnd(AuctionEndEvent event) {
        System.out.println(name + " received auction end notification: " + event.getWinningBid());
    }
}
