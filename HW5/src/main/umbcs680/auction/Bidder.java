package umbcs680.auction;

public class Bidder {
    private final String name;

    public Bidder(String name) {
        this.name = name;
    }

    public void subscribeToAuction(Auction auction) {
        MulticastManager.subscribe(auction, this);
    }

    public void unsubscribeFromAuction(Auction auction) {
        MulticastManager.unsubscribe(auction, this);
    }

    public void update(Auction auction, String message) {
        System.out.println(name + " received update from " + auction.getItem() + ": " + message);
    }

    public String getName() {
        return name;
    }
}
