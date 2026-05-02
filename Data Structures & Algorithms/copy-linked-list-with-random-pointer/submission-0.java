/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    // public int getListLength(Node head){
    //     int sz = 0;
    //     while(head!=null){
    //         sz++;
    //         head = head.next;
    //     }
    //     return sz;
    // }


    public Node copyRandomList(Node curr) {

      HashMap<Node, Node> map= new HashMap<>();
      Node lastNode = null;
      Node newHead = null;
      // Createa copy and poting original list next pointer to new list at same index
      Node head = curr;
      while(head!=null){
        Node nextNode = head.next;  
        Node newNode = new Node(head.val);
        if(lastNode!=null){
            lastNode.next = newNode;
        }
        if(newHead==null){
            newHead = newNode;
        }
        head.next = newNode;
        lastNode = newNode;
        map.put(head, nextNode);
        head = nextNode;
      }

      // Pointing original list random pointer to smilar to new copy
      lastNode = curr;
      while(lastNode!=null){
         Node nextNode = map.get(lastNode);
         if(lastNode.random!=null){
          lastNode.next.random = lastNode.random.next;
         }
         lastNode = nextNode;
      }

      // Fixing original List
      lastNode = curr;
      while(lastNode!=null){
         lastNode.next = map.get(lastNode);
         lastNode = lastNode.next;
      } 
      return newHead;
    }
}
