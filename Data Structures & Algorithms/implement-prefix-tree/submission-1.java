class Node {
    int ch;
    Node[] childs;
    boolean isEnd;
    Node(int ch, boolean isEnd) {
        this.ch = ch;
        this.isEnd = isEnd;
        childs = new Node[26];
    }
}
class PrefixTree {
    Node root;
    public PrefixTree() {
        this.root = new Node(0, false);
    }

    public void insert(String word) {
        int i = 0;
        Node lastNode = root;
        while (i < word.length()) {
            int ch = word.charAt(i) - 'a';
            boolean isEnd = false;
            if (i == word.length() - 1) {
                isEnd = true;
            }
            if (lastNode.childs[ch] == null) {
                Node newNode = new Node(ch, isEnd);
                lastNode.childs[ch] = newNode;
                lastNode = newNode;
            } else {
                // lastNode.childs[ch].isEnd = isEnd;
                lastNode = lastNode.childs[ch];
            }
            lastNode.isEnd = lastNode.isEnd || isEnd;
            i++;
        }
    }

    public boolean search(String word) {
        Node lastNode = root;
        int i = 0;
        while (i < word.length()) {
            int ch = word.charAt(i) - 'a';
            Node childNode = lastNode.childs[ch];
            //  System.out.println("Search:- " + word.charAt(i)+ " IsEnd:- "+ childNode.isEnd);
            if (childNode == null || (i == word.length() - 1 && childNode.isEnd == false)) {
               
                return false;
            }
            lastNode = childNode;
            i++;
        }
        return true;
    }

    public boolean startsWith(String word) {
        Node lastNode = root;
        int i = 0;
        while (i < word.length()) {
            int ch = word.charAt(i) - 'a';
            Node childNode = lastNode.childs[ch];
            if (childNode == null) {
                return false;
            }
            lastNode = childNode;
            i++;
        }
        return true;
    }
}
