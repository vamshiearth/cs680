package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuctionEndObserverTest {

    @Test
    void updateEnd() {
        AuctionEndEvent event = new AuctionEndEvent("Antique Clock", 2500);
        Bidder bidder = new Bidder("Emma");

        bidder.updateEnd(event);

        assertEquals("Antique Clock", event.getItem(), "Item should match the auction end event");
        assertEquals(2500, event.getHighestBid(), "Highest bid should match the event");
    }
}