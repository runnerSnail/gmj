import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        Set<Integer> column = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();
        backTrace(n, solutions, column, diagonal1, diagonal2, queue,0);
        return solutions;
    }

    public void backTrace(int n, List<List<String>> solutions, Set<Integer> column, Set<Integer> diagonal1,
            Set<Integer> diagonal2, int[] queue,int row) {
                if(row == n){
                    List<String> result = generator(queue);
                    solutions.add(result);
                }
                for (int i = 0; i < n; i++) {
                    if(column.contains(i)) continue;
                    if(diagonal1.contains(row-i)) continue;
                    if(diagonal2.contains(row+i)) continue;
                    queue[row] = i;
                    column.add(i);
                    diagonal1.add(row-i);
                    diagonal2.add(row+i);
                    backTrace(n, solutions, column, diagonal1, diagonal2, queue,row+1);
                    queue[row] = -1;
                    column.remove(i);
                    diagonal1.remove(row-i);
                    diagonal2.remove(row+i);
                }
    }

    public List<String> generator(int[] queue){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < queue.length; i++) {
            char[] line = new char[queue.length];
            Arrays.fill(line, '.');
            line[queue[i]]='Q';
            result.add(String.valueOf(line));
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
