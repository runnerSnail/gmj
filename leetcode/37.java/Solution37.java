import java.util.Arrays;

public class Solution37 {

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }


    // ["5","3","4","6","7","8","9","1","2"],
    public boolean solveSudoku(char[][] board, int row, int col) {
        // end condition
        if (row == 8 && col == 9) {
            return true;
        }
        
        // choice route
        if (col == 9) {
            return solveSudoku(board, row + 1, 0);
        }
        
        if(board[row][col]!='.'){
            return solveSudoku(board, row ,col + 1);
        }
        // 53127468
        for (int i = 0; i < 9; i++) {
            if (isSafe(board,row,col,(char)(i + '1'))) {
            board[row][col]=(char)(i + '1');
            // if (isValidSudoku(board)) {
                if (solveSudoku(board, row, col + 1)) {
                    return true;
                }
            }
        }
        
        // backTrace
        board[row][col] = '.';
        return false;
    }
    public boolean isValidSudoku1(char[][] board) {
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
                        row[j][index] = true;
                        block[indexBlock][index] = true;
                    }
                }
            }
        }
        return true;
    }
    // valid
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
    /**
     * 某一行放置数据是否有冲突
     */
  private boolean isRowSafe(char[][] grids, int row, char value) {
    for (int i = 0; i < 9; i++) {
      if (grids[row][i] == value) {
        return false;
      }
    }
    return true;
  }

  /**
   * 某一列放置数据是否有冲突
   */
  private boolean isColumnSafe(char[][] grids, int column, char value) {
    for (int i = 0; i < 9; i++) {
      if (grids[i][column] == value) {
        return false;
      }
    }
    return true;
  }

  /**
   * 每个区域是 3 X 3 的子块，是否可以可以放置数据
   */
  private boolean isSmallBoxSafe(char[][] grids, int row, int column, char value) {
    int rowOffset = (row / 3) * 3;
    int columnOffset = (column / 3) * 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (grids[rowOffset + i][columnOffset + j] == value) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * 在指定位置是否可以放置数据
   */
  private boolean isSafe(char[][] grids, int row, int column, char value) {
    boolean flag =  this.isColumnSafe(grids, column, value)
        && this.isRowSafe(grids, row, value)
        && this.isSmallBoxSafe(grids, row, column, value);
    return flag;
  }
    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        char[][] sudoKu =  {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'} };
        for (char[] cs : sudoKu) {
            System.out.println(Arrays.toString(cs));
        }
        System.out.println("--->>>>");
        solution37.solveSudoku(sudoKu);
        for (char[] cs : sudoKu) {
            System.out.println(Arrays.toString(cs));
        }
    }
}

/**
 * backTrace
 */