package umbcs680.hw10;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {

    /**
     * Compares two Car objects based on their price.
     * The comparison is done in ascending order, meaning a lower price is considered better.
     *
     * @param car1 The first car to be compared
     * @param car2 The second car to be compared
     * @return A negative integer if car1 has a lower price than car2,
     *         zero if both cars have the same price,
     *         or a positive integer if car1 has a higher price than car2
     */
    @Override
    public int compare(Car car1, Car car2) {
        // Compare the prices of car1 and car2
        return Integer.compare(car1.getPrice(), car2.getPrice());
    }
}
