import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length<4){
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    if (nums[i] + nums[j] + nums[m] + nums[n] == target) {
                        ArrayList<Integer> answer = new ArrayList<>();
                        answer.add(nums[i]);
                        answer.add(nums[j]);
                        answer.add(nums[m]);
                        answer.add(nums[n]);
                        result.add(answer);
                        while(m+1<nums.length &&  nums[m+1]==nums[m]){
                            m++;
                        }
                        while(n-1>j &&  nums[n-1]==nums[n]){
                            n--;
                        }
                        while(j+1<nums.length &&  nums[j+1]==nums[j]){
                            j++;
                        }
                        while(i+1<nums.length &&  nums[i+1]==nums[i]){
                            i++;
                        }
                    }

                    if (nums[i] + nums[j] + nums[m] + nums[n] < target) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] param = { 1, 0, -1, 0, -2, 2 };
        int[] param1 = { 0,0,0,0,0,0,0,0 };
        int[] param2 = { 0,0,0,0 };
        Solution18 solution18 = new Solution18();
        System.out.println(solution18.fourSum(param, 0));
        System.out.println(solution18.fourSum(param2, 0));
    }
}
