// Given the head of a linked list, rotate the list to the right by k places.

// Example 1:
// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]

// Example 2:
// Input: head = [0,1,2], k = 4
// Output: [2,0,1]

// Constraints:
// The number of nodes in the list is in the range [0, 500].
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109

import datastructures.ListNode;

public class Q61 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null)
            return head;

        ListNode curr = head;
        int cnt = 1;
        while (curr.next != null) {
            curr = curr.next;
            cnt++;
        }
        curr.next = head;
        k = k % cnt;
        k = cnt - k;
        ListNode temp = head;
        for (int i = 0; i < k - 1; i++) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode rotated = rotateRight(head, 2);
        while (rotated != null) {
            System.out.print(rotated.val + " ");
            rotated = rotated.next;
        }
        // Output: 4 5 1 2 3
    }
}
