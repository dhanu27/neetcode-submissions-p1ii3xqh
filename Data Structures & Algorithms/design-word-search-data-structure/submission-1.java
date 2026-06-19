class Trie {
    boolean isEnd;
    Trie[] childNodes;
    Trie() {
        childNodes = new Trie[26];
    }
}

class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie lastNode = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (lastNode.childNodes[ch] == null) {
                lastNode.childNodes[ch] = new Trie();
            }
            lastNode = lastNode.childNodes[ch];
        }
        lastNode.isEnd = true;
    }

    public boolean search(String word) {
        Trie lastNode = root;
        return searchHelper(0, lastNode, word);
    }

    public boolean searchHelper(int indx, Trie lastNode, String word) {
        if (indx == word.length()) {
            return lastNode.isEnd;
        }

        if (word.charAt(indx) == '.') {
            for (int i = 0; i < 26; i++) {
                if (lastNode.childNodes[i] != null) {
                    boolean ans = searchHelper(indx + 1, lastNode.childNodes[i], word);
                    if (ans) {
                        return true;
                    }
                }
            }
            return false;
        }
        int ch = word.charAt(indx) - 'a';
        if (lastNode.childNodes[ch] == null) {
            return false;
        }
        return searchHelper(indx + 1, lastNode.childNodes[ch], word);
    }
}
