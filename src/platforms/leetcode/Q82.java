// Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,2,3,3,4,4,5]
// Output: [1,2,5]

// Example 2:
// Input: head = [1,1,1,2,3]
// Output: [2,3]

// Constraints:
// The number of nodes in the list is in the range [0, 300].
// -100 <= Node.val <= 100
// The list is guaranteed to be sorted in ascending order.

import datastructures.ListNode;

public class Q82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode dummy = new ListNode(-101), temp = dummy;
        ListNode curr = head, next;
        while (curr != null) {
            next = curr.next;
            if (next == null)
                break;
            if (curr.val == next.val) {
                while (next != null && curr.val == next.val)
                    next = next.next;
                curr = next;
            } else {
                temp.next = new ListNode(curr.val);
                temp = temp.next;
                curr = next;
            }
        }
        if (curr != null) {
            temp.next = new ListNode(curr.val);
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // 1 2 3 3 4 4 5
        ListNode head = new ListNode(1,
                new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        ListNode result = deleteDuplicates(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // output: 1 2 5
    }
}
