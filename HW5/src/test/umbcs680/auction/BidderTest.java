package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BidderTest {

    @Test
    void subscribeToAuction() {
        Auction auction = new Auction("Luxury Watch");
        Bidder bidder = new Bidder("Olivia");

        bidder.subscribeToAuction(auction);
        // No direct assertion; verify subscription by placing a bid
        auction.placeBid(1200);
    }

    @Test
    void unsubscribeFromAuction() {
        Auction auction = new Auction("Vintage Car");
        Bidder bidder = new Bidder("Liam");

        bidder.subscribeToAuction(auction);
        bidder.unsubscribeFromAuction(auction);
        auction.placeBid(3000);
        // No direct assertion; should not receive notifications after unsubscribing
    }

    @Test
    void updateBid() {
        AuctionBidEvent event = new AuctionBidEvent("Antique Vase", 5000);
        Bidder bidder = new Bidder("Sophia");

        bidder.updateBid(event);
        assertEquals("Antique Vase", event.getItem(), "Item should match the bid event");
        assertEquals(5000, event.getBidAmount(), "Bid amount should match the event");
    }

    @Test
    void updateEnd() {
        AuctionEndEvent event = new AuctionEndEvent("Diamond Ring", 10000);
        Bidder bidder = new Bidder("Noah");

        bidder.updateEnd(event);
        assertEquals("Diamond Ring", event.getItem(), "Item should match the auction end event");
        assertEquals(10000, event.getHighestBid(), "Highest bid should match the event");
    }
}