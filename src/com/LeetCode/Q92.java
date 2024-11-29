// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

// Example 1:
// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

// Example 2:
// Input: head = [5], left = 1, right = 1
// Output: [5]

// Constraints:
// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n

import DataStructures.ListNode;

public class Q92 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;

        ListNode curr = head, prev = null, leftList = null, rightList = null, middleStart = null, middleEnd = null;
        int i = 1;

        if (left == 1) {
            leftList = null;
            middleStart = head;
            while (i < right) {
                i++;
                prev = curr;
                curr = curr.next;
            }
            middleEnd = curr;
            rightList = curr.next;
            middleEnd.next = null;
        } else {
            while (curr != null) {
                if (i == left) {
                    leftList = prev;
                    middleStart = curr;
                } else if (i == right) {
                    rightList = curr.next;
                    middleEnd = curr;
                    middleEnd.next = null;
                    break;
                }
                prev = curr;
                curr = curr.next;
                i++;
            }
        }

        if (leftList != null)
            leftList.next = null;

        ListNode next;
        prev = null;
        curr = middleStart;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        middleEnd = middleStart;
        middleStart = prev;

        if (left == 1) {
            head = middleStart;
        } else {
            leftList.next = middleStart;
        }
        middleEnd.next = rightList;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode reversed = reverseBetween(head, 2, 2);
        reversed.printList();
        // Output: 1 -> 4 -> 3 -> 2 -> 5
    }
}
