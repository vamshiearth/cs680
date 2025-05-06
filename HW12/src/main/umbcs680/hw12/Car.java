package umbcs680.hw12;

public class Car {
    private String model;
    private String make;
    private int price;
    private int year;
    private int mileage;
    private int dominationCount;

    public Car(String model, String make, int price, int year, int mileage) {
        this.model = model;
        this.make = make;
        this.price = price;
        this.year = year;
        this.mileage = mileage;
        this.dominationCount = 0; // Default domination count
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominationCount(int dominationCount) {
        this.dominationCount = dominationCount;
    }

    @Override
    public String toString() {
        return String.format("Car[Model: %s, Make: %s, Price: %d, Year: %d, Mileage: %d, Domination: %d]",
                model, make, price, year, mileage, dominationCount);
    }
}
