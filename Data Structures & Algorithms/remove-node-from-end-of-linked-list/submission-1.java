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
    
    public int getLengthOfList(ListNode head){
        int sz =0;
        while(head!=null){
            head = head.next;
            sz = sz + 1;
        }
        return sz;
    }

    public ListNode removeNthFromEnd(ListNode head, int m) {
        ListNode curr = head;
        ListNode prev = null;
        int n = getLengthOfList(head) - m;
        int indx = 0;
        while (indx != n && curr != null) {
            indx++;
            prev = curr;
            curr = curr.next;
        }

        if (indx == n) {
            ListNode nextNode = curr.next;
            if (prev == null) {
                head = nextNode;
            } else {
                prev.next = nextNode;
            }
        }
        return head;
    }
}
