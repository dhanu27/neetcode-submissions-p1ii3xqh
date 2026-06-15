class Solution {
    public boolean existHelper(
        char[][] board, String word, String ans, boolean[][] vis, int i, int j) {
        if (ans.length() == word.length()) {
            return word.equals(ans);
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1
            || ans.length() > word.length() || vis[i][j]) {
            // vis[i][j] = false;
            return false;
        }

        vis[i][j] = true;
        boolean result = existHelper(board, word, ans + board[i][j], vis, i + 1, j)
            || existHelper(board, word, ans + board[i][j], vis, i, j + 1)
            || existHelper(board, word, ans + board[i][j], vis, i - 1, j)
            || existHelper(board, word, ans + board[i][j], vis, i, j - 1);
        vis[i][j] = false;
        return result;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean ans = existHelper(board, word, "", vis, i, j);
                if (ans) {
                    return ans;
                }
            }
        }
        return false;
    }
}
