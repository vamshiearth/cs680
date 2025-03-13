package umbcs680.auction;

public class Bidder implements Observer<String> { // Implements Observer<String>
    private final String name;
    private String lastMessage; // To track the last received message

    public Bidder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable<String> sender, String message) {
        lastMessage = message;
        System.out.println(name + " received update: " + message);
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
