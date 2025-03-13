package umbcs680.prime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Unit tests for the SingletonPrimeGenerator class.
 * This class ensures that the generator behaves as expected, including correct prime generation,
 * handling of invalid ranges, and maintaining singleton properties.
 */
class SingletonPrimeGeneratorTest {

    // Reference to the SingletonPrimeGenerator instance
    private SingletonPrimeGenerator generator;

    /**
     * Initializes the singleton instance before each test case is executed.
     * This ensures that the tests operate on a fresh instance each time.
     */
    @BeforeEach
    void setUp() {
        generator = SingletonPrimeGenerator.getInstance();
    }

    /**
     * Test that calling getInstance() returns a non-null value.
     */
    @Test
    void testGetInstanceNotNull() {
        assertNotNull(generator, "The singleton instance should not be null.");
    }

    /**
     * Test that calling getInstance() multiple times returns the same instance.
     */
    @Test
    void testGetInstanceReturnsIdenticalInstance() {
        SingletonPrimeGenerator anotherInstance = SingletonPrimeGenerator.getInstance();
        assertSame(generator, anotherInstance, "getInstance() should return the same instance each time.");
    }

    /**
     * Test that setting a valid range does not throw any exceptions.
     * Ensures that the range-setting method works correctly for valid inputs.
     */
    @Test
    void setRange() {
        assertDoesNotThrow(() -> generator.setRange(10, 50),
                "Valid range should not throw exceptions");
    }

    /**
     * Test that the prime generator correctly identifies and returns primes
     * within a given valid range (20 to 30).
     */
    @Test
    void testGetGeneratedPrimes() {
        // Set the range and generate primes within it
        generator.setRange(20, 30);
        generator.generatePrimes();

        // Expected prime numbers within the range [20, 30]
        List<Long> expectedPrimes = List.of(23L, 29L);

        // Verify that the generated primes match the expected list
        assertIterableEquals(expectedPrimes, generator.getGeneratedPrimes(),
                "The generated primes should match the expected list from 20 to 30.");
    }

    /**
     * Test that the generator handles ranges with no prime numbers correctly.
     * Example: The range [90, 96] contains no prime numbers.
     */
    @Test
    void testGeneratePrimesEmptyRange() {
        // Set a range with no primes
        generator.setRange(90, 96);
        generator.generatePrimes();

        // Expected result: an empty list of primes
        List<Long> expectedPrimes = List.of();

        // Verify that the generated primes match the expected empty list
        assertIterableEquals(expectedPrimes, generator.getGeneratedPrimes(),
                "There should be no primes in the range 90 to 96.");
    }

    /**
     * Test that the generator throws an IllegalArgumentException for invalid ranges.
     * Example invalid ranges: [-10, 10], [-10, -5], [100, 1].
     */
    @Test
    void testInvalidRanges() {
        // Test invalid range [-10, 10]
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            generator.setRange(-10, 10);
        });
        assertEquals("Invalid range between -10 10", exception1.getMessage(), "Expected exception message for [-10, 10].");

        // Test invalid range [-10, -5]
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            generator.setRange(-10, -5);
        });
        assertEquals("Invalid range between -10 -5", exception2.getMessage(), "Expected exception message for [-10, -5].");

        // Test invalid range [100, 1]
        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> {
            generator.setRange(100, 1);
        });
        assertEquals("Invalid range between 100 1", exception3.getMessage(), "Expected exception message for [100, 1].");
    }

    @Test
    void testStringEqualityAndIdentity() {
        String expected = "prime";
        String actual = "prime".substring(0, 5);

        assertEquals(expected, actual); // Should PASS
        assertSame(expected, actual); // Should FAIL, because actual is a new String instance
    }

}
