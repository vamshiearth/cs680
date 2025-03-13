package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuctionBidObserverTest {

    @Test
    void updateBid() {
        AuctionBidEvent event = new AuctionBidEvent("Smartphone", 800);
        Bidder bidder = new Bidder("John");

        bidder.updateBid(event);

        assertEquals("Smartphone", event.getItem(), "Item should match the bid event");
        assertEquals(800, event.getBidAmount(), "Bid amount should match the event");
    }
}
