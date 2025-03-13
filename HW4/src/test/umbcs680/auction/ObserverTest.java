package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

    @Test
    void update() {
        Auction auction = new Auction("Game Console");
        Bidder bidder = new Bidder("Jack");

        auction.addObserver(bidder);
        auction.notifyObservers("New bid placed: $500");

        assertEquals("New bid placed: $500", bidder.getLastMessage(), "Bidder should receive the correct update message.");
    }
}