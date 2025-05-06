package umbcs680.hw10;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {

    /**
     * Compares two Car objects based on their year.
     * The comparison is done in descending order, meaning a newer year is considered better.
     *
     * @param car1 The first car to be compared
     * @param car2 The second car to be compared
     * @return A negative integer if car1 is newer than car2 (car1's year > car2's year),
     *         zero if both cars have the same year,
     *         or a positive integer if car1 is older than car2 (car1's year < car2's year)
     */
    @Override
    public int compare(Car car1, Car car2) {
        // Compare the years of car1 and car2 in descending order (newer car is considered better)
        return Integer.compare(car2.getYear(), car1.getYear());
    }
}
