import java.util.ArrayList;
import java.util.Stack;

public class Solution42 {
    public int trap1(int[] height) {
        int left = 0;
        int right = height.length - 1;

        if (height.length < 2) {
            return 0;
        }
        int result = Math.min(height[0], height[height.length - 1]) * (height.length - 1);

        while (left < right) {
            if (height[left] < height[right]) {
                while ((left++) < right) {
                    int current = Math.min(height[left], height[right]) * (right - left);
                    if (current > result) {
                        result = current;
                        continue;
                    }
                }
            } else {
                while ((right--) > left) {
                    int current = Math.min(height[left], height[right]) * (right - left);
                    if (current > result) {
                        result = current;
                        continue;
                    }
                }
            }
        }
        return result;
    }

    public int trap2(int[] height) {
        if (height.length < 2) {
            return 0;
        }

        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int lastLeft = 0;
        int lastRight = right;

        while (left < right) {
            if (height[left] < height[right]) {
                while (left++ < right && height[left] < height[lastLeft]) {
                    result += (height[left] - height[lastLeft]);
                    lastLeft = left;
                }
            } else {
                while (right-- > left && height[right] > height[lastRight]) {
                    result += (height[right] - height[lastRight]);
                    lastRight = right;
                }
            }

        }
        return 0;
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int leftMax = 0;
        int rightMax = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > height[leftMax]) {
                    leftMax = left;
                } else {
                    result += (height[leftMax] - height[left]);
                }
                left++;
            } else {
                if (height[right] > height[rightMax]) {
                    rightMax = right;
                } else {
                    result += (height[rightMax] - height[right]);
                }
                right--;
            }
        }
        return result;
    }

    public int trapStack(int[] height) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int current = 0;
        while (current < height.length) {
            while(!st.empty() && height[current]>height[st.peek()]){
                int top = st.peek();
                st.pop();
                if(st.empty()){
                    break;
                }
                int distance = current-st.peek()-1;
                int bounded_height = Math.min(height[current], height[st.peek()])-height[top];
                result+=(bounded_height*distance);
            }
            st.add(current++);
        }
        return result;
    }

    // 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
    // 输出：6
    public static void main(String[] args) {

        Solution42 solution42 = new Solution42();
        int[] nums = { 0, 1, 0, 2 };
        System.out.println(solution42.trap(nums));
        System.out.println(solution42.trapStack(nums));
    }
}
