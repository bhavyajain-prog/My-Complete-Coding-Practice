// You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
// Return the head of the linked list after doubling it.

// Example 1:
// Input: head = [1,8,9]
// Output: [3,7,8]
// Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.

// Example 2:
// Input: head = [9,9,9]
// Output: [1,9,9,8]
// Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 

// Constraints:
// The number of nodes in the list is in the range [1, 104]
// 0 <= Node.val <= 9
// The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.

import DataStructures.ListNode;

public class Q2816 {
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = reverse(head);
        ListNode newHead = new ListNode(0), curr = newHead;
        int carry = 0;

        while (dummy != null) {
            int newVal = (dummy.val * 2) + carry;
            curr.next = new ListNode(newVal % 10);
            carry = newVal / 10;
            curr = curr.next;
            dummy = dummy.next;
        }
        if (carry > 0)
            curr.next = new ListNode(carry);

        return reverse(newHead.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
