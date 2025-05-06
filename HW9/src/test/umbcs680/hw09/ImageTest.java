package umbcs680.hw09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {

    /**
     * Test the getHeight() method of the Image class.
     * This test ensures that the getHeight method correctly returns the height of the image.
     */
    @Test
    void getHeight() {
        // Arrange: Create an image of height 10 and width 15
        Image image = new Image(10, 15);

        // Act: Get the height of the image
        int height = image.getHeight();

        // Assert: Check that the height is 10
        assertEquals(10, height, "Height should be 10");
    }

    /**
     * Test the getWidth() method of the Image class.
     * This test ensures that the getWidth method correctly returns the width of the image.
     */
    @Test
    void getWidth() {
        // Arrange: Create an image of height 10 and width 15
        Image image = new Image(10, 15);

        // Act: Get the width of the image
        int width = image.getWidth();

        // Assert: Check that the width is 15
        assertEquals(15, width, "Width should be 15");
    }

    /**
     * Test the getColor() method of the Image class.
     * This test ensures that the getColor method correctly retrieves the color of a specified pixel.
     */
    @Test
    void getColor() {
        // Arrange: Create a 5x5 image and set a color at position (2, 3)
        Image image = new Image(5, 5);
        Color expectedColor = new Color(100, 150, 200); // Create a color to set
        image.setColor(2, 3, expectedColor); // Set color at position (2, 3)

        // Act: Retrieve the color at position (2, 3)
        Color actualColor = image.getColor(2, 3);

        // Assert: Check if the retrieved color matches the expected color
        assertEquals(expectedColor.getRedScale(), actualColor.getRedScale(), "Red scale should match");
        assertEquals(expectedColor.getGreenScale(), actualColor.getGreenScale(), "Green scale should match");
        assertEquals(expectedColor.getBlueScale(), actualColor.getBlueScale(), "Blue scale should match");
    }

    /**
     * Test the setColor() method of the Image class.
     * This test ensures that the setColor method correctly updates the color of a specified pixel.
     */
    @Test
    void setColor() {
        // Arrange: Create a 5x5 image and define a new color to set
        Image image = new Image(5, 5);
        Color newColor = new Color(50, 75, 100); // New color to set at a specific position

        // Act: Set the new color at position (1, 1) and retrieve it
        image.setColor(1, 1, newColor); // Set color at position (1, 1)
        Color actualColor = image.getColor(1, 1); // Get color at position (1, 1)

        // Assert: Check if the set color matches the expected new color
        assertEquals(newColor.getRedScale(), actualColor.getRedScale(), "Red scale should match");
        assertEquals(newColor.getGreenScale(), actualColor.getGreenScale(), "Green scale should match");
        assertEquals(newColor.getBlueScale(), actualColor.getBlueScale(), "Blue scale should match");
    }
}
