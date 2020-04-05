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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0), p = dummyHead, q = head;
        dummyHead.next = head;
        while (n > 0) {
            q = q.next;
            n--;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummyHead.next;
    }
}