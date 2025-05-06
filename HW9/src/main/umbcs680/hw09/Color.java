package umbcs680.hw09;

public class Color {
    private int redScale;
    private int greenScale;
    private int blueScale;

    /**
     * Constructor to initialize the color with specified RGB values.
     *
     * @param r the red scale value (0-255)
     * @param g the green scale value (0-255)
     * @param b the blue scale value (0-255)
     */
    public Color(int r, int g, int b) {
        this.redScale = r;  // Set the red scale value
        this.greenScale = g;  // Set the green scale value
        this.blueScale = b;  // Set the blue scale value
    }

    /**
     * Getter method for the red scale value.
     *
     * @return the red scale value
     */
    public int getRedScale() {
        return redScale;  // Return the red scale value
    }

    /**
     * Getter method for the green scale value.
     *
     * @return the green scale value
     */
    public int getGreenScale() {
        return greenScale;  // Return the green scale value
    }

    /**
     * Getter method for the blue scale value.
     *
     * @return the blue scale value
     */
    public int getBlueScale() {
        return blueScale;  // Return the blue scale value
    }
}
