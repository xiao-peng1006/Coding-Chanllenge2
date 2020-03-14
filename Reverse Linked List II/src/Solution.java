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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;

        ListNode curr = head, prev = null;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode con = prev, tail = curr;
        while (n > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }

        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = curr;
        return head;
    }
}