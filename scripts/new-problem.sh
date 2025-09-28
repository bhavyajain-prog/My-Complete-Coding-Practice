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
    
    printf "package platforms.leetcode;\n\nimport datastructures.*;\nimport java.util.*;\n\n/**\n * LeetCode Problem: %s\n * Difficulty: %s\n * \n * Problem Description:\n * [Add problem description here]\n * \n * Approach:\n * [Describe your approach here]\n * \n * Time Complexity: O(?)\n * Space Complexity: O(?)\n */\npublic class %s {\n    \n    public void solution() {\n        // TODO: Implement solution\n    }\n    \n    /**\n     * Test cases\n     */\n    public static void main(String[] args) {\n        %s solution = new %s();\n        \n        // Test case 1\n        // Expected: \n        // Actual: \n        \n        System.out.println(\"All tests passed! ✅\");\n    }\n}\n" "$problem_name" "$difficulty" "$problem_name" "$problem_name" "$problem_name" > "$file_path"
    
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
    
    printf "package platforms.codeforces;\n\nimport utils.InputReader;\nimport java.io.*;\nimport java.util.*;\n\n/**\n * Codeforces Problem: %s\n * \n * Problem Description:\n * [Add problem description here]\n * \n * Approach:\n * [Describe your approach here]\n * \n * Time Complexity: O(?)\n * Space Complexity: O(?)\n */\npublic class %s {\n    \n    public static void main(String[] args) {\n        InputReader reader = new InputReader();\n        PrintWriter writer = new PrintWriter(System.out);\n        \n        // Read input\n        // int n = reader.nextInt();\n        \n        // Solve the problem\n        // TODO: Implement solution\n        \n        // Output result\n        // writer.println(result);\n        \n        writer.flush();\n        writer.close();\n    }\n    \n    private static void solve() {\n        // Helper method for solution logic\n    }\n}\n" "$problem_name" "$problem_name" > "$file_path"
    
    echo "✅ Created Codeforces template: $file_path"
    echo "📝 Don't forget to:"
    echo "   1. Add the problem description"
    echo "   2. Implement input reading"
    echo "   3. Implement the solution logic"
    echo "   4. Handle output formatting"
end

# Run the main function
main $argv