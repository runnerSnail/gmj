import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

// 注意：答案中不可以包含重复的三元组。

//  

// 示例 1：

// 输入：nums = [-1,0,1,2,-1,-4]
// 输出：[[-1,-1,2],[-1,0,1]]
// 示例 2：

// 输入：nums = []
// 输出：[]
// 示例 3：

// 输入：nums = [0]
// 输出：[]
//  

// 提示：

// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105

public class Solution16 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length == 0)
            return result;
        for (int i = 0; i < nums.length; i++) {
            //去重
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    ArrayList<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    result.add(ans);
                    while (++j < k && nums[j] == nums[j-1]) {
                    }
                    while (--k > j && nums[k] == nums[k+1]) {
                    }
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    // 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
    // 找出 nums 中的三个整数，使得它们的和与 target 最接近。
    // 返回这三个数的和。假定每组输入只存在唯一答案。[-1,2,1,-4] 1
    public int threeSumClosest(int[] nums, int target) {
        int abs = Integer.MAX_VALUE;
        int anwser = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int current = target - nums[i];
            while (j < k) {
                // 可以适当优化 return target 值 和 移动重复元素的值
                if (Math.abs(current - nums[j] - nums[k]) < abs) {
                    abs = Math.abs(current - nums[j] - nums[k]);
                    anwser = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return anwser;
    }

    public static void main(String[] args) {
        // int[] param = { -1, 0, 1, 2, -1, -4 };
        // int[] param3 = { 0, 0, 0,0 };
        Solution16 solution16 = new Solution16();
        // System.out.println(solution16.threeSum(param3));
        // System.out.println(solution16.threeSum(param));
        // int[] param2 = { 0,1,1,1 };
        int[] param3 = { -1,2,1,-4 };
        System.out.println(solution16.threeSumClosest(param3, 1));
    }
}
