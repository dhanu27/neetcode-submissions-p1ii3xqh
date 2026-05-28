class Node {
    int val;
    int key;
    Node prev;
    Node next;
    Node(int key, int val) {
        this.val = val;
        this.key = key;
        prev = null;
        next = null;
    }
}

class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    Node head, tail;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        Node usedNode = map.get(key);
        deleteAnyNode(usedNode);
        // if(head != null){
        //   System.out.println("From get key:-  " + key + "head is" + head.val + " ");
        // }else{
        //      System.out.println("From get key:-  " + key + "is head null " + " ");
        // }
        addNodeAtEnd(usedNode);
        // System.out.println("From get key:-  " + key + "is head null " + head.val + " ");
        // System.out.println("From get key:-  " + key + "is tail null " + tail.val + "");
        return usedNode.val;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node usedNode = map.get(key);
            usedNode.val = value;
            deleteAnyNode(usedNode);
            addNodeAtEnd(usedNode);
        } else {
            if (map.size() == capacity) {
                map.remove(head.key);
                deleteAnyNode(head);
            }
            Node newNode = new Node(key,value);
            addNodeAtEnd(newNode);
            map.put(key, newNode);
        }

        // System.out.println("From put key:-  " + key + "is head null " + head.val + " ");
        // System.out.println("From put key:-  " + key + "is tail null " + tail.val + " ");
    }

    void addNodeAtEnd(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = null;
            tail = newNode;
        }
    }

    void deleteAnyNode(Node targetNode) {
        Node prevOftargetNode = targetNode.prev;
        Node nextOftargetNode = targetNode.next;
        if (prevOftargetNode != null) {
            prevOftargetNode.next = nextOftargetNode;
        }
        if (nextOftargetNode != null) {
            nextOftargetNode.prev = prevOftargetNode;
        }
        if (head == targetNode) {
            head = nextOftargetNode;
        }
        if (tail == targetNode) {
            tail = prevOftargetNode;
        }
    }
}
