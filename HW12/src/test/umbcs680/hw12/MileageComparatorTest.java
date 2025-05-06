package umbcs680.hw12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MileageComparatorTest {

    @Test
    void compare() {
        // Arrange: Create a list of Car objects with varying mileage
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Model X", "Tesla", 90000, 2022, 10000));
        carList.add(new Car("Civic", "Honda", 20000, 2020, 30000));
        carList.add(new Car("Corolla", "Toyota", 18000, 2021, 25000));
        carList.add(new Car("Mustang", "Ford", 55000, 2019, 15000));
        carList.add(new Car("Accord", "Honda", 25000, 2018, 35000));

        /**
         * Act: Sort the car list by mileage in ascending order using Comparator.comparing.
         */
        Collections.sort(carList, Comparator.comparing(Car::getMileage));

        // Assert: Verify the order of cars based on mileage (ascending)
        assertEquals("Model X", carList.get(0).getModel(), "First car should be 'Model X' (lowest mileage)");
        assertEquals("Mustang", carList.get(1).getModel(), "Second car should be 'Mustang'");
        assertEquals("Corolla", carList.get(2).getModel(), "Third car should be 'Corolla'");
        assertEquals("Civic", carList.get(3).getModel(), "Fourth car should be 'Civic'");
        assertEquals("Accord", carList.get(4).getModel(), "Fifth car should be 'Accord' (highest mileage)");

        /**
         * Act: Sort the car list by mileage in descending order using Comparator.comparing with reversed().
         */
        Collections.sort(carList, Comparator.comparing(Car::getMileage).reversed());

        // Assert: Verify the order of cars based on mileage (descending)
        assertEquals("Accord", carList.get(0).getModel(), "First car should be 'Accord' (highest mileage)");
        assertEquals("Civic", carList.get(1).getModel(), "Second car should be 'Civic'");
        assertEquals("Corolla", carList.get(2).getModel(), "Third car should be 'Corolla'");
        assertEquals("Mustang", carList.get(3).getModel(), "Fourth car should be 'Mustang'");
        assertEquals("Model X", carList.get(4).getModel(), "Fifth car should be 'Model X' (lowest mileage)");
    }
}
