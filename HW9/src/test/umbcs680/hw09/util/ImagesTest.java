package umbcs680.hw09.util;

import org.junit.jupiter.api.Test;
import umbcs680.hw09.Color;
import umbcs680.hw09.GrayScaleAdjuster;
import umbcs680.hw09.Image;

import static org.junit.jupiter.api.Assertions.*;

class ImagesTest {

    /**
     * Test the transform method of the Images class.
     * This test verifies that the transform method correctly applies a grayscale adjustment
     * to each pixel in the image using the GrayScaleAdjuster.
     */
    @Test
    void transform() {
        // Arrange: Create a 3x3 image and initialize its pixels with distinct colors
        Image originalImage = new Image(3, 3); // Create a 3x3 image
        originalImage.setColor(0, 0, new Color(255, 0, 0)); // Set red color at (0, 0)
        originalImage.setColor(0, 1, new Color(0, 255, 0)); // Set green color at (0, 1)
        originalImage.setColor(0, 2, new Color(0, 0, 255)); // Set blue color at (0, 2)

        // Create a GrayScaleAdjuster to convert colors to grayscale
        GrayScaleAdjuster grayScaleAdjuster = new GrayScaleAdjuster();

        // Act: Apply the grayscale transformation to the image using the transform method
        Image transformedImage = Images.transform(originalImage, grayScaleAdjuster);

        // Assert: Verify that the transformed image's pixels have been converted to grayscale
        for (int x = 0; x < originalImage.getWidth(); x++) {  // Iterate over columns
            for (int y = 0; y < originalImage.getHeight(); y++) {  // Iterate over rows
                // Get the original and transformed colors at the current pixel position
                Color originalColor = originalImage.getColor(x, y);
                Color transformedColor = transformedImage.getColor(x, y);

                // Calculate the expected grayscale value as the average of the RGB components
                int expectedGrayValue = (originalColor.getRedScale() +
                        originalColor.getGreenScale() +
                        originalColor.getBlueScale()) / 3;

                // Assert that the red, green, and blue channels of the transformed color match the grayscale value
                assertEquals(expectedGrayValue, transformedColor.getRedScale(), "Red scale should match grayscale value");
                assertEquals(expectedGrayValue, transformedColor.getGreenScale(), "Green scale should match grayscale value");
                assertEquals(expectedGrayValue, transformedColor.getBlueScale(), "Blue scale should match grayscale value");
            }
        }
    }
}
