package umbcs680.hw09;

public class GrayScaleAdjuster implements ColorAdjuster {

    /**
     * Adjusts the given color to its grayscale equivalent.
     * The grayscale value is calculated as the average of the red, green, and blue values.
     *
     * @param color the color to be adjusted
     * @return a new Color object with the grayscale values
     */
    @Override
    public Color adjust(Color color) {
        // Get the RGB values from the original color
        int r = color.getRedScale();
        int g = color.getGreenScale();
        int b = color.getBlueScale();

        // Calculate the average of the red, green, and blue components
        int avg = (r + g + b) / 3;

        // Return a new Color object with the grayscale value for all three components
        return new Color(avg, avg, avg);  // Grayscale color: red = green = blue = avg
    }
}
