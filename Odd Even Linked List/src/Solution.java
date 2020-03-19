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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenHead = head.next, evenCurr = evenHead;
        ListNode oddCurr = head;
        ListNode curr = head.next.next;
        boolean isEven = false;
        while (curr != null) {
            if (isEven) {
                evenCurr.next = curr;
                evenCurr = curr;
            } else {
                oddCurr.next = curr;
                oddCurr = curr;
            }
            isEven = !isEven;
            curr = curr.next;
        }
        oddCurr.next = evenHead;
        evenCurr.next = null;
        return head;
    }
}