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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int lastBorrow = 0;
        ListNode newHead = l1;
        ListNode tail = l1;
        while (l1 != null && l2 != null) {
            int sum = l2.val + l1.val + lastBorrow;
            int reminder = sum % 10;
            if (sum > 9) {
                lastBorrow = 1;
            } else {
                lastBorrow = 0;
            }
            l1.val = reminder;
            tail = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + lastBorrow;
            int reminder = sum % 10;
            if (sum > 9) {
                lastBorrow = 1;
            } else {
                lastBorrow = 0;
            }
            l1.val = reminder;
            tail.next = l1;
            tail = l1;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + lastBorrow;
            int reminder = sum % 10;
            if (sum > 9) {
                lastBorrow = 1;
            } else {
                lastBorrow = 0;
            }
            l2.val = reminder;
            tail.next = l2;
            tail = l2;
            l2 = l2.next;
        }
        if(lastBorrow != 0){
            ListNode newNode = new ListNode(lastBorrow);
            tail.next = newNode;
        }
        return newHead;
    }
}
