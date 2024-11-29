// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]

// Example 2:
// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

// Constraints:
// The number of nodes in the list is n.
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000

import DataStructures.ListNode;

public class Q25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null) {
            count++;
            if (count % k == 0) {
                prev = reverse(prev, curr.next);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
    
    private static ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = a.next, curr = prev.next;
        while (curr != b) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode temp = a.next;
        a.next = prev;
        temp.next = curr;
        return temp;
    }

    public static void main(String[] args) {
        // Test case 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        int k1 = 2;
        ListNode result1 = reverseKGroup(head1, k1);
        System.out.print("Test case 1: ");
        result1.printList(); // Expected output: 2 -> 1 -> 4 -> 3 -> 5

        // Test case 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        int k2 = 3;
        ListNode result2 = reverseKGroup(head2, k2);
        System.out.print("Test case 2: ");
        result2.printList(); // Expected output: 3 -> 2 -> 1 -> 4 -> 5
    }
}
