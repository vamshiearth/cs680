package umbcs680.hw09;

import org.junit.jupiter.api.Test;
import umbcs680.hw09.util.Images;

import static org.junit.jupiter.api.Assertions.*;

class GrayScaleAdjusterTest {

    @Test
    void adjust() {
        // Create the input image (1x1) with a test color
        Image input = new Image(1, 1);
        input.setColor(0, 0, new Color(255, 100, 50)); // avg = 135

        // Apply grayscale transformation
        Image output = Images.transform(input, new GrayScaleAdjuster());

        int expected = (255 + 100 + 50) / 3;
        Color result = output.getColor(0, 0);

        assertEquals(expected, result.getRedScale());
        assertEquals(expected, result.getGreenScale());
        assertEquals(expected, result.getBlueScale());
    }

    @Test
    void adjustRedToGray() {
        Image input = new Image(1, 1);
        input.setColor(0, 0, new Color(255, 0, 0)); // Pure red

        Image output = Images.transform(input, new GrayScaleAdjuster());
        int expected = (255 + 0 + 0) / 3;
        Color result = output.getColor(0, 0);

        assertEquals(expected, result.getRedScale());
        assertEquals(expected, result.getGreenScale());
        assertEquals(expected, result.getBlueScale());
    }

    @Test
    void adjustGreenToGray() {
        Image input = new Image(1, 1);
        input.setColor(0, 0, new Color(0, 255, 0)); // Pure green

        Image output = Images.transform(input, new GrayScaleAdjuster());
        int expected = (0 + 255 + 0) / 3;
        Color result = output.getColor(0, 0);

        assertEquals(expected, result.getRedScale());
        assertEquals(expected, result.getGreenScale());
        assertEquals(expected, result.getBlueScale());
    }

    @Test
    void adjustBlueToGray() {
        Image input = new Image(1, 1);
        input.setColor(0, 0, new Color(0, 0, 255)); // Pure blue

        Image output = Images.transform(input, new GrayScaleAdjuster());
        int expected = (0 + 0 + 255) / 3;
        Color result = output.getColor(0, 0);

        assertEquals(expected, result.getRedScale());
        assertEquals(expected, result.getGreenScale());
        assertEquals(expected, result.getBlueScale());
    }
}
