package umbcs680.auction;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ObservableTest {

    @Test
    void addObserver() {
        Observable<String> observable = new Auction("Smartphone");
        Observer<String> observer = new Bidder("John");
        observable.addObserver(observer);

        assertEquals(1, observable.countObservers(), "Observer should be added.");
    }

    @Test
    void clearObservers() {
        Observable<String> observable = new Auction("Tablet");
        observable.addObserver(new Bidder("Alice"));
        observable.addObserver(new Bidder("Bob"));
        observable.clearObservers();

        assertEquals(0, observable.countObservers(), "All observers should be cleared.");
    }

    @Test
    void getObservers() {
        Observable<String> observable = new Auction("Camera");
        Observer<String> bidder1 = new Bidder("Charlie");
        Observer<String> bidder2 = new Bidder("Dana");
        observable.addObserver(bidder1);
        observable.addObserver(bidder2);

        List<Observer<String>> observers = observable.getObservers();
        assertTrue(observers.contains(bidder1) && observers.contains(bidder2), "Observers list should contain both bidders.");
    }

    @Test
    void countObservers() {
        Observable<String> observable = new Auction("Watch");
        observable.addObserver(new Bidder("Eve"));
        observable.addObserver(new Bidder("Frank"));
        observable.addObserver(new Bidder("Grace"));

        assertEquals(3, observable.countObservers(), "Observer count should be 3.");
    }

    @Test
    void removeObserver() {
        Observable<String> observable = new Auction("Headphones");
        Observer<String> observer = new Bidder("Harry");
        observable.addObserver(observer);
        observable.removeObserver(observer);

        assertEquals(0, observable.countObservers(), "Observer should be removed.");
    }

    @Test
    void notifyObservers() {
        Observable<String> observable = new Auction("TV");
        Bidder bidder = new Bidder("Ivy");
        observable.addObserver(bidder);

        observable.notifyObservers("Test message");
        assertEquals("Test message", bidder.getLastMessage(), "Bidder should receive the notification.");
    }
}