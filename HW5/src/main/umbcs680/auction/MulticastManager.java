package umbcs680.auction;

import java.util.*;

public class MulticastManager {
    private static final Map<Auction, List<Bidder>> auctionSubscribers = new HashMap<>();

    public static void subscribe(Auction auction, Bidder bidder) {
        auctionSubscribers.computeIfAbsent(auction, k -> new ArrayList<>()).add(bidder);
    }

    public static void unsubscribe(Auction auction, Bidder bidder) {
        auctionSubscribers.getOrDefault(auction, new ArrayList<>()).remove(bidder);
    }

    public static void notifyBidders(Auction auction, String message) {
        if (auctionSubscribers.containsKey(auction)) {
            for (Bidder bidder : auctionSubscribers.get(auction)) {
                bidder.update(auction, message);
            }
        }
    }
}
