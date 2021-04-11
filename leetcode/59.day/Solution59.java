
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int num = n * n;
        int[][] matrix = new int[n][n];
        boolean[][] used = new boolean[n][n];
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int row = 0;
        int col = 0;
        int directionIndex = 0;
        for (int i = 0; i < num; i++) {
            System.out.println(row+""+col);
            matrix[row][col] = i;
            used[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n || used[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        int[][] matrix = solution59.generateMatrix(5);
        System.out.println(matrix.toString());
    }
}
