# 🚀 Usage Guide - DSA Practice Repository

This guide will help you make the most of your organized DSA practice repository.

## 📂 Directory Structure

```
src/
├── datastructures/           # Reusable data structure definitions
│   ├── ListNode.java        # Linked list node with helper methods
│   └── TreeNode.java        # Binary tree node with helper methods
├── platforms/
│   ├── leetcode/            # LeetCode solutions
│   └── codeforces/          # Codeforces solutions
├── algorithms/
│   └── sorting/             # Sorting algorithm implementations
├── utils/
│   └── InputReader.java     # Fast input reader for competitive programming
└── scripts/                 # Automation scripts
    ├── auto-push.sh         # Auto commit and push changes
    ├── migrate.sh           # Migrate old files to new structure
    ├── new-problem.sh       # Generate templates for new problems
    └── test.sh             # Compile and run Java solutions
```

## 🛠️ Scripts Usage

### 1. Auto-Push Script

Automatically commits and pushes your changes with meaningful commit messages.

```bash
# From repository root
./scripts/auto-push.sh
```

**Features:**

- ✅ Automatically detects what type of problems you've added
- ✅ Generates meaningful commit messages
- ✅ Shows progress summary after push
- ✅ Handles multiple file types intelligently

### 2. Migration Script

Organizes your existing files into the new structure (run this once).

```bash
# From repository root
./scripts/migrate.sh
```

**What it does:**

- Moves `src/com/LeetCode/*.java` → `src/platforms/leetcode/`
- Moves `src/CF*.java` → `src/platforms/codeforces/`
- Moves `src/*Sort*.java` → `src/algorithms/sorting/`
- Moves `src/LC*.java` → `src/platforms/leetcode/`
- Fixes package declarations and imports

### 3. New Problem Template Generator

Creates boilerplate code for new problems.

```bash
# Create a new LeetCode problem
./scripts/new-problem.sh leetcode Q283 Easy

# Create a new Codeforces problem
./scripts/new-problem.sh codeforces CF1234A
```

### 4. Test Runner

Compiles and runs your Java solutions.

```bash
# Test a specific solution
./scripts/test.sh src/platforms/leetcode/Q1.java
```

## 📝 Best Practices

### Naming Conventions

#### LeetCode Problems

- Use format: `Q<number>.java` (e.g., `Q1.java`, `Q283.java`)
- For problems with names: `Q<number>_<ShortName>.java` (e.g., `Q1_TwoSum.java`)

#### Codeforces Problems

- Use format: `CF<contest><problem>.java` (e.g., `CF1234A.java`)
- Include contest number and problem letter

### File Organization

#### LeetCode Solutions Template

```java
package platforms.leetcode;

import datastructures.*;
import java.util.*;

/**
 * LeetCode Problem: Q1 - Two Sum
 * Difficulty: Easy
 *
 * Problem: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * Approach: Use HashMap to store complements
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        // Implementation here
    }

    public static void main(String[] args) {
        // Test cases
    }
}
```

#### Codeforces Solutions Template

```java
package platforms.codeforces;

import utils.InputReader;
import java.io.*;
import java.util.*;

/**
 * Codeforces Problem: CF1234A
 * Time Limit: 1s, Memory: 256MB
 */
public class CF1234A {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        PrintWriter writer = new PrintWriter(System.out);

        // Solution logic

        writer.flush();
        writer.close();
    }
}
```

## 🔧 Data Structure Usage

### ListNode Helper Methods

```java
// Create linked list from array
ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4});

// Convert to array
int[] arr = ListNode.toArray(head);

// Print linked list
ListNode.print(head); // Output: 1 -> 2 -> 3 -> 4
```

### TreeNode Helper Methods

```java
// Create tree from level-order array
TreeNode root = TreeNode.fromArray(new Integer[]{1, 2, 3, null, null, 4, 5});

// Print tree
TreeNode.printLevelOrder(root);
TreeNode.printInOrder(root);
```

### Fast Input Reader (for competitive programming)

```java
InputReader reader = new InputReader();
int n = reader.nextInt();
int[] arr = reader.nextIntArray(n);
String s = reader.next();
```

## 📊 Progress Tracking

After each push, the auto-push script shows:

- Number of LeetCode solutions
- Number of Codeforces solutions
- Total Java files in repository
- Encouraging message!

## 🚀 Daily Workflow

1. **Start a new problem:**

   ```bash
   ./scripts/new-problem.sh leetcode Q2 Medium
   ```

2. **Code your solution** in your favorite IDE

3. **Test your solution:**

   ```bash
   ./scripts/test.sh src/platforms/leetcode/Q2.java
   ```

4. **Push when ready:**
   ```bash
   ./scripts/auto-push.sh
   ```

## 📋 Migration Checklist

If you're migrating from the old structure, run these commands in order:

```bash
# 1. Run migration script
./scripts/migrate.sh

# 2. Review the changes
git status

# 3. Remove old files (after verification)
rm -rf src/com/
rm src/CF*.java src/LC*.java src/*Sort*.java 2>/dev/null

# 4. Push the reorganized structure
./scripts/auto-push.sh
```

## 💡 Tips

- **Use meaningful variable names** and add comments explaining your approach
- **Include time/space complexity** in your solution comments
- **Add test cases** in your main method to verify correctness
- **Commit frequently** - the auto-push script makes it easy!
- **Use the data structure helpers** to save time on common operations

---

Happy coding! 🎯 Keep practicing and improving your DSA skills!
