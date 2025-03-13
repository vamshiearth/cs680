Auction System - Multicast Observer Pattern

------Overview------

This project extends an auction system using the Multicast Observer Pattern.
It allows multiple bidders to subscribe to auction events, such as new bids and auction completion.


------Auction Events------

AuctionBidEvent: Triggered when a new bid is placed.
AuctionEndEvent: Triggered when the auction ends.

------Observer Interfaces------

AuctionBidObserver: Listens for bid updates.
AuctionEndObserver: Listens for auction end notifications.

------Multicast Manager------

MulticastManager handles subscriptions and notifications.
It maintains separate lists for bid updates and auction end notifications.

------Auction Class (Observable)------

The Auction class does not store observers directly.
It uses MulticastManager to notify all subscribed observers.

------Bidder Class (Observer)------

Implements both AuctionBidObserver and AuctionEndObserver.
Can receive bid updates and auction completion updates.
Can subscribe/unsubscribe from auctions.


------How It Works (Example Flow)------

Create an Auction for an item.
Create Bidder objects and subscribe them to the auction.
When a bid is placed, only subscribed bidders receive updates.
When the auction ends, all subscribed bidders receive a final update.