// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

// Example 1:
// Input: head = [1,1,2]
// Output: [1,2]

// Example 2:
// Input: head = [1,1,2,3,3]
// Output: [1,2,3]

import datastructures.ListNode;

public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode newHead = res;
        int prev = 101;
        while (head != null) {
            if (prev != head.val) {
                res.next = new ListNode(head.val);
                res = res.next;
                prev = head.val;
            }
            head = head.next;
        }
        return newHead.next;
    }
}