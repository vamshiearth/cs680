package umbcs680.hw09.util;

import umbcs680.hw09.Color;
import umbcs680.hw09.ColorAdjuster;
import umbcs680.hw09.Image;

public class Images {
    /**
     * Applies a ColorAdjuster to an Image and returns a new Image with adjusted colors.
     * The method iterates through all pixels of the original image, applies the adjustment,
     * and stores the new color in a transformed image.
     *
     * @param image the original image to be transformed
     * @param adjuster the ColorAdjuster that defines the transformation logic
     * @return a new Image with the colors adjusted
     */
    public static Image transform(Image image, ColorAdjuster adjuster) {
        // Create a new Image object with the same dimensions as the original image
        Image adjustedImage = new Image(image.getHeight(), image.getWidth());

        // Loop through all pixels of the original image
        for (int x = 0; x < image.getHeight(); x++) {  // Iterate over rows (height)
            for (int y = 0; y < image.getWidth(); y++) {  // Iterate over columns (width)
                // Get the color of the current pixel in the original image
                Color originalColor = image.getColor(x, y);

                // Apply the color adjustment using the provided adjuster
                Color adjustedColor = adjuster.adjust(originalColor);

                // Set the adjusted color in the new image at the same pixel position
                adjustedImage.setColor(x, y, adjustedColor);
            }
        }

        // Return the transformed image with adjusted colors
        return adjustedImage;
    }
}
