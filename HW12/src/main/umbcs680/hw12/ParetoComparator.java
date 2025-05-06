package umbcs680.hw12;

import java.util.List;

public class ParetoComparator {

    public static void computeDominationCounts(List<Car> cars) {
        for (Car car1 : cars) {
            int dominationCount = 0;
            for (Car car2 : cars) {
                if (dominates(car2, car1)) {
                    dominationCount++;
                }
            }
            car1.setDominationCount(dominationCount);
        }
    }

    private static boolean dominates(Car car1, Car car2) {
        // Checks if car1 dominates car2
        boolean allBetterOrEqual = (car1.getPrice() <= car2.getPrice()) &&
                (car1.getMileage() <= car2.getMileage()) &&
                (car1.getYear() >= car2.getYear());

        boolean strictlyBetter = (car1.getPrice() < car2.getPrice()) ||
                (car1.getMileage() < car2.getMileage()) ||
                (car1.getYear() > car2.getYear());

        return allBetterOrEqual && strictlyBetter;
    }
}
