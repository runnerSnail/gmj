import java.util.Deque;
import java.util.LinkedList;

public class Solution85 {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return 0;
        int cols = matrix[0].length;
        int[][] left = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        left[i][j] = 1;
                        continue;
                    }
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
        }

        int max = 0;
        for (int col = 0; col < cols; col++) {
            Deque<Integer> stack = new LinkedList<>();

            stack.addLast(-1);
            for (int i = 0; i <= rows; i++) {
                if (i == rows) {
                    while (stack.size() > 1) {
                        int height = left[stack.pollLast()][col];
                        max = Math.max(max, height * (i - stack.peekLast() - 1));
                    }
                }
                while (stack.peekLast() >= 0 && left[stack.peekLast()][col] > left[i][col]) {
                    max = Math.max(max, left[stack.pollLast()][col] * (i - 1 - stack.peekLast()));
                }
                stack.addLast(i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution85 solution85 = new Solution85();
        System.out.println(solution85.maximalRectangle(new char[][] { { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));
        System.out.println(solution85.maximalRectangle(new char[][] { { '1' }}));
    }
}
