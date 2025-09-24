// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example 1:
// Input: l1 = [7,2,4,3], l2 = [5,6,4]
// Output: [7,8,0,7]

// Example 2:
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [8,0,7]

// Example 3:
// Input: l1 = [0], l2 = [0]
// Output: [0]

// Constraints:
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.

// import java.util.ArrayList;
// import java.util.List;
import java.util.Stack;

import DataStructures.ListNode;

public class Q445 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        // List<Integer> num1 = new ArrayList<>(), num2 = new ArrayList<>();
        // while (l1 != null) {
        // num1.add(0, l1.val);
        // l1 = l1.next;
        // }
        // while (l2 != null) {
        // num2.add(0, l2.val);
        // l2 = l2.next;
        // }
        // int carry = 0;
        // while (!num1.isEmpty() || !num2.isEmpty()) {
        // int digit1 = num1.isEmpty() ? 0 : num1.remove(0);
        // int digit2 = num2.isEmpty() ? 0 : num2.remove(0);
        // int sum = digit1 + digit2 + carry;
        // carry = sum / 10;

        // ListNode temp = new ListNode(sum % 10, dummy.next);
        // dummy.next = temp;
        // }
        // if (carry > 0) {
        // ListNode temp = new ListNode(carry, dummy.next);
        // dummy.next = temp;
        // }
        // return dummy.next;

        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int digit1 = stack1.isEmpty() ? 0 : stack1.pop();
            int digit2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;

            ListNode temp = new ListNode(sum % 10, dummy.next);
            dummy.next = temp;
        }
        if (carry > 0) {
            ListNode temp = new ListNode(carry, dummy.next);
            dummy.next = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode num1 = new ListNode(2, new ListNode(4, new ListNode(3))); // 243
        ListNode num2 = new ListNode(5, new ListNode(6, new ListNode(4))); // 564
        ListNode res = addTwoNumbers(num1, num2);
        res.printList(); // 708
    }
}
