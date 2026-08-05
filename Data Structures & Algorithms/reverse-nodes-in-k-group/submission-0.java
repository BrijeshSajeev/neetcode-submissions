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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while(true){
            // Find the kth node
            ListNode kth = getKthNode(groupPrev, k);

            if (kth == null)
                break;

            ListNode groupNext = kth.next;

            // Save the original head (it becomes the tail after reversal)
            ListNode tail = groupPrev.next;

            // Temporarily disconnect the group
            kth.next = null;

            // Reverse the group
            ListNode newHead = reverseKnode(tail);

            // Reconnect
            groupPrev.next = newHead;
            tail.next = groupNext;

            // Move to the next group
            groupPrev = tail;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }


    private ListNode reverseKnode(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
