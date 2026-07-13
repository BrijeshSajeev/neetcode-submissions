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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // find the middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // re-order the left list
        ListNode curr = slow.next;
        slow.next = null; // break the left list
        ListNode prev = null; // prev will be the head of the new list

        while(curr !=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // merge alternatively
        ListNode first = head;
        ListNode second = prev;

        while(second !=null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }
}
