package umbcs680.hw10;

import java.util.Comparator;
import java.util.List;

public class ParetoComparator implements Comparator<Car> {

    /**
     * Compares two Car objects based on their domination counts.
     * A lower domination count is considered better.
     * The comparison is done in ascending order.
     *
     * @param car1 The first car to be compared
     * @param car2 The second car to be compared
     * @return A negative integer if car1 has fewer domination counts than car2,
     *         zero if they have the same domination count,
     *         or a positive integer if car1 has more domination counts than car2
     */
    @Override
    public int compare(Car car1, Car car2) {
        // Compare the domination counts of two cars
        return Integer.compare(car1.getDominationCount(), car2.getDominationCount());
    }

    /**
     * Computes the domination count for each car in the list.
     * The domination count for a car represents how many other cars it dominates.
     * A car is said to dominate another if it is better or equal in all attributes and strictly better in at least one.
     *
     * @param cars The list of cars whose domination counts need to be computed
     */
    public static void computeDominationCounts(List<Car> cars) {
        // Loop through each car and calculate its domination count
        for (Car car1 : cars) {
            int dominationCount = 0;
            for (Car car2 : cars) {
                // Count how many cars are dominated by car1
                if (dominates(car2, car1)) {
                    dominationCount++;
                }
            }
            // Set the domination count for car1
            car1.setDominationCount(dominationCount);
        }
    }

    /**
     * Checks if car1 dominates car2 based on the Pareto efficiency criteria:
     * - car1's price must be less than or equal to car2's price
     * - car1's mileage must be less than or equal to car2's mileage
     * - car1's year must be greater than or equal to car2's year
     *
     * car1 is said to strictly dominate car2 if it is better in at least one attribute.
     *
     * @param car1 The first car to be compared
     * @param car2 The second car to be compared
     * @return true if car1 dominates car2, false otherwise
     */
    private static boolean dominates(Car car1, Car car2) {
        // Check if car1 is better or equal in all attributes
        boolean allBetterOrEqual = (car1.getPrice() <= car2.getPrice()) &&
                (car1.getMileage() <= car2.getMileage()) &&
                (car1.getYear() >= car2.getYear());

        // Check if car1 is strictly better in at least one attribute
        boolean strictlyBetter = (car1.getPrice() < car2.getPrice()) ||
                (car1.getMileage() < car2.getMileage()) ||
                (car1.getYear() > car2.getYear());

        return allBetterOrEqual && strictlyBetter;
    }
}
