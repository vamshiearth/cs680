package umbcs680.hw09;

import java.util.ArrayList;

public class Image {
    private int width;  // The width of the image (number of columns)
    private int height; // The height of the image (number of rows)
    private ArrayList<ArrayList<Color>> pixels;  // 2D array of Color objects representing the image pixels

    /**
     * Constructor to create an Image object with specified height and width.
     * The image is initialized with black color (RGB: 0, 0, 0) for all pixels.
     *
     * @param height the number of rows in the image
     * @param width the number of columns in the image
     */
    public Image(int height, int width) {
        this.height = height;  // Set the height of the image
        this.width = width;    // Set the width of the image
        this.pixels = new ArrayList<>();  // Initialize the pixel array

        // Initialize the image with black pixels (Color(0, 0, 0))
        for (int i = 0; i < height; i++) {
            ArrayList<Color> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add(new Color(0, 0, 0));  // Add a black pixel (0, 0, 0)
            }
            this.pixels.add(row);  // Add the row to the pixels list
        }
    }

    /**
     * Gets the height of the image (number of rows).
     *
     * @return the height of the image
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the width of the image (number of columns).
     *
     * @return the width of the image
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the color of a specific pixel in the image.
     *
     * @param x the row index of the pixel (height)
     * @param y the column index of the pixel (width)
     * @return the color of the pixel at position (x, y)
     */
    public Color getColor(int x, int y) {
        return pixels.get(x).get(y);  // Get the color of the pixel at position (x, y)
    }

    /**
     * Sets the color of a specific pixel in the image.
     *
     * @param x the row index of the pixel (height)
     * @param y the column index of the pixel (width)
     * @param color the new color to set for the pixel
     */
    public void setColor(int x, int y, Color color) {
        pixels.get(x).set(y, color);  // Set the color of the pixel at position (x, y)
    }
}
