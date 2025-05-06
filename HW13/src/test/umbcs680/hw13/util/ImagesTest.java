package umbcs680.hw13.util;

import umbcs680.hw13.Color;
import umbcs680.hw13.ColorAdjuster;
import umbcs680.hw13.Image;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

class ImagesTest {

    @Test
    void transform() {
        Image input = new Image(1, 1);
        input.setColor(0, 0, new Color(100, 150, 200));

        ColorAdjuster grayscale = (color) -> {
            int avg = (color.getRedScale() + color.getGreenScale() + color.getBlueScale()) / 3;
            return new Color(avg, avg, avg);
        };

        Image result = Images.transform(input, grayscale);
        Color outputColor = result.getColor(0, 0);
        int expected = (100 + 150 + 200) / 3;

        assertEquals(expected, outputColor.getRedScale());
        assertEquals(expected, outputColor.getGreenScale());
        assertEquals(expected, outputColor.getBlueScale());
    }
}
