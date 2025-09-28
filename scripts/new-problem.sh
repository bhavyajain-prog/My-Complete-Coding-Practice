#!/usr/bin/env fish

# Template generator for new problems
# Usage: ./scripts/new-problem.sh <platform> <problem-name> [difficulty]

function main
    set -l platform $argv[1]
    set -l problem_name $argv[2]
    set -l difficulty $argv[3]
    
    if test -z "$platform" -o -z "$problem_name"
        show_help
        exit 1
    end
    
    # Set default difficulty
    if test -z "$difficulty"
        set difficulty "Medium"
    end
    
    # Determine file path based on platform
    switch $platform
        case leetcode lc
            set -l file_path "src/platforms/leetcode/$problem_name.java"
            create_leetcode_template "$file_path" "$problem_name" "$difficulty"
        case codeforces cf
            set -l file_path "src/platforms/codeforces/$problem_name.java"
            create_codeforces_template "$file_path" "$problem_name"
        case '*'
            echo "❌ Unknown platform: $platform"
            show_help
            exit 1
    end
end

function show_help
    echo "🚀 Problem Template Generator"
    echo ""
    echo "Usage: ./scripts/new-problem.sh <platform> <problem-name> [difficulty]"
    echo ""
    echo "Platforms:"
    echo "  leetcode, lc    - LeetCode problem"
    echo "  codeforces, cf  - Codeforces problem"
    echo ""
    echo "Difficulty (optional):"
    echo "  Easy, Medium, Hard (default: Medium)"
    echo ""
    echo "Examples:"
    echo "  ./scripts/new-problem.sh leetcode Q1 Easy"
    echo "  ./scripts/new-problem.sh cf CF123A"
end

function create_leetcode_template
    set -l file_path $argv[1]
    set -l problem_name $argv[2]
    set -l difficulty $argv[3]
    
    if test -f "$file_path"
        echo "❌ File already exists: $file_path"
        exit 1
    end
    
    cat > "$file_path" << EOF
package platforms.leetcode;

import datastructures.*;
import java.util.*;

/**
 * LeetCode Problem: $problem_name
 * Difficulty: $difficulty
 * 
 * Problem Description:
 * [Add problem description here]
 * 
 * Approach:
 * [Describe your approach here]
 * 
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
public class $problem_name {
    
    public void solution() {
        // TODO: Implement solution
    }
    
    /**
     * Test cases
     */
    public static void main(String[] args) {
        $problem_name solution = new $problem_name();
        
        // Test case 1
        // Expected: 
        // Actual: 
        
        System.out.println("All tests passed! ✅");
    }
}
EOF
    
    echo "✅ Created LeetCode template: $file_path"
    echo "📝 Don't forget to:"
    echo "   1. Add the problem description"
    echo "   2. Implement the solution"
    echo "   3. Add test cases"
    echo "   4. Update time/space complexity"
end

function create_codeforces_template
    set -l file_path $argv[1]
    set -l problem_name $argv[2]
    
    if test -f "$file_path"
        echo "❌ File already exists: $file_path"
        exit 1
    end
    
    cat > "$file_path" << EOF
package platforms.codeforces;

import utils.InputReader;
import java.io.*;
import java.util.*;

/**
 * Codeforces Problem: $problem_name
 * 
 * Problem Description:
 * [Add problem description here]
 * 
 * Approach:
 * [Describe your approach here]
 * 
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 */
public class $problem_name {
    
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        PrintWriter writer = new PrintWriter(System.out);
        
        // Read input
        // int n = reader.nextInt();
        
        // Solve the problem
        // TODO: Implement solution
        
        // Output result
        // writer.println(result);
        
        writer.flush();
        writer.close();
    }
    
    private static void solve() {
        // Helper method for solution logic
    }
}
EOF
    
    echo "✅ Created Codeforces template: $file_path"
    echo "📝 Don't forget to:"
    echo "   1. Add the problem description"
    echo "   2. Implement input reading"
    echo "   3. Implement the solution logic"
    echo "   4. Handle output formatting"
end

# Run the main function
main $argv