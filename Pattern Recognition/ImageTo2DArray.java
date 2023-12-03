import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageTo2DArray {

    public static void main(String[] args) {
        try {
            // Load the image (assuming it's in the specified directory)
            File file = new File("c:\\Users\\KANG\\Downloads\\image_resized_10x10.bmp");


            BufferedImage image = ImageIO.read(file);

            // Resize the image if it's not already 10x10
            BufferedImage resizedImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
            resizedImage.getGraphics().drawImage(image, 0, 0, 10, 10, null);

            // Create the 2D array to hold the pixel values
            int[][] pixelArray = new int[10][10];

            // Populate the 2D array with pixel values
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    // Get color model of the image and the pixel
                    int pixel = resizedImage.getRGB(x, y);
                    // Assuming a grayscale image, red (or green or blue) can be used for the intensity
                    int intensity = (pixel >> 16) & 0xff; // Shift the red component of the pixel
                    pixelArray[y][x] = intensity;
                }
            }

            // Output the array to the console
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    System.out.print(pixelArray[y][x] + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
