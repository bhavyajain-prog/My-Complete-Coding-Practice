// Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
// Return the decimal value of the number in the linked list.
// The most significant bit is at the head of the linked list.

// Example 1:
// Input: head = [1,0,1]
// Output: 5
// Explanation: (101) in base 2 = (5) in base 10

// Example 2:
// Input: head = [0]
// Output: 0

// Constraints:
// The Linked List is not empty.
// Number of nodes will not exceed 30.
// Each node's value is either 0 or 1.

import DataStructures.ListNode;

public class Q1290 {
    public int getDecimalValue(ListNode head) {
        int n = length(head);
        int result = 0;
        while (head!=null) {
            result += (head.val * Math.pow(2, n-1));
            head = head.next;
            n--;
        }
        return result;
    }

    private int length(ListNode head) {
        int cnt = 0;
        while (head!=null) {
            head = head.next;
            cnt++;
        }
        return cnt;
    }
}
