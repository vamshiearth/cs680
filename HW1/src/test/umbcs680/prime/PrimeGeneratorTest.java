package umbcs680.prime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

/**
 * Unit tests for the PrimeGenerator class.
 */
class PrimeGeneratorTest {

    /**
     * Tests the getPrimes() method to ensure it returns the correct prime numbers
     * in the specified range.
     */
    @Test
    void getPrimes() {
        // Create a PrimeGenerator instance for the range 1 to 10
        PrimeGenerator gen = new PrimeGenerator(30, 45);
        gen.generatePrimes();  // Generate the primes within the given range

        // Expected prime numbers between 30 and 60
        LinkedList<Long> expectedPrimes = new LinkedList<>();
        expectedPrimes.add(31L);
        expectedPrimes.add(37L);
        expectedPrimes.add(41L);
        expectedPrimes.add(43L);

        // Assert that the generated primes match the expected list
        assertEquals(expectedPrimes, gen.getPrimes(),
                "Primes in the given range is not matching");
    }

    /**
     * Tests the protected isPrime() method to verify it correctly identifies
     * whether a given number is prime.
     */
    @Test
    void isPrime() {
        // Create a PrimeGenerator instance (range doesn't matter for this test)
        PrimeGenerator gen = new PrimeGenerator(30, 45);

        // Test known prime and non-prime numbers
        assertTrue(gen.isPrime(41), "41 should be prime");
        assertTrue(gen.isPrime(37), "37 should be prime");
        assertFalse(gen.isPrime(40), "40 should not be prime");
    }

    /**
     * Tests the generatePrimes() method to ensure it correctly generates and stores
     * all prime numbers within the specified range.
     */
    @Test
    void generatePrimes() {
        // Create a PrimeGenerator instance for the range 1 to 10
        PrimeGenerator gen = new PrimeGenerator(30, 45);
        gen.generatePrimes();  // Generate the primes

        // Retrieve the list of generated primes
        LinkedList<Long> primes = gen.getPrimes();

        // Assert that the correct number of primes was generated
        assertEquals(4, primes.size(),
                "No. of primes is not matched");

        // Assert that the specific primes 2, 3, 5, and 7 are present
        assertTrue(primes.contains(31L), "Prime List should have 31");
        assertTrue(primes.contains(37L), "Prime List should have 37");
        assertTrue(primes.contains(41L), "Prime List should have 41");
        assertTrue(primes.contains(43L), "Prime List should have 43");
    }
}
