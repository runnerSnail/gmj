import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution52 {
    public int totalNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        Set<Integer> column = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();
        return backTrace(n, solutions, column, diagonal1, diagonal2, queue, 0);
    }

    public int backTrace(int n, List<List<String>> solutions, Set<Integer> column, Set<Integer> diagonal1,
            Set<Integer> diagonal2, int[] queue, int row) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (column.contains(i))
                continue;
            if (diagonal1.contains(row - i))
                continue;
            if (diagonal2.contains(row + i))
                continue;
            queue[row] = i;
            column.add(i);
            diagonal1.add(row - i);
            diagonal2.add(row + i);
            count += backTrace(n, solutions, column, diagonal1, diagonal2, queue, row + 1);
            queue[row] = -1;
            column.remove(i);
            diagonal1.remove(row - i);
            diagonal2.remove(row + i);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
