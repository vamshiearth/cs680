package umbcs680.auction;

public class Bidder implements Observer<String> { // Specify String as the type for Observer
    private final String name;
    private String lastMessage; // To track the last received message

    public Bidder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable<String> sender, String message) {
        lastMessage = message; // Ensure this correctly updates the message
        System.out.println(name + " received update: " + message);
    }


    public String getLastMessage() {
        return lastMessage;
    }
}
