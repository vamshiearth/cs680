package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BidderTest {

    @Test
    void update() {
        Auction auction = new Auction("Laptop");
        Bidder bidder = new Bidder("Dave");

        auction.addObserver(bidder);
        auction.placeBid(300);

        assertEquals("New highest bid of 300.0 on Laptop", bidder.getLastMessage());
    }

    @Test
    void getLastMessage() {
        Bidder bidder = new Bidder("Eve");
        assertNull(bidder.getLastMessage(), "Last message should be null initially.");

        bidder.update(null, "Test notification");
        assertEquals("Test notification", bidder.getLastMessage(), "Last message should be updated correctly.");
    }
}