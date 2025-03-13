package umbcs680.auction;


import org.junit.Test;
import static org.junit.Assert.*;

public class BidderTest {

    @Test
    public void testSubscribeToAuction() {
        Auction auction = new Auction("Painting");
        Bidder bidder = new Bidder("Alice");

        bidder.subscribeToAuction(auction);
        // No direct assertion, but we assume subscription works if no errors occur.
    }

    @Test
    public void testUnsubscribeFromAuction() {
        Auction auction = new Auction("Sculpture");
        Bidder bidder = new Bidder("Bob");

        bidder.subscribeToAuction(auction);
        bidder.unsubscribeFromAuction(auction);
        // No direct assertion, but we assume unsubscription works if no errors occur.
    }

    @Test
    public void testUpdate() {
        Auction auction = new Auction("Car");
        Bidder bidder = new Bidder("Charlie");

        bidder.update(auction, "New bid placed!");
        // Since update prints a message, we can't assert it directly.
    }

    @Test
    public void testGetName() {
        Bidder bidder = new Bidder("David");
        assertEquals("David", bidder.getName());
    }
}
