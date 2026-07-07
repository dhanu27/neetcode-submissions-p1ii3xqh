class Node {
    int i;
    int j;
    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Node> que = new LinkedList<>();
        int vis[][] = new int[n][m];
        int x[] = {1, 0, 0, -1};
        int y[] = {0, 1, -1, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 1;
                    que.add(new Node(i, j));
                }
            }
        }
        int minutes = 0;
        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                Node node = que.remove();

                for (int k = 0; k < 4; k++) {
                    int newI = node.i + x[k];
                    int newJ = node.j + y[k];
                    if (newI < 0 || newI >= grid.length || newJ < 0 || newJ >= grid[0].length
                        || vis[newI][newJ] == 1 || grid[newI][newJ] == 0)
                        continue;
                    // isAdded = true;
                    vis[newI][newJ] = 1;
                    grid[newI][newJ] = 2;
                    que.add(new Node(newI, newJ));
                }
            }

            minutes++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes == 0 ? 0 : minutes - 1;
    }
}
