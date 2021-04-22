import java.util.Arrays;

// 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// 输出：[1,2,2,3,5,6]
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2];
                p2++;
            } else if (p2 == n) {
                cur = nums1[p1];
                p1++;
            } else if (nums1[p1] <= nums2[p2]) {
                cur = nums1[p1];
                p1++;
            } else {
                cur = nums1[p2];
                p2++;
            }
            result[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = result[i];
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        System.out.println();
    }
}
