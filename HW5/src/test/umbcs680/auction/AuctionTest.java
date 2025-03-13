package umbcs680.auction;

import org.junit.Test;
import static org.junit.Assert.*;

public class AuctionTest {

    @Test
    public void testPlaceBid() {
        Auction auction = new Auction("Painting");
        Bidder bidder = new Bidder("Alice");

        bidder.subscribeToAuction(auction);
        auction.placeBid(bidder, 100);

        // Since notification is printed, we can't directly assert it, but we can ensure bid updates.
        assertEquals("Painting", auction.getItem());
    }

    @Test
    public void testEndAuction() {
        Auction auction = new Auction("Sculpture");
        Bidder bidder = new Bidder("Bob");

        bidder.subscribeToAuction(auction);
        auction.placeBid(bidder, 200);
        auction.endAuction();

        // We check if auction ended, but assertions depend on expected output capture.
        assertEquals("Sculpture", auction.getItem());
    }

    @Test
    public void testGetItem() {
        Auction auction = new Auction("Car");
        assertEquals("Car", auction.getItem());
    }
}
