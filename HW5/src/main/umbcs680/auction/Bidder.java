package umbcs680.auction;

public class Bidder implements AuctionBidObserver, AuctionEndObserver {
    private final String name;

    public Bidder(String name) {
        this.name = name;
    }

    @Override
    public void updateBid(AuctionBidEvent event) {
        if (event.getBidAmount() > 0) {
            System.out.println(name + " received bid update: Highest bid on " + event.getItem() + " is $" + event.getBidAmount());
        } else {
            System.out.println(name + " received bid update: Bid failed on " + event.getItem());
        }
    }

    @Override
    public void updateEnd(AuctionEndEvent event) {
        System.out.println(name + " received auction end update: " + event.getItem() + " sold for $" + event.getHighestBid());
    }
}
