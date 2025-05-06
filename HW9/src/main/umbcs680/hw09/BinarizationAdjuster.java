package umbcs680.hw09;

public class BinarizationAdjuster implements ColorAdjuster {

    /**
     * Adjusts the given color by applying binarization.
     * First converts the color to grayscale, then sets it to either black or white.
     * - Black if the grayscale value is <= 125.
     * - White if the grayscale value is > 125.
     *
     * @param color the color to be adjusted
     * @return a new Color object that is either black or white
     */
    @Override
    public Color adjust(Color color) {
        // Convert the color to grayscale
        int r = color.getRedScale();
        int g = color.getGreenScale();
        int b = color.getBlueScale();
        int avg = (r + g + b) / 3;

        // Determine if the pixel should be black or white
        if (avg <= 125) {
            return new Color(0, 0, 0); // Black
        } else {
            return new Color(255, 255, 255); // White
        }
    }
}
