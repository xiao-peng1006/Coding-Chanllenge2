import java.util.Stack;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null) {
            s1.push(cur1.val);
            cur1 = cur1.next;
        }

        while (cur2 != null) {
            s2.push(cur2.val);
            cur2 = cur2.next;
        }

        int carry = 0, sum;
        Stack<Integer> res = new Stack<>();
        while (!s1.empty() || !s2.empty()) {
            int x = s1.empty() ? 0 : s1.pop();
            int y = s2.empty() ? 0 : s2.pop();
            sum = x + y + carry;
            res.push(sum % 10);
            carry = sum / 10;
        }

        if (carry != 0) {
            res.push(carry);
        }

        ListNode dummyHead = new ListNode(0), cur = dummyHead;
        while (!res.empty()) {
            cur.next = new ListNode(res.pop());
            cur = cur.next;
        }

        return dummyHead.next;
    }
}