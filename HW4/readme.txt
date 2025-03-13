# Auction System - Observer Pattern

## Overview
This project implements an **Auction System** using the **Observer Pattern**.
It allows multiple bidders to receive updates when the auction state changes.

## Steps to Understand the Code

### 1. **Auction (Observable)**
- The `Auction` class represents an auction for an item.
- It extends `Observable<String>`, meaning it can notify bidders (observers) when a new bid is placed.
- When a bid is placed or the auction ends, all subscribed bidders receive updates.

### 2. **Bidder (Observer)**
- The `Bidder` class represents a participant in the auction.
- It implements `Observer<String>`, meaning it listens for auction updates.
- When notified, it prints a message indicating it received an update.

### 3. **Observable (Publisher)**
- This is an abstract class that manages a **list of observers**.
- It provides methods for:
  - Adding observers (`addObserver()`)
  - Removing observers (`removeObserver()`)
  - Notifying observers when the state changes (`notifyObservers()`)

### 4. **Observer Interface (Subscriber)**
- This interface ensures that all observers **implement the `update()` method**.
- The `Bidder` class implements this interface.

## How It Works (Example Flow)
1. **Create an Auction** for an item.
2. **Create multiple Bidders** and register them using `addObserver()`.
3. **Place bids on the auction**:
   - If the bid is higher than the current highest bid, it updates and notifies all bidders.
   - If the bid is too low, bidders receive a notification that the bid was rejected.
4. **End the auction** and notify all bidders of the final price.


## Conclusion
This project follows the **Observer Pattern**, allowing an auction to notify multiple bidders about bid updates and
auction completion. This ensures an efficient **publish-subscribe system** where bidders receive real-time updates.

