public class ObjectRecognition {

    private static final int[][] grid = {
        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 2, 2, 0, 0, 0},
        {0, 0, 0, 0, 2, 2, 2, 2, 0, 0},
        {0, 0, 0, 0, 2, 2, 2, 2, 0, 0},
        {0, 0, 0, 0, 2, 2, 2, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 2, 0, 0, 0}
    };
    

    public static void main(String[] args) {
        processGrid(grid);
    }

    private static void processGrid(int[][] grid) {
        for (int num = 1; num <= 2; num++) {
            int area = 0, perimeter = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == num) {
                        area++;
                        if (i == 0 || grid[i - 1][j] != num) perimeter++;
                        if (i == grid.length - 1 || grid[i + 1][j] != num) perimeter++;
                        if (j == 0 || grid[i][j - 1] != num) perimeter++;
                        if (j == grid[i].length - 1 || grid[i][j + 1] != num) perimeter++;
                    }
                }
            }

            classifyObject(num, area, perimeter);
        }
    }

    private static void classifyObject(int num, int area, int perimeter) {
        double R = (4 * Math.PI * area) / Math.pow(perimeter, 2);
        if (num == 1 && Math.abs(R - (Math.PI / 4)) < 0.1) {
            System.out.println("Object is square");
        } else if (num == 2 && Math.abs(R - 1) < 0.5) { 
            System.out.println("Object is circular");
        } else {
            System.out.println("Object type unknown for " + num);
        }
    }
}
