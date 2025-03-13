package umbcs680.auction;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class BidderTest {

    @Test
    void testUpdate() {
        Auction auction = new Auction("Bike");
        Bidder bidder = new Bidder("Grace");

        auction.addObserver(bidder);
        auction.placeBid(150);

        assertEquals("New highest bid of 150.0 on Bike", bidder.getLastMessage());
    }

    @Test
    void testGetLastMessage() {
        Bidder bidder = new Bidder("Hank");

        // Initially, the last message should be null
        assertNull(bidder.getLastMessage(), "Last message should be null initially.");

        // Send a test update
        bidder.update(null, "Test message");

        // Debugging output
        System.out.println("DEBUG: Last message is -> " + bidder.getLastMessage());

        // Ensure correct expected vs actual placement in assertEquals
        assertEquals("Test message", bidder.getLastMessage());
    }


}
