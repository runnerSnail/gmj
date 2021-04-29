import java.util.Deque;
import java.util.LinkedList;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int income = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.getLast()] >= prices[i]) {
                int first = stack.getFirst();
                int last = stack.pollLast();
                income = Math.max(prices[last] - prices[first], income);
            }
            stack.add(i);
        }
        if (!stack.isEmpty()) {
            income = Math.max(prices[stack.getLast()] - prices[stack.getFirst()], income);
        }
        return income;
    }

    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxprofit) {
                maxprofit = prices[i] - minPrice;
            }
        }
        return minPrice;
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        // 5
        System.out.println(solution121.maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }
}
