package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuctionBidEventTest {

    @Test
    void getItem() {
        AuctionBidEvent event = new AuctionBidEvent("Luxury Watch", 1500);
        assertEquals("Luxury Watch", event.getItem(), "Item name should match the expected value.");
    }

    @Test
    void getBidAmount() {
        AuctionBidEvent event = new AuctionBidEvent("Luxury Watch", 1500);
        assertEquals(1500, event.getBidAmount(), "Bid amount should match the expected value.");
    }
}