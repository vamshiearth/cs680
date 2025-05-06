package umbcs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MileageComparatorTest {

    /**
     * Test method to compare and sort a list of cars by mileage.
     */
    @Test
    void compare() {
        // Arrange: Create a list of cars with different mileage values
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ModelX", "Tesla", 80000, 2021, 15000));
        cars.add(new Car("Corolla", "Toyota", 20000, 2019, 30000));
        cars.add(new Car("Civic", "Honda", 22000, 2020, 25000));
        cars.add(new Car("Mustang", "Ford", 55000, 2018, 20000));

        // Act: Sort the cars by mileage using the MileageComparator
        Collections.sort(cars, new MileageComparator());

        // Assert: Verify that the cars are sorted by mileage in ascending order
        assertEquals(15000, cars.get(0).getMileage()); // The car with the lowest mileage
        assertEquals(30000, cars.get(3).getMileage()); // The car with the highest mileage
    }

    /**
     * Test method to compare and sort a list of cars by price.
     */
    @Test
    void sortByPrice() {
        // Arrange: Create a list of cars with different price values
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ModelX", "Tesla", 80000, 2021, 15000));
        cars.add(new Car("Corolla", "Toyota", 20000, 2019, 30000));
        cars.add(new Car("Civic", "Honda", 22000, 2020, 25000));
        cars.add(new Car("Mustang", "Ford", 55000, 2018, 20000));

        // Act: Sort the cars by price using the PriceComparator
        Collections.sort(cars, new PriceComparator());

        // Assert: Verify that the cars are sorted by price in ascending order
        assertEquals(20000, cars.get(0).getPrice()); // The car with the lowest price
        assertEquals(80000, cars.get(3).getPrice()); // The car with the highest price
    }

    /**
     * Test method to compare and sort a list of cars by year.
     */
    @Test
    void sortByYear() {
        // Arrange: Create a list of cars with different years
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ModelX", "Tesla", 80000, 2021, 15000));
        cars.add(new Car("Corolla", "Toyota", 20000, 2019, 30000));
        cars.add(new Car("Civic", "Honda", 22000, 2020, 25000));
        cars.add(new Car("Mustang", "Ford", 55000, 2018, 20000));

        // Act: Sort the cars by year using the YearComparator (in descending order)
        Collections.sort(cars, new YearComparator());

        // Assert: Verify that the cars are sorted by year in descending order (newest first)
        assertEquals(2021, cars.get(0).getYear()); // The newest car
        assertEquals(2018, cars.get(3).getYear()); // The oldest car
    }

    /**
     * Test method to compare and sort a list of cars by Pareto domination counts.
     */
    @Test
    void sortByPareto() {
        // Arrange: Create a list of cars with different attributes
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ModelX", "Tesla", 80000, 2021, 15000));
        cars.add(new Car("Corolla", "Toyota", 20000, 2019, 30000));
        cars.add(new Car("Civic", "Honda", 22000, 2020, 25000));
        cars.add(new Car("Mustang", "Ford", 55000, 2018, 20000));

        // Act: Compute the domination counts for each car using the ParetoComparator
        ParetoComparator.computeDominationCounts(cars);

        // Act: Sort the cars by their domination count using the ParetoComparator
        Collections.sort(cars, new ParetoComparator());

        // Assert: Verify that the cars are sorted by domination count in ascending order
        assertEquals(0, cars.get(0).getDominationCount()); // Best car has the lowest domination count
        assertFalse(cars.get(3).getDominationCount() > cars.get(0).getDominationCount()); // Worst car should have higher domination count
    }
}
