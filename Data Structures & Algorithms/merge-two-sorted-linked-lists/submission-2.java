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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null || list2 == null){
            return list1 == null ? list2 : list1;
        }
        ListNode head = null;
        ListNode tail = null;

        while(list1!= null && list2!= null){
            ListNode nextH1 = list1.next;
            ListNode nextH2 = list2.next;
            if(list1.val == list2.val){
                if(head == null){
                    head = list1;
                    tail = head;
                }else{
                    tail.next = list1;
                    tail = tail.next;
                }
                tail.next = list2;
                tail = tail.next;
                list1 = nextH1;
                list2 =nextH2;
            }else if(list1.val < list2.val){
               if(head == null){
                  head = list1;
                  tail = head;
               }else{
                 tail.next = list1;
                 tail = tail.next;
               }
               list1 = nextH1;
            }else{
                if(head == null){
                    head = list2;
                    tail = head;
                }else{
                    tail.next = list2;
                    tail = tail.next;
                }
                list2 =nextH2;
            }
        }
        if(list1 != null){
           tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }
        return head;
    }
}