// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.

// Example 1:
// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]

// Example 2:
// Input: head = [2,1], x = 2
// Output: [1,2]

// Constraints:
// The number of nodes in the list is in the range [0, 200].
// -100 <= Node.val <= 100
// -200 <= x <= 200

import DataStructures.ListNode;

public class Q86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode small = new ListNode(0), smallHead = small;
        ListNode big = new ListNode(0), bigHead = big;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val >= x) {
                big.next = new ListNode(curr.val);
                big = big.next;
            } else {
                small.next = new ListNode(curr.val);
                small = small.next;
            }
            curr = curr.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }
}
