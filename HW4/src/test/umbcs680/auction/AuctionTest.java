package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuctionTest {

    @Test
    void testPlaceBid() {
        Auction auction = new Auction("Antique Vase");
        Bidder bidder1 = new Bidder("Alice");
        Bidder bidder2 = new Bidder("Bob");

        auction.addObserver(bidder1);
        auction.addObserver(bidder2);

        auction.placeBid(100);
        assertEquals("New highest bid of 100.0 on Antique Vase", bidder1.getLastMessage());
        assertEquals("New highest bid of 100.0 on Antique Vase", bidder2.getLastMessage());

        auction.placeBid(50);
        assertEquals("Bid of 50.0 is too low for Antique Vase", bidder1.getLastMessage());
        assertEquals("Bid of 50.0 is too low for Antique Vase", bidder2.getLastMessage());
    }

    @Test
    void testEndAuction() {
        Auction auction = new Auction("Painting");
        Bidder bidder = new Bidder("Chris");

        auction.addObserver(bidder);
        auction.placeBid(200);
        auction.endAuction();

        assertEquals("Auction for Painting has ended. Highest bid: 200.0", bidder.getLastMessage());
    }

    @Test
    void testAddObserver() {
        Auction auction = new Auction("Book");
        Bidder bidder = new Bidder("Dana");

        auction.addObserver(bidder);
        auction.placeBid(30);

        assertEquals("New highest bid of 30.0 on Book", bidder.getLastMessage());
    }

    @Test
    void testRemoveObserver() {
        Auction auction = new Auction("Car");
        Bidder bidder = new Bidder("Eve");

        auction.addObserver(bidder);
        auction.removeObserver(bidder);
        auction.placeBid(500);

        assertNull(bidder.getLastMessage(), "Bidder should not receive updates after being removed.");
    }

    @Test
    void testNotifyObservers() {
        Auction auction = new Auction("Laptop");
        Bidder bidder = new Bidder("Frank");

        auction.addObserver(bidder);
        auction.notifyObservers("Testing message delivery");

        assertEquals("Testing message delivery", bidder.getLastMessage());
    }
}