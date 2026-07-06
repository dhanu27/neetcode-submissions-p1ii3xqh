/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node cloneGraphViaDFS(Node node, Map<Integer, Node> adjList) {
        if(node == null) {
            return null;
        }
        Node newNode = adjList.getOrDefault(node.val, new Node(node.val));
        adjList.put(node.val, newNode);
        for (int i = 0; i < node.neighbors.size(); i++) {
            if (adjList.get(node.neighbors.get(i).val) == null) {
                newNode.neighbors.add(cloneGraphViaDFS(node.neighbors.get(i), adjList));
            } else {
                newNode.neighbors.add(adjList.get(node.neighbors.get(i).val));
            }
        }
        return newNode;
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> adjList = new HashMap<>();
        return cloneGraphViaDFS(node, adjList);
    }
}