package umbcs680.hw12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceComparatorTest {

    @Test
    void compare() {
        // Arrange: Create a list of Car objects with varying prices
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Model X", "Tesla", 90000, 2022, 10000)); // Price: 90,000
        carList.add(new Car("Civic", "Honda", 20000, 2020, 30000));   // Price: 20,000
        carList.add(new Car("Corolla", "Toyota", 18000, 2021, 25000));// Price: 18,000
        carList.add(new Car("Mustang", "Ford", 55000, 2019, 15000));  // Price: 55,000
        carList.add(new Car("Accord", "Honda", 25000, 2018, 35000));  // Price: 25,000

        /**
         * Act: Sort the car list by price in ascending order using Comparator.comparing.
         */
        Collections.sort(carList, Comparator.comparing(Car::getPrice));

        // Assert: Verify the order of cars based on price (ascending)
        assertEquals("Corolla", carList.get(0).getModel(), "First car should be 'Corolla' (lowest price).");
        assertEquals("Civic", carList.get(1).getModel(), "Second car should be 'Civic'.");
        assertEquals("Accord", carList.get(2).getModel(), "Third car should be 'Accord'.");
        assertEquals("Mustang", carList.get(3).getModel(), "Fourth car should be 'Mustang'.");
        assertEquals("Model X", carList.get(4).getModel(), "Fifth car should be 'Model X' (highest price).");

        /**
         * Act: Sort the car list by price in descending order using Comparator.comparing with reversed().
         */
        Collections.sort(carList, Comparator.comparing(Car::getPrice).reversed());

        // Assert: Verify the order of cars based on price (descending)
        assertEquals("Model X", carList.get(0).getModel(), "First car should be 'Model X' (highest price).");
        assertEquals("Mustang", carList.get(1).getModel(), "Second car should be 'Mustang'.");
        assertEquals("Accord", carList.get(2).getModel(), "Third car should be 'Accord'.");
        assertEquals("Civic", carList.get(3).getModel(), "Fourth car should be 'Civic'.");
        assertEquals("Corolla", carList.get(4).getModel(), "Fifth car should be 'Corolla' (lowest price).");
    }
}
