package umbcs680.auction;

public interface Observer<T> {
    public void update(Observable<T> sender, T event);
}
