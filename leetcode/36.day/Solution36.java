public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    int indexBlock = i / 3 * 3 + j / 3;
                    if (row[i][index] || col[j][index] || block[indexBlock][index]) {
                        return false;
                    } else {
                        row[i][index] = true;
                        col[j][index] = true;
                        block[indexBlock][index] = true;
                    }
                }
            }
        }
        return true;
    }
}
