package umbcs680.hw10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceComparatorTest {

    /**
     * Test method for comparing two cars based on their price using the PriceComparator.
     */
    @Test
    void compare() {
        // Arrange: Create two cars with different price values
        Car car1 = new Car("ModelX", "Tesla", 80000, 2021, 15000);
        Car car2 = new Car("Corolla", "Toyota", 20000, 2019, 30000);

        // Create an instance of the PriceComparator
        PriceComparator comparator = new PriceComparator();

        // Act & Assert: Test when car1 is more expensive than car2
        assertTrue(comparator.compare(car1, car2) > 0, "Car1 should be more expensive than Car2");

        // Act & Assert: Test when car2 is less expensive than car1
        assertTrue(comparator.compare(car2, car1) < 0, "Car2 should be less expensive than Car1");

        // Act & Assert: Test when both cars have the same price
        Car car3 = new Car("Civic", "Honda", 80000, 2020, 25000);
        assertEquals(0, comparator.compare(car1, car3), "Cars with the same price should return 0");
    }
}
