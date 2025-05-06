package umbcs680.hw12;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    /**
     * Creates and returns a list of sample Car objects for testing.
     * @return List of Car objects.
     */
    private List<Car> createCarList() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Model X", "Tesla", 90000, 2022, 10000)); // Price: 90,000, Year: 2022, Mileage: 10,000
        carList.add(new Car("Civic", "Honda", 20000, 2020, 30000));   // Price: 20,000, Year: 2020, Mileage: 30,000
        carList.add(new Car("Corolla", "Toyota", 18000, 2021, 25000));// Price: 18,000, Year: 2021, Mileage: 25,000
        carList.add(new Car("Mustang", "Ford", 55000, 2019, 15000));  // Price: 55,000, Year: 2019, Mileage: 15,000
        carList.add(new Car("Accord", "Honda", 25000, 2018, 35000));  // Price: 25,000, Year: 2018, Mileage: 35,000
        return carList;
    }

    /**
     * Tests sorting of cars by price in both ascending and descending order.
     */
    @Test
    void sortByPrice() {
        List<Car> carList = createCarList();

        // Sort by price in ascending order using Comparator.comparing
        Collections.sort(carList, Comparator.comparing(Car::getPrice));

        assertEquals("Corolla", carList.get(0).getModel(), "First car should be 'Corolla' (lowest price).");
        assertEquals("Model X", carList.get(carList.size() - 1).getModel(), "Last car should be 'Model X' (highest price).");

        // Sort by price in descending order using reversed Comparator
        Collections.sort(carList, Comparator.comparing(Car::getPrice).reversed());

        assertEquals("Model X", carList.get(0).getModel(), "First car should be 'Model X' (highest price).");
        assertEquals("Corolla", carList.get(carList.size() - 1).getModel(), "Last car should be 'Corolla' (lowest price).");
    }

    /**
     * Tests sorting of cars by manufacturing year in both ascending and descending order.
     */
    @Test
    void sortByYear() {
        /** Create a list of sample Car objects for testing. */
        List<Car> carList = createCarList();

        /**
         * Sort the car list by year in ascending order using Comparator.comparing.
         * This replaces the lambda expression with a cleaner and more concise syntax.
         */
        Collections.sort(carList, Comparator.comparing(Car::getYear));

        assertEquals("Accord", carList.get(0).getModel(), "First car should be 'Accord' (oldest year).");
        assertEquals("Model X", carList.get(carList.size() - 1).getModel(), "Last car should be 'Model X' (newest year).");

        /**
         * Sort the car list by year in descending order using Comparator.comparing with reversed().
         * This reverses the natural order to sort the list from the newest year to the oldest year.
         */
        Collections.sort(carList, Comparator.comparing(Car::getYear).reversed());
        assertEquals("Model X", carList.get(0).getModel(), "First car should be 'Model X' (newest year).");
        assertEquals("Accord", carList.get(carList.size() - 1).getModel(), "Last car should be 'Accord' (oldest year).");

    }

    /**
     * Tests sorting of cars by mileage in both ascending and descending order.
     */
    @Test
    void sortByMileage() {
        List<Car> carList = createCarList();

        /**
         * Sort the car list by mileage in ascending order using Comparator.comparing.
         * This replaces the lambda expression with a cleaner syntax.
         */
        Collections.sort(carList, Comparator.comparing(Car::getMileage));

        assertEquals("Model X", carList.get(0).getModel(), "First car should be 'Model X' (lowest mileage).");
        assertEquals("Accord", carList.get(carList.size() - 1).getModel(), "Last car should be 'Accord' (highest mileage).");

        /**
         * Sort the car list by mileage in descending order using Comparator.comparing with reversed().
         * This reverses the natural order for sorting.
         */
        Collections.sort(carList, Comparator.comparing(Car::getMileage).reversed());
        assertEquals("Accord", carList.get(0).getModel(), "First car should be 'Accord' (highest mileage).");
        assertEquals("Model X", carList.get(carList.size() - 1).getModel(), "Last car should be 'Model X' (lowest mileage).");
    }

    /**
     * Tests sorting of cars by Pareto domination count in ascending order.
     */
    @Test
    void sortByPareto() {
        List<Car> carList = createCarList();

        // Simulate domination count for each car
        carList.get(0).setDominationCount(1);  // Model X: Domination count = 1
        carList.get(1).setDominationCount(3);  // Civic: Domination count = 3
        carList.get(2).setDominationCount(2);  // Corolla: Domination count = 2
        carList.get(3).setDominationCount(0);  // Mustang: Domination count = 0
        carList.get(4).setDominationCount(4);  // Accord: Domination count = 4

        /**
         * Sort the car list by domination count in ascending order using Comparator.comparing.
         * This replaces the lambda expression for simplicity.
         */
        Collections.sort(carList, Comparator.comparing(Car::getDominationCount));

        assertEquals("Mustang", carList.get(0).getModel(), "First car should be 'Mustang' (lowest domination count).");
        assertEquals("Accord", carList.get(carList.size() - 1).getModel(), "Last car should be 'Accord' (highest domination count).");
    }

}
