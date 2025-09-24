// Design a HashSet without using any built-in hash table libraries.
// Implement MyHashSet class:
// void add(key) Inserts the value key into the HashSet.
// bool contains(key) Returns whether the value key exists in the HashSet or not.
// void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.

// Example 1:
// Input
// ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
// [[], [1], [2], [1], [3], [2], [2], [2], [2]]
// Output
// [null, null, null, true, false, null, true, null, false]

// Explanation
// MyHashSet myHashSet = new MyHashSet();
// myHashSet.add(1);      // set = [1]
// myHashSet.add(2);      // set = [1, 2]
// myHashSet.contains(1); // return True
// myHashSet.contains(3); // return False, (not found)
// myHashSet.add(2);      // set = [1, 2]
// myHashSet.contains(2); // return True
// myHashSet.remove(2);   // set = [1]
// myHashSet.contains(2); // return False, (already removed)

// Constraints:
// 0 <= key <= 106
// At most 104 calls will be made to add, remove, and contains.

public class Q705 {
    public class MyHashSet {
        private Node head;

        public MyHashSet() {
            head = null;
        }

        public void add(int key) {
            if (contains(key)) {
                return;
            }
            Node newNode = new Node(key);
            newNode.next = head;
            head = newNode;
        }

        public void remove(int key) {
            if (!contains(key)) {
                return;
            }
            if (head.key == key) {
                head = head.next;
                return;
            }
            Node curr = head.next, prev = head;
            while (curr != null) {
                if (curr.key == key) {
                    prev.next = curr.next;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }

        public boolean contains(int key) {
            Node temp = head;
            while (temp != null) {
                if (temp.key == key) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        private class Node {
            int key;
            Node next;

            Node(int k) {
                key = k;
                next = null;
            }
        }
    }

}
