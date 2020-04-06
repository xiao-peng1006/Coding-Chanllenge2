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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = reverse(slow.next);
        slow.next = null;

        ListNode firstCur = head, secondCur = secondHead;
        ListNode firstNext, secondNext;
        while (firstCur != null && secondCur != null) {
            firstNext = firstCur.next;
            firstCur.next = secondCur;
            firstCur = firstNext;
            secondNext = secondCur.next;
            secondCur.next = firstCur;
            secondCur = secondNext;
        }

    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next;
        pre.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}