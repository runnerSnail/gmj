public class Sword21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 0) {
                left++;
                continue;
            }
            if ((nums[right] & 1) != 0) {
                right--;
                continue;
            }
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
