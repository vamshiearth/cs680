package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MulticastManagerTest {

    @Test
    void subscribeToBids() {
        Auction auction = new Auction("Gold Necklace");
        Bidder bidder = new Bidder("William");

        MulticastManager.subscribeToBids(auction, bidder);
        auction.placeBid(2000);
        // No direct assertion; check console output for subscription success
    }

    @Test
    void subscribeToAuctionEnd() {
        Auction auction = new Auction("Silver Bracelet");
        Bidder bidder = new Bidder("Emma");

        MulticastManager.subscribeToAuctionEnd(auction, bidder);
        auction.endAuction();
        // No direct assertion; check console output for notification
    }

    @Test
    void unsubscribeFromBids() {
        Auction auction = new Auction("Painting");
        Bidder bidder = new Bidder("James");

        MulticastManager.subscribeToBids(auction, bidder);
        MulticastManager.unsubscribeFromBids(auction, bidder);
        auction.placeBid(500);
        // No direct assertion; should not receive notifications after unsubscribing
    }

    @Test
    void unsubscribeFromAuctionEnd() {
        Auction auction = new Auction("Rare Coin");
        Bidder bidder = new Bidder("Isabella");

        MulticastManager.subscribeToAuctionEnd(auction, bidder);
        MulticastManager.unsubscribeFromAuctionEnd(auction, bidder);
        auction.endAuction();
        // No direct assertion; should not receive notifications after unsubscribing
    }

    @Test
    void notifyBidObservers() {
        Auction auction = new Auction("Luxury Car");
        Bidder bidder1 = new Bidder("Liam");
        Bidder bidder2 = new Bidder("Sophia");

        MulticastManager.subscribeToBids(auction, bidder1);
        MulticastManager.subscribeToBids(auction, bidder2);
        auction.placeBid(10000);
        // No direct assertion; check console output for bid notifications
    }

    @Test
    void notifyEndObservers() {
        Auction auction = new Auction("Diamond Ring");
        Bidder bidder1 = new Bidder("Charlotte");
        Bidder bidder2 = new Bidder("Mason");

        MulticastManager.subscribeToAuctionEnd(auction, bidder1);
        MulticastManager.subscribeToAuctionEnd(auction, bidder2);
        auction.endAuction();
        // No direct assertion; check console output for auction end notifications
    }
}