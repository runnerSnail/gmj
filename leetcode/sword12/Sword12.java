public class Sword12 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length()-1)
            return true;
        board[i][j] = '\0';
        boolean exist = dfs(board, i + 1, j, index + 1, word) || dfs(board, i - 1, j, index + 1, word)
                || dfs(board, i, j + 1, index + 1, word) || dfs(board, i, j - 1, index + 1, word);
        board[i][j] = word.charAt(index);
        return exist;
    }

    public static void main(String[] args) {

    }
}
