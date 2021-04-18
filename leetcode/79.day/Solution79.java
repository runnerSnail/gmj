public class Solution79 {

    static final int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int rows;
    int cols;
    boolean[][] visited;
    char[] charArray;
    char[][] board;

    public boolean exist(char[][] board, String word) {

        if (board.length == 0)
            return false;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        this.board = board;
        charArray = word.toCharArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backTrace(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backTrace(int i, int j, int begin) {
        if (begin == charArray.length - 1) {
            return board[i][j] == charArray[begin];
        }
        if (board[i][j] == charArray[begin]) {
            visited[i][j] = true;
            for (int k = 0; k < directions.length; k++) {
                int newRow = i + directions[k][0];
                int newCol = j + directions[k][1];
                if (inArea(newRow, newCol) && !visited[newRow][newCol] && backTrace(newRow, newCol, begin + 1)) {
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }

    public static void main(String[] args) {

    }
}
