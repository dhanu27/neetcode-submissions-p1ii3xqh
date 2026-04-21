/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
          return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow!=fast && (slow!=null && fast!=null && fast.next!=null)){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == null || fast == null || fast.next == null)
          return false;
        return slow == fast;  
    }
}
