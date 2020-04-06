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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revHead;
        if (fast.next == null) {
            revHead = reverse(slow);
        } else {
            revHead = reverse(slow.next);
        }
        slow.next = null;


        ListNode cur = head, revCur = revHead;
        while (cur != null && revCur != null) {
            System.out.println(cur.val + ", " + revCur.val);

            if (cur.val != revCur.val) {
                return false;
            }
            cur = cur.next;
            revCur = revCur.next;
        }

        return cur == null && revCur == null;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

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