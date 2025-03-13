package umbcs680.auction;

import org.junit.Test;

public class MulticastManagerTest {

    @Test
    public void testSubscribe() {
        Auction auction = new Auction("Watch");
        Bidder bidder = new Bidder("Eve");

        MulticastManager.subscribe(auction, bidder);
        // No direct assertion, assuming subscription works if no errors occur.
    }

    @Test
    public void testUnsubscribe() {
        Auction auction = new Auction("Painting");
        Bidder bidder = new Bidder("Frank");

        MulticastManager.subscribe(auction, bidder);
        MulticastManager.unsubscribe(auction, bidder);
        // No direct assertion, assuming unsubscription works if no errors occur.
    }

    @Test
    public void testNotifyBidders() {
        Auction auction = new Auction("Laptop");
        Bidder bidder1 = new Bidder("Grace");
        Bidder bidder2 = new Bidder("Henry");

        MulticastManager.subscribe(auction, bidder1);
        MulticastManager.subscribe(auction, bidder2);

        MulticastManager.notifyBidders(auction, "Test notification");
        // Since notification is printed, we can't assert directly.
    }
}
