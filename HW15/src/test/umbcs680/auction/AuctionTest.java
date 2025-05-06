package umbcs680.auction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AuctionTest {

    @Test
    void testPlaceBid() {
        Auction auction = new Auction("Antique Vase");

        final StringBuilder aliceMessage = new StringBuilder();
        final StringBuilder bobMessage = new StringBuilder();

        auction.addObserver((sender, msg) -> {
            aliceMessage.setLength(0);
            aliceMessage.append(msg);
        });
        auction.addObserver((sender, msg) -> {
            bobMessage.setLength(0);
            bobMessage.append(msg);
        });


        auction.placeBid(100);
        assertEquals("New highest bid of 100.0 on Antique Vase", aliceMessage.toString());
        assertEquals("New highest bid of 100.0 on Antique Vase", bobMessage.toString());

        auction.placeBid(50);
        assertEquals("Bid of 50.0 is too low for Antique Vase", aliceMessage.toString());
        assertEquals("Bid of 50.0 is too low for Antique Vase", bobMessage.toString());
    }

    @Test
    void testEndAuction() {
        Auction auction = new Auction("Painting");

        final StringBuilder message = new StringBuilder();
        auction.addObserver((sender, msg) -> {
            message.setLength(0); // Clear previous message
            message.append(msg);  // Append new one
        });

        auction.placeBid(200);     // First message
        auction.endAuction();      // Second message replaces it

        assertEquals("Auction for Painting has ended. Highest bid: 200.0", message.toString());
    }


    @Test
    void testAddObserver() {
        Auction auction = new Auction("Book");

        final StringBuilder message = new StringBuilder();
        auction.addObserver((sender, msg) -> message.append(msg));

        auction.placeBid(30);

        assertEquals("New highest bid of 30.0 on Book", message.toString());
    }

    @Test
    void testRemoveObserver() {
        Auction auction = new Auction("Car");

        final StringBuilder message = new StringBuilder();
        Observer<String> observer = (sender, msg) -> message.append(msg);

        auction.addObserver(observer);
        auction.removeObserver(observer);
        auction.placeBid(500);

        assertEquals("", message.toString(), "Observer should not receive updates after being removed.");
    }

    @Test
    void testNotifyObservers() {
        Auction auction = new Auction("Laptop");

        final StringBuilder message = new StringBuilder();
        auction.addObserver((sender, msg) -> message.append(msg));

        auction.notifyObservers("Testing message delivery");

        assertEquals("Testing message delivery", message.toString());
    }
}
