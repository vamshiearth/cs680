package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuctionEndEventTest {

    @Test
    void getItem() {
        AuctionEndEvent event = new AuctionEndEvent("Vintage Car", 5000);
        assertEquals("Vintage Car", event.getItem(), "Item name should match the expected value.");
    }

    @Test
    void getHighestBid() {
        AuctionEndEvent event = new AuctionEndEvent("Vintage Car", 5000);
        assertEquals(5000, event.getHighestBid(), "Highest bid should match the expected value.");
    }
}