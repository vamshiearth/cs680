package umbcs680.hw13.util;

import umbcs680.hw13.Color;
import umbcs680.hw13.ColorAdjuster;
import umbcs680.hw13.Image;


public class Images {
    public static Image transform(Image image, ColorAdjuster adjuster) {
        Image adjusted = new Image(image.getHeight(), image.getWidth());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color original = image.getColor(x, y);
                Color newColor = adjuster.adjust(original);
                adjusted.setColor(x, y, newColor);
            }
        }
        return adjusted;
    }
}