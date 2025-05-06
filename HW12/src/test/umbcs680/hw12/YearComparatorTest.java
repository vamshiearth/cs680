package umbcs680.hw12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YearComparatorTest {

    @Test
    void compare() {
        // Arrange: Create a list of Car objects with varying years
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Model X", "Tesla", 90000, 2022, 10000)); // Year: 2022
        carList.add(new Car("Civic", "Honda", 20000, 2020, 30000));   // Year: 2020
        carList.add(new Car("Corolla", "Toyota", 18000, 2021, 25000));// Year: 2021
        carList.add(new Car("Mustang", "Ford", 55000, 2019, 15000));  // Year: 2019
        carList.add(new Car("Accord", "Honda", 25000, 2018, 35000));  // Year: 2018

        /**
         * Act: Sort the car list by year in ascending order using Comparator.comparing.
         */
        Collections.sort(carList, Comparator.comparing(Car::getYear));

        // Assert: Verify the order of cars based on year (ascending)
        assertEquals("Accord", carList.get(0).getModel(), "First car should be 'Accord' (oldest year).");
        assertEquals("Mustang", carList.get(1).getModel(), "Second car should be 'Mustang'.");
        assertEquals("Civic", carList.get(2).getModel(), "Third car should be 'Civic'.");
        assertEquals("Corolla", carList.get(3).getModel(), "Fourth car should be 'Corolla'.");
        assertEquals("Model X", carList.get(4).getModel(), "Fifth car should be 'Model X' (newest year).");

        /**
         * Act: Sort the car list by year in descending order using Comparator.comparing with reversed().
         */
        Collections.sort(carList, Comparator.comparing(Car::getYear).reversed());

        // Assert: Verify the order of cars based on year (descending)
        assertEquals("Model X", carList.get(0).getModel(), "First car should be 'Model X' (newest year).");
        assertEquals("Corolla", carList.get(1).getModel(), "Second car should be 'Corolla'.");
        assertEquals("Civic", carList.get(2).getModel(), "Third car should be 'Civic'.");
        assertEquals("Mustang", carList.get(3).getModel(), "Fourth car should be 'Mustang'.");
        assertEquals("Accord", carList.get(4).getModel(), "Fifth car should be 'Accord' (oldest year).");
    }
}
