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
    public ListNode reverseList(ListNode head) {
        ListNode lastHead = null;
        while(head!=null){
            ListNode nextHead = head.next;
             head.next = lastHead;
            lastHead = head;
            head = nextHead;
        }
        return lastHead;
    }
}
