import java.util.Deque;
import java.util.LinkedList;

public class Soluion84 {
    // 输入: [2,1,5,6,2,3]
    // 输出: 10

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.addLast(-1);
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            if (i == heights.length) {
                while (stack.size() > 1) {
                    int height = heights[stack.pollLast()];
                    max = Math.max(max, height * (i - stack.peekLast()-1));
                }
                return max;
            }
            while (stack.peekLast() >=0 && heights[stack.peekLast()] > heights[i]) {
                max = Math.max(max, heights[stack.pollLast()] * (i - 1 - stack.peekLast()));
            }
            stack.addLast(i);
        }
        return max;
    }

    public static void main(String[] args) {
        Soluion84 soluion84 = new Soluion84();
        System.out.println(soluion84.largestRectangleArea(new int[] { 1 }));
    }
}
