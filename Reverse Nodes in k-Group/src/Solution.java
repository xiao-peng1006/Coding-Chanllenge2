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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode newHead = null, kTail = null;

        while (cur != null) {
            int count = 0;
            cur = head;

            while (count < k && cur != null) {
                cur = cur.next;
                count++;
            }

            if (count == k) {
                ListNode revHead = reverse(head, k);

                if (newHead == null) {
                    newHead = revHead;
                }

                if (kTail != null) {
                    kTail.next = revHead;
                }

                kTail = head;
                head = cur;
            }

            if (kTail != null) {
                kTail.next = head;
            }
        }

        return newHead == null ? head : newHead;
    }

    public ListNode reverse(ListNode head, int k) {
        ListNode newHead = null, cur = head;

        while (k > 0) {
            ListNode next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = next;
            k--;
        }
        return newHead;
    }
}