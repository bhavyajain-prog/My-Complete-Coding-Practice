// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

// Example 1:
// Input: head = [1,2,2,1]
// Output: true

// Example 2:
// Input: head = [1,2]
// Output: false

// Constraints:
// The number of nodes in the list is in the range [1, 105].
// 0 <= Node.val <= 9

import datastructures.ListNode;

public class Q234 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        int arr[] = new int[100000];
        int size = 0;
        while (head != null) {
            arr[size++] = head.val;
            head = head.next;
        }
        int m = size / 2;
        for (int i = 0; i < m; i++) {
            if (arr[i] != arr[--size])
                return false;
        }
        return true;
        // if (head.next == null)
        // return true;

        // ListNode curr = head;
        // List<Integer> stack = new ArrayList<>();

        // while (curr!=null) {
        // stack.add(curr.val);
        // curr = curr.next;
        // }

        // curr = head;
        // while (curr!=null) {
        // if (curr.val != stack.getLast()) {
        // return false;
        // }
        // curr = curr.next;
        // stack.removeLast();
        // }
        // return true;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        System.out.println(isPalindrome(list));
    }
}
