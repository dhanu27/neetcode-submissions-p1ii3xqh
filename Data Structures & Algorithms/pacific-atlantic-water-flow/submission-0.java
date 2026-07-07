class Solution {
    /*
         Every (i,j) -> check can go to both oceans if yes mark itself a canidate with -ive


    */
    class Node {
        int i;
        int j;
        Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        Queue<Node> que = new LinkedList<>();
        int[][] pacificNode = new int[n][m];
        int[][] atlanticNode = new int[n][m];
        int x[] = {1, 0, 0, -1};
        int y[] = {0, 1, -1, 0};

        for (int j = 0; j < m; j++) {
            pacificNode[0][j] = 1;
            que.add(new Node(0, j));
        }
        for (int i = 1; i < n; i++) {
            pacificNode[i][0] = 1;
            que.add(new Node(i, 0));
        }

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                Node node = que.remove();
                int nodeHeight = heights[node.i][node.j];
                for (int k = 0; k < 4; k++) {
                    int newI = node.i + x[k];
                    int newJ = node.j + y[k];
                    if (newI < 0 || newJ < 0 || newI >= n || newJ >= m
                        || nodeHeight > heights[newI][newJ] || pacificNode[newI][newJ] == 1) {
                        continue;
                    }
                    pacificNode[newI][newJ] = 1;
                    que.add(new Node(newI, newJ));
                }
            }
        }

        for (int j = 0; j < m; j++) {
            atlanticNode[n - 1][j] = 1;
            que.add(new Node(n - 1, j));
        }
        for (int i = 0; i < n; i++) {
            atlanticNode[i][m - 1] = 1;
            que.add(new Node(i, m - 1));
        }

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                Node node = que.remove();
                int nodeHeight = heights[node.i][node.j];
                for (int k = 0; k < 4; k++) {
                    int newI = node.i + x[k];
                    int newJ = node.j + y[k];
                    if (newI < 0 || newJ < 0 || newI >= n || newJ >= m
                        || nodeHeight > heights[newI][newJ] || atlanticNode[newI][newJ] == 1) {
                        continue;
                    }
                    atlanticNode[newI][newJ] = 1;
                    que.add(new Node(newI, newJ));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacificNode[i][j] == 1 && atlanticNode[i][j] == 1) {
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    ans.add(result);
                }
            }
        }
        return ans;
    }
}
