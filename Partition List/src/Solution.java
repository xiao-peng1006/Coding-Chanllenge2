/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode prev = null, curr = head;
        while (curr != null && curr.val < x) {
            prev = curr;
            curr = curr.next;
        }

        ListNode before = prev, after = curr;
        while (curr != null) {
            if ( curr.val < x) {

                ListNode temp = new ListNode(curr.val);
                if (before == null) {
                    head = temp;
                    head.next = after;
                } else {
                    before.next = temp;
                    temp.next = after;
                }
                before = temp;

                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}