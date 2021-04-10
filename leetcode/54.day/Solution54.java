import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return spiralOrder;
        }
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int total = rows * cols, row = 0, col = 0;
        int direction = 0;
        for (int i = 0; i < total; i++) {
            spiralOrder.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[direction][0];
            int nextCol = col + directions[direction][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                direction = (direction + 1) % 4;
            }
            row += directions[direction][0];
            col += directions[direction][1];
        }
        return spiralOrder;
    }

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        List<Integer> result = solution54.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
        System.out.println(result.toString());
    }
}
