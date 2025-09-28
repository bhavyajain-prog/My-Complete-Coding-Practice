package datastructures;

/**
 * Definition for singly-linked list.
 * Commonly used in LeetCode problems involving linked lists.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Helper method to create a linked list from array
     */
    public static ListNode fromArray(int[] arr) {
        if (arr.length == 0) return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        
        return head;
    }

    /**
     * Helper method to convert linked list to array
     */
    public static int[] toArray(ListNode head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        ListNode current = head;
        
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Helper method to print linked list
     */
    public static void print(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}