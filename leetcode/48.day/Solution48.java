public class Solution48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < (len + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Solution48 solution48 = new Solution48();
        solution48.rotate(nums);
        for (int[] list : nums) {
            String s = "";
            for (int num : list) {
                s += num;
            }
            System.out.println(s);
        }
    }
}
