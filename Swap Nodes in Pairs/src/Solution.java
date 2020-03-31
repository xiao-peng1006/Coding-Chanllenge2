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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead, firstNode = head, secondNode = head.next;
        boolean swap = true;
        while (secondNode != null) {
            if (swap) {
                pre.next = secondNode;
                pre = secondNode;
                firstNode.next = secondNode.next;
                secondNode.next = firstNode;
                secondNode = firstNode.next;
            } else {
                pre = pre.next;
                firstNode = firstNode.next;
                secondNode = secondNode.next;
            }
            swap = !swap;
        }
        return dummyHead.next;

    }
}