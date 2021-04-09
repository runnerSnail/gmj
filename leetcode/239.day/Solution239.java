import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution239 {
    public int[] maxSlidingWindow1(int[] nums, int k) {

        if (nums == null || nums.length < k || k == 1) {
            return nums;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[] { nums[i], i });
        }

        int[] result = new int[n - k + 1];
        result[0] = priorityQueue.peek()[0];
        for (int i = k; i < n; i++) {
            priorityQueue.offer(new int[] { nums[i], i });
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }
            result[i - k + 1] = priorityQueue.peek()[0];
        }
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (nums == null || n < k || k == 1) {
            return nums;
        }
        LinkedList<Integer> doubleQueue = new LinkedList<>();
        int[] result = new int[n - k + 1];
        for (int right = 0; right < n; right++) {
            while (!doubleQueue.isEmpty() && nums[right] >= nums[doubleQueue.peekLast()]) {
                doubleQueue.removeLast();
            }
            doubleQueue.addLast(right);
            int left = right - k + 1;
            if (doubleQueue.peekFirst() < left) {
                doubleQueue.removeFirst();
            }
            if (left >=0) {
                result[left] = nums[doubleQueue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] result = solution239.maxSlidingWindow(new int[] { 7, 2, 4 }, 2);
        System.out.println(Arrays.toString(result));
    }
}