package umbcs680.hw09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    /**
     * Test the getRedScale() method of the Color class.
     * This test ensures that the red color scale is correctly retrieved.
     */
    @Test
    void getRedScale() {
        // Arrange: Create a Color object with specific RGB values (255, 100, 50)
        Color color = new Color(255, 100, 50);

        // Act: Retrieve the red scale value of the color
        int red = color.getRedScale();

        // Assert: Verify that the red scale value is correctly returned as 255
        assertEquals(255, red, "Red scale value should be 255");
    }

    /**
     * Test the getGreenScale() method of the Color class.
     * This test ensures that the green color scale is correctly retrieved.
     */
    @Test
    void getGreenScale() {
        // Arrange: Create a Color object with specific RGB values (255, 100, 50)
        Color color = new Color(255, 100, 50);

        // Act: Retrieve the green scale value of the color
        int green = color.getGreenScale();

        // Assert: Verify that the green scale value is correctly returned as 100
        assertEquals(100, green, "Green scale value should be 100");
    }

    /**
     * Test the getBlueScale() method of the Color class.
     * This test ensures that the blue color scale is correctly retrieved.
     */
    @Test
    void getBlueScale() {
        // Arrange: Create a Color object with specific RGB values (255, 100, 50)
        Color color = new Color(255, 100, 50);

        // Act: Retrieve the blue scale value of the color
        int blue = color.getBlueScale();

        // Assert: Verify that the blue scale value is correctly returned as 50
        assertEquals(50, blue, "Blue scale value should be 50");
    }
}
