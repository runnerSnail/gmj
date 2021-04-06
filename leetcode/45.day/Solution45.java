class Solution45 {
    public int jump(int[] nums) {
        int length = nums.length;
        int step = 0;
        int maxPosition = 0;
        int end = 0;

        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (end == i) {
                end = maxPosition;
                step++;
            }
        }
        
        return step;
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();

    }
}