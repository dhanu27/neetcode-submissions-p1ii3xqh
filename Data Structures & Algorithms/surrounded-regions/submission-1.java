class Solution {
    public void solve(char[][] board) {
        int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> que = new LinkedList<>();
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '*';
                que.add(new int[]{0, i});
            }
            if (board[n - 1][i] == 'O') {
                board[n - 1][i] = '*';
                que.add(new int[] {n - 1, i});
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '*';
                que.add(new int[] {i, 0});
            }
            if (board[i][m - 1] == 'O') {
                board[i][m - 1] = '*';
                que.add(new int[] {i, m - 1});
            }
        }

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int[] curr = que.poll();
                int i = curr[0], j = curr[1];
                for (int[] direction : dir) {
                    int newI = i + direction[0];
                    int newJ = j + direction[1];
                    if (newI < 0 || newJ < 0 || newI >= n || newJ >= m || board[newI][newJ] != 'O')
                        continue;
                    board[newI][newJ] = '*';
                    que.add(new int[]{newI, newJ});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
