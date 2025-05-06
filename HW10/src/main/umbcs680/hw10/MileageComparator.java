package umbcs680.hw10;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car> {

    /**
     * Compares two Car objects based on their mileage.
     * The comparison is done in ascending order, meaning the car with lower mileage comes first.
     *
     * @param car1 The first car to be compared
     * @param car2 The second car to be compared
     * @return A negative integer if car1 has less mileage than car2,
     *         zero if they have the same mileage,
     *         or a positive integer if car1 has more mileage than car2
     */
    @Override
    public int compare(Car car1, Car car2) {
        // Compare the mileage of two cars and return the comparison result
        return Integer.compare(car1.getMileage(), car2.getMileage());
    }
}
