package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuctionTest {

    @Test
    void placeBid() {
        Auction auction = new Auction("Painting");
        Bidder bidder1 = new Bidder("Alice");
        Bidder bidder2 = new Bidder("Bob");

        auction.addObserver(bidder1);
        auction.addObserver(bidder2);

        auction.placeBid(100);
        assertEquals("New highest bid of 100.0 on Painting", bidder1.getLastMessage());
        assertEquals("New highest bid of 100.0 on Painting", bidder2.getLastMessage());

        auction.placeBid(50);
        assertEquals("Bid of 50.0 is too low for Painting", bidder1.getLastMessage());
        assertEquals("Bid of 50.0 is too low for Painting", bidder2.getLastMessage());
    }

    @Test
    void endAuction() {
        Auction auction = new Auction("Antique Clock");
        Bidder bidder = new Bidder("Charlie");

        auction.addObserver(bidder);
        auction.placeBid(200);
        auction.endAuction();

        assertEquals("Auction for Antique Clock has ended. Highest bid: 200.0", bidder.getLastMessage());
    }
}