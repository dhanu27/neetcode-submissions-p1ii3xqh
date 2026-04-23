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
    public ListNode findMiddleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode mid = findMiddleOfList(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode tail = reverseList(midNext);

        while (head != null && tail != null) {
            ListNode headNext = head.next;
            ListNode tailNext = tail.next;
            head.next = tail;
            tail.next = headNext;
            head = headNext;
            tail = tailNext;
        }
    }
}
