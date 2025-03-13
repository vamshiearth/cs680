package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuctionTest {

    @Test
    void placeBid() {
        Auction auction = new Auction("Painting");
        Bidder bidder1 = new Bidder("Alice");
        Bidder bidder2 = new Bidder("Bob");

        bidder1.subscribeToAuction(auction);
        bidder2.subscribeToAuction(auction);

        auction.placeBid(100);
        auction.placeBid(50);
    }

    @Test
    void endAuction() {
        Auction auction = new Auction("Vintage Car");
        Bidder bidder = new Bidder("Charlie");

        bidder.subscribeToAuction(auction);
        auction.placeBid(500);
        auction.endAuction();
    }

    @Test
    void getItem() {
        Auction auction = new Auction("Antique Vase");
        assertEquals("Antique Vase", auction.getItem(), "Item name should match the constructor input.");
    }
}