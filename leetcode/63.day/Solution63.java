public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] pathTable = new int[m][n];
        for (int i = 0; i < m; i++) {
            pathTable[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            pathTable[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathTable[i][j] = pathTable[i][j-1] + pathTable[i-1][j];
            }
        }
        return pathTable[m-1][n-1];
    }
}
