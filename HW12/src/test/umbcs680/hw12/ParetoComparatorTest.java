package umbcs680.hw12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParetoComparatorTest {

    @Test
    void computeDominationCounts() {
        // Arrange: Create a list of Car objects with varying attributes
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Model X", "Tesla", 90000, 2022, 10000)); // Domination Count: 1
        carList.add(new Car("Civic", "Honda", 20000, 2020, 30000));   // Domination Count: 3
        carList.add(new Car("Corolla", "Toyota", 18000, 2021, 25000));// Domination Count: 2
        carList.add(new Car("Mustang", "Ford", 55000, 2019, 15000));  // Domination Count: 0
        carList.add(new Car("Accord", "Honda", 25000, 2018, 35000));  // Domination Count: 4

        // Simulate domination counts
        carList.get(0).setDominationCount(1); // Model X
        carList.get(1).setDominationCount(3); // Civic
        carList.get(2).setDominationCount(2); // Corolla
        carList.get(3).setDominationCount(0); // Mustang
        carList.get(4).setDominationCount(4); // Accord

        /**
         * Act: Sort the car list by domination count in ascending order using Comparator.comparing.
         */
        Collections.sort(carList, Comparator.comparing(Car::getDominationCount));

        // Assert: Verify the order of cars based on domination count (ascending)
        assertEquals("Mustang", carList.get(0).getModel(), "First car should be 'Mustang' (lowest domination count).");
        assertEquals("Model X", carList.get(1).getModel(), "Second car should be 'Model X'.");
        assertEquals("Corolla", carList.get(2).getModel(), "Third car should be 'Corolla'.");
        assertEquals("Civic", carList.get(3).getModel(), "Fourth car should be 'Civic'.");
        assertEquals("Accord", carList.get(4).getModel(), "Fifth car should be 'Accord' (highest domination count).");

        /**
         * Act: Sort the car list by domination count in descending order using Comparator.comparing with reversed().
         */
        Collections.sort(carList, Comparator.comparing(Car::getDominationCount).reversed());

        // Assert: Verify the order of cars based on domination count (descending)
        assertEquals("Accord", carList.get(0).getModel(), "First car should be 'Accord' (highest domination count).");
        assertEquals("Civic", carList.get(1).getModel(), "Second car should be 'Civic'.");
        assertEquals("Corolla", carList.get(2).getModel(), "Third car should be 'Corolla'.");
        assertEquals("Model X", carList.get(3).getModel(), "Fourth car should be 'Model X'.");
        assertEquals("Mustang", carList.get(4).getModel(), "Fifth car should be 'Mustang' (lowest domination count).");
    }
}
