package umbcs680.hw13;

import junit.framework.TestCase;

public class ImageTest extends TestCase {

    public void testGetHeight() {
        Image image = new Image(3, 5);
        assertEquals(3, image.getHeight());
    }

    public void testGetWidth() {
        Image image = new Image(3, 5);
        assertEquals(5, image.getWidth());
    }

    public void testSetColor() {
        Image image = new Image(1, 1);
        Color red = new Color(255, 0, 0);

        image.setColor(0, 0, red);
        Color result = image.getColor(0, 0);

        assertEquals(255, result.getRedScale());
        assertEquals(0, result.getGreenScale());
        assertEquals(0, result.getBlueScale());
    }

    public void testGetColor() {
        Image image = new Image(3, 3);

        Color green = new Color(0, 255, 0);
        Color blue = new Color(0, 0, 255);

        image.setColor(1, 1, green);
        image.setColor(2, 2, blue);

        Color c1 = image.getColor(1, 1);
        assertEquals(0, c1.getRedScale());
        assertEquals(255, c1.getGreenScale());
        assertEquals(0, c1.getBlueScale());

        Color c2 = image.getColor(2, 2);
        assertEquals(0, c2.getRedScale());
        assertEquals(0, c2.getGreenScale());
        assertEquals(255, c2.getBlueScale());
    }
}
