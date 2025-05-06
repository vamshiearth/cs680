package umbcs680.hw13;

import org.junit.Test;
import static org.junit.Assert.*;

public class ColorTest {

    @Test
    public void testGetRedScale() {
        Color color = new Color(120, 80, 40);
        assertEquals(120, color.getRedScale());
    }

    @Test
    public void testGetGreenScale() {
        Color color = new Color(120, 80, 40);
        assertEquals(80, color.getGreenScale());
    }

    @Test
    public void testGetBlueScale() {
        Color color = new Color(120, 80, 40);
        assertEquals(40, color.getBlueScale());
    }

    @Test
    public void testAdjustRedToGrayscale() {
        Color red = new Color(255, 0, 0);
        ColorAdjuster grayscale = (c) -> {
            int avg = (c.getRedScale() + c.getGreenScale() + c.getBlueScale()) / 3;
            return new Color(avg, avg, avg);
        };
        Color adjusted = grayscale.adjust(red);
        int expected = (255 + 0 + 0) / 3;
        assertEquals(expected, adjusted.getRedScale());
        assertEquals(expected, adjusted.getGreenScale());
        assertEquals(expected, adjusted.getBlueScale());
    }

    @Test
    public void testAdjustGreenToGrayscale() {
        Color green = new Color(0, 255, 0);
        ColorAdjuster grayscale = (c) -> {
            int avg = (c.getRedScale() + c.getGreenScale() + c.getBlueScale()) / 3;
            return new Color(avg, avg, avg);
        };
        Color adjusted = grayscale.adjust(green);
        int expected = (0 + 255 + 0) / 3;
        assertEquals(expected, adjusted.getRedScale());
        assertEquals(expected, adjusted.getGreenScale());
        assertEquals(expected, adjusted.getBlueScale());
    }

    @Test
    public void testAdjustBlueToGrayscale() {
        Color blue = new Color(0, 0, 255);
        ColorAdjuster grayscale = (c) -> {
            int avg = (c.getRedScale() + c.getGreenScale() + c.getBlueScale()) / 3;
            return new Color(avg, avg, avg);
        };
        Color adjusted = grayscale.adjust(blue);
        int expected = (0 + 0 + 255) / 3;
        assertEquals(expected, adjusted.getRedScale());
        assertEquals(expected, adjusted.getGreenScale());
        assertEquals(expected, adjusted.getBlueScale());
    }
}
