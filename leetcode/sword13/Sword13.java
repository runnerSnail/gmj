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
    boolean[][] visted;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visted = new boolean[m][n];
        int count = backTrace(0, 0, k);
        return count;
    }

    private int backTrace(int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || (digiSum(i) + digiSum(j))>k || visted[i][j]) {
            return 0;
        }
        visted[i][j] = true;
        return 1 + backTrace(i - 1, j, k) + backTrace(i + 1, j, k) + backTrace(i, j - 1, k) + backTrace(i, j + 1, k);
    }

    private int digiSum(int i) {
        int sum = 0;
        while (i!= 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Sword13 sword13 = new Sword13();
        System.out.println(sword13.movingCount(2, 3, 1));
    }
}
