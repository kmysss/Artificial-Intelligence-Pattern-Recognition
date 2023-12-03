import java.util.HashMap;
import java.util.Map;

public class OtsuThresholdFinder {

    public static int calculateOtsuThreshold(HashMap<Integer, Integer> histogram) {
        int totalPixels = 0;
        int weightedSum = 0;

        // Calculate the total number of pixels and the weighted sum
        for (Map.Entry<Integer, Integer> entry : histogram.entrySet()) {
            int grayLevel = entry.getKey();
            int pixelCount = entry.getValue();

            totalPixels += pixelCount;
            weightedSum += grayLevel * pixelCount;
        }

        int sumB = 0;
        int wB = 0;
        int maxVariance = 0;
        int threshold = 0;

        for (Map.Entry<Integer, Integer> entry : histogram.entrySet()) {
            int grayLevel = entry.getKey();
            int pixelCount = entry.getValue();

            wB += pixelCount;
            if (wB == 0) continue;

            int wF = totalPixels - wB;
            if (wF == 0) break;

            sumB += grayLevel * pixelCount;
            int meanB = sumB / wB;
            int meanF = (weightedSum - sumB) / wF;

            int varianceBetween = wB * wF * (meanB - meanF) * (meanB - meanF);

            if (varianceBetween > maxVariance) {
                maxVariance = varianceBetween;
                threshold = grayLevel;
            }
        }

        return threshold;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> histogram = new HashMap<>();
        // Fill the histogram with your provided data
        int[] grayLevels = {1, 2, 3, 4, 5, 8, 9, 12, 18, 38, 48, 50, 51, 59, 62, 64, 65, 66, 98, 101, 104, 105, 107, 121, 127, 151, 153, 154, 157, 161, 228, 233, 248, 251, 252, 253, 255};
        int[] counts = {6, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 9};

        for (int i = 0; i < grayLevels.length; i++) {
            histogram.put(grayLevels[i], counts[i]);
        }

        int threshold = calculateOtsuThreshold(histogram);
        System.out.println("Otsu's Threshold: " + threshold);
    }
}
