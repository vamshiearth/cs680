package umbcs680.hw10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YearComparatorTest {

    /**
     * Test method for comparing two cars based on their year using the YearComparator.
     */
    @Test
    void compare() {
        // Arrange: Create two cars with different years
        Car car1 = new Car("ModelX", "Tesla", 80000, 2021, 15000);
        Car car2 = new Car("Corolla", "Toyota", 20000, 2019, 30000);

        // Create an instance of the YearComparator
        YearComparator comparator = new YearComparator();

        // Act & Assert: Test when car1 is newer than car2 (2021 is newer than 2019)
        assertTrue(comparator.compare(car1, car2) < 0, "Car1 (2021) should be newer than Car2 (2019)");

        // Act & Assert: Test when car2 is older than car1 (2019 is older than 2021)
        assertTrue(comparator.compare(car2, car1) > 0, "Car2 (2019) should be older than Car1 (2021)");

        // Act & Assert: Test when both cars have the same year
        Car car3 = new Car("Civic", "Honda", 22000, 2021, 25000);
        assertEquals(0, comparator.compare(car1, car3), "Cars with the same year (2021) should return 0");
    }
}
