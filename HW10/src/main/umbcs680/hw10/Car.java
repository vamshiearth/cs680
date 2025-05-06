package umbcs680.hw10;

public class Car {
    // Instance variables for car details
    private String model;        // The model of the car (e.g., "Model S")
    private String make;         // The make or manufacturer of the car (e.g., "Tesla")
    private int price;           // Price of the car in dollars
    private int year;            // Manufacturing year of the car
    private int mileage;         // Mileage of the car in miles
    private int dominationCount; // Count of how many times the car has dominated in a certain context

    /**
     * Constructor to initialize a new Car object with the given details.
     * The dominationCount is set to 0 by default.
     *
     * @param model The model of the car (e.g., "Model S")
     * @param make The manufacturer of the car (e.g., "Tesla")
     * @param price The price of the car
     * @param year The manufacturing year of the car
     * @param mileage The mileage of the car
     */
    public Car(String model, String make, int price, int year, int mileage) {
        this.model = model;
        this.make = make;
        this.price = price;
        this.year = year;
        this.mileage = mileage;
        this.dominationCount = 0; // Default value for domination count
    }

    // Getter methods to retrieve car details
    public int getPrice() {
        return price; // Returns the price of the car
    }

    public int getYear() {
        return year; // Returns the manufacturing year of the car
    }

    public int getMileage() {
        return mileage; // Returns the mileage of the car
    }

    public int getDominationCount() {
        return dominationCount; // Returns the domination count
    }

    // Setter method to update domination count
    public void setDominationCount(int count) {
        this.dominationCount = count; // Sets the domination count to the given value
    }

    /**
     * Converts the Car object to a string representation for easy printing.
     *
     * @return A string that describes the car with model, make, price, year, mileage, and domination count.
     */
    @Override
    public String toString() {
        // Returns a formatted string with car details
        return String.format("Car[Model: %s, Make: %s, Price: %d, Year: %d, Mileage: %d, Domination: %d]",
                model, make, price, year, mileage, dominationCount);
    }
}
