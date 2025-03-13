package umbcs680.prime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * SingletonPrimeGenerator is a singleton class responsible for generating prime numbers
 * within a specified range. It ensures that only one instance of the generator exists
 * throughout the application.
 */
public class SingletonPrimeGenerator {
    // Static reference to the singleton instance
    private static SingletonPrimeGenerator instance;

    // Variables to store the lower and upper bounds for prime generation
    private long lowerBound, upperBound;

    // List to store the generated prime numbers
    private List<Long> primeNumbers = new ArrayList<>();

    /**
     * Private constructor to prevent external instantiation of this class.
     * This ensures that the Singleton pattern is enforced.
     */
    private SingletonPrimeGenerator() { }

    /**
     * Static method to provide the singleton instance.
     * Uses double-checked locking to ensure thread safety when initializing the instance.
     *
     * @return the singleton instance of SingletonPrimeGenerator
     */
    public static SingletonPrimeGenerator getInstance() {
        if (instance == null) { // First check (without locking)
            synchronized (SingletonPrimeGenerator.class) { // Locking block
                if (instance == null) { // Second check (after acquiring the lock)
                    instance = new SingletonPrimeGenerator();
                }
            }
        }
        return instance;
    }

    /**
     * Sets the range for prime number generation.
     *
     * @param from the lower bound (inclusive) of the range
     * @param to the upper bound (inclusive) of the range
     * @throws IllegalArgumentException if the range is invalid (e.g., negative or out of order)
     */
    public void setRange(long from, long to) {
        if (from >= 1 && to >= from) { // Valid range check
            this.lowerBound = from;
            this.upperBound = to;
        } else {
            throw new IllegalArgumentException("Invalid range between " + from + " " + to);
        }
    }

    /**
     * Returns a copy of the list of generated prime numbers to ensure encapsulation.
     *
     * @return a list containing all generated prime numbers within the specified range
     */
    public List<Long> getGeneratedPrimes() {
        return new ArrayList<>(primeNumbers); // Return a copy to avoid external modification
    }

    /**
     * Helper method to determine if a number is even.
     * Uses bitwise AND operation for better performance.
     *
     * @param number the number to check
     * @return true if the number is even, false otherwise
     */
    private boolean isEven(long number) {
        return (number & 1) == 0; // Bitwise check: even numbers have the last bit as 0
    }

    /**
     * Helper method to determine if a given number is prime.
     *
     * @param number the number to check for primality
     * @return true if the number is prime, false otherwise
     */
    private boolean isPrime(long number) {
        if (number <= 1) return false; // Numbers <= 1 are not prime
        if (number == 2) return true;  // 2 is the smallest prime number
        if (isEven(number)) return false; // Exclude all even numbers > 2

        // Check divisibility by odd numbers from 3 up to √number
        for (long i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false; // Not prime if divisible
        }
        return true; // Prime if no divisors found
    }

    /**
     * Generates prime numbers within the set range [lowerBound, upperBound].
     * Clears any previously generated primes before starting.
     */
    public void generatePrimes() {
        primeNumbers.clear(); // Clear previous results
        for (long num = lowerBound; num <= upperBound; num++) {
            if (isPrime(num)) { // Add only prime numbers to the list
                primeNumbers.add(num);
            }
        }
    }
}
