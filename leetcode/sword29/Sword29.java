public class Sword29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;
        int[] ret = new int[total];
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        boolean[][] visited = new boolean[rows][cols];
        int row = 0, col = 0, directIndex = 0;
        for (int i = 0; i < total; i++) {
            visited[row][col] = true;
            ret[i] = matrix[row][col];
            int nextRow = row + directions[directIndex][0];
            int netCol = col + directions[directIndex][1];

            if (nextRow < 0 || netCol >= cols || nextRow >= rows || netCol < 0 || visited[nextRow][netCol]) {
                directIndex = (directIndex + 1) % 4;
            }

            row += directions[directIndex][0];
            col += directions[directIndex][1];
        }
        return ret;
    }
}
