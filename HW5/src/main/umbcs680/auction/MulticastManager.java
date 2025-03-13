package umbcs680.auction;

import java.util.*;

public class MulticastManager {
    private static final Map<Auction, List<AuctionBidObserver>> bidObservers = new HashMap<>();
    private static final Map<Auction, List<AuctionEndObserver>> endObservers = new HashMap<>();

    // Subscribe a bidder to bid updates
    public static void subscribeToBids(Auction auction, AuctionBidObserver observer) {
        bidObservers.computeIfAbsent(auction, k -> new ArrayList<>()).add(observer);
    }

    // Subscribe a bidder to auction end updates
    public static void subscribeToAuctionEnd(Auction auction, AuctionEndObserver observer) {
        endObservers.computeIfAbsent(auction, k -> new ArrayList<>()).add(observer);
    }

    // Unsubscribe a bidder from bid updates
    public static void unsubscribeFromBids(Auction auction, AuctionBidObserver observer) {
        bidObservers.getOrDefault(auction, new ArrayList<>()).remove(observer);
    }

    // Unsubscribe a bidder from auction end updates
    public static void unsubscribeFromAuctionEnd(Auction auction, AuctionEndObserver observer) {
        endObservers.getOrDefault(auction, new ArrayList<>()).remove(observer);
    }

    // Notify all subscribed bidders about a new bid
    public static void notifyBidObservers(Auction auction, AuctionBidEvent event) {
        if (bidObservers.containsKey(auction)) {
            for (AuctionBidObserver observer : bidObservers.get(auction)) {
                observer.updateBid(event);
            }
        }
    }

    // Notify all subscribed bidders about auction end
    public static void notifyEndObservers(Auction auction, AuctionEndEvent event) {
        if (endObservers.containsKey(auction)) {
            for (AuctionEndObserver observer : endObservers.get(auction)) {
                observer.updateEnd(event);
            }
        }
    }
}
