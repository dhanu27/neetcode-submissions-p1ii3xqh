class TrieNode {
    boolean isEnd;
    TrieNode[] childNode;
    TrieNode() {
        childNode = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }

    void addSearch(String word) {
        TrieNode lastNode = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (lastNode.childNode[ch] == null) {
                lastNode.childNode[ch] = new TrieNode();
            }
            lastNode = lastNode.childNode[ch];
        }
        lastNode.isEnd = true;
    }

    TrieNode findSearch(String word) {
        TrieNode lastNode = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (lastNode.childNode[ch] == null) {
                return null;
            }
            lastNode = lastNode.childNode[ch];
        }
        return lastNode;
    }
}

class Solution {
    List<String> ans = new ArrayList<>();

    public void dfs(char[][] board, String[] words, int i, int j, String curr, boolean vis[][],
        TrieNode lastNode) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || vis[i][j]) {
            return;
        }
        int ch = board[i][j] - 'a';
        TrieNode newNode = lastNode.childNode[ch];
        if (newNode == null) {
            return;
        }
        String newString = curr + board[i][j];
        if (newNode.isEnd) {
            ans.add(newString);
            newNode.isEnd = false;
        }
        vis[i][j] = true;
        dfs(board, words, i + 1, j, newString, vis, newNode);
        dfs(board, words, i - 1, j, newString, vis, newNode);
        dfs(board, words, i, j + 1, newString, vis, newNode);
        dfs(board, words, i, j - 1, newString, vis, newNode);
        vis[i][j] = false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < words.length; i++) {
            trie.addSearch(words[i]);
        }
        boolean vis[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, words, i, j, "", vis, trie.root);
            }
        }
        return ans;
    }
}