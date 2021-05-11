public class Sword13 {
    // 示例 1：

    // 输入：m = 2, n = 3, k = 1
    // 输出：3
    // 示例 2：

    // 输入：m = 3, n = 1, k = 0
    // 输出：1
    int m;
    int n;
    int k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        int count = backTrace(0, 0, k);
        return count;
    }

    private int backTrace(int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || isValid(i, j)) {
            return 0;
        }
        return 1 + backTrace(i - 1, j, k) + backTrace(i + 1, j, k) + backTrace(i, j - 1, k) + backTrace(i, j + 1, k);
    }

    private boolean isValid(int i, int j) {
        int sum = 0;
        while (i / 10 != 0 || j / 10 != 0) {
            sum = j / 10 == 0 ? sum : sum + j % 10;
            sum = i / 10 == 0 ? sum : sum + i % 10;
            i = i / 10;
            j = j / 10;
        }
        sum = sum + i + j;
        return sum <= k;
    }

    public static void main(String[] args) {

    }
}
