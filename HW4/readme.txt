# Auction System Application

## Overview

This Auction System Application demonstrates the use of the Observer design pattern. In this system, bidders can
subscribe to receive notifications about updates related to an auction item, such as new bids and auction completion.

## Components

1. **Auction**: This class acts as the observable (or subject) that maintains a list of observers (bidders) and notifies
 them of any changes in the auction status.

2. **Bidder**: This class implements the observer interface. Each bidder receives notifications from the auction
regarding the current bid status and any relevant messages.

3. **Observer Interface**: Defines the method that observers (bidders) must implement to receive updates from the
observable (auction).

4. **Observable Interface**: Defines methods for adding, removing, and notifying observers.

## Implementation of the Observer Pattern

- The `Auction` class uses the Observer pattern to notify all registered bidders when a new bid is placed or when the
auction ends.
- Bidders can register themselves with the auction using the `addObserver` method and will receive notifications
through the `update` method when the auction changes state.
- This pattern allows for a clear separation of concerns, where the auction logic is decoupled from the bidder
notification logic, enhancing maintainability and scalability.

