// Given the head of a linked list, return the list after sorting it in ascending order.

// Example 1:
// Input: head = [4,2,1,3]
// Output: [1,2,3,4]

// Example 2:
// Input: head = [-1,5,3,4,0]
// Output: [-1,0,3,4,5]

// Example 3:
// Input: head = []
// Output: []

// Constraints:
// The number of nodes in the list is in the range [0, 5 * 104].
// -105 <= Node.val <= 105

import DataStructures.ListNode;

public class Q148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head, prev = null;

        while (fast!= null && fast.next!= null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (left!=null && right!=null) {
            if (left.val < right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        curr.next = left != null ? left : right;
        return dummy.next;
    }
}
