public class HistogramCalculator {
    public static void main(String[] args) {
        int[][] grayImage = {
            {38, 153, 151, 154, 59, 0, 2, 0, 0, 0},
            {66, 255, 255, 255, 104, 0, 4, 0, 0, 0},
            {62, 252, 248, 252, 98, 0, 4, 0, 0, 0},
            {64, 255, 253, 255, 101, 4, 8, 1, 0, 0},
            {12, 50, 48, 51, 18, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 3, 105, 107, 9, 0, 1},
            {1, 3, 5, 3, 157, 255, 255, 161, 1, 2},
            {0, 1, 0, 2, 228, 252, 251, 233, 4, 0},
            {0, 0, 2, 0, 121, 255, 255, 127, 0, 3},
            {0, 0, 0, 0, 0, 64, 65, 0, 0, 1}
        };
        
        int[] histogram = computeHistogram(grayImage);

        // Display the histogram for non-zero values
        for (int i = 1; i < histogram.length; i++) {
            if (histogram[i] != 0) {
                System.out.println("Gray Level " + i + ": " + histogram[i]);
            }
        }
    }

    public static int[] computeHistogram(int[][] image) {
        int[] histogram = new int[256]; // Assuming 8-bit gray levels (0-255)

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                int grayLevel = image[i][j];
                histogram[grayLevel]++;
            }
        }

        return histogram;
    }
}
