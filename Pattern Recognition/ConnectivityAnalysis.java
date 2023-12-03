public class ConnectivityAnalysis {
    private static final int[] dx = {-1, 1, 0, 0}; // Up, Down, Left, Right
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        int[][] binaryImage = {
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0}
        };
        

        int[][] labeledImage = new int[binaryImage.length][binaryImage[0].length];
        int currentLabel = 1;

        for (int i = 0; i < binaryImage.length; i++) {
            for (int j = 0; j < binaryImage[i].length; j++) {
                if (binaryImage[i][j] == 1 && labeledImage[i][j] == 0) {
                    dfs(binaryImage, labeledImage, i, j, currentLabel);
                    currentLabel++;
                }
            }
        }

        // Printing the labeled image
        for (int i = 0; i < labeledImage.length; i++) {
            for (int j = 0; j < labeledImage[i].length; j++) {
                System.out.print(labeledImage[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int[][] binaryImage, int[][] labeledImage, int x, int y, int currentLabel) {
        labeledImage[x][y] = currentLabel;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isValid(nx, ny, binaryImage) && binaryImage[nx][ny] == 1 && labeledImage[nx][ny] == 0) {
                dfs(binaryImage, labeledImage, nx, ny, currentLabel);
            }
        }
    }

    private static boolean isValid(int x, int y, int[][] binaryImage) {
        return x >= 0 && x < binaryImage.length && y >= 0 && y < binaryImage[0].length;
    }
}
