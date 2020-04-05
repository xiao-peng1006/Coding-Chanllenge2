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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        int count = 1;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        cur.next = head;
        ListNode pre = cur;
        cur = head;
        k = count - k%count;
        while (k > 0) {
            pre = pre.next;
            cur = cur.next;
            k--;
        }
        pre.next = null;
        return cur;
    }
}