#!/usr/bin/env fish

# Migration script to organize existing files into the new structure
# Run this script to move files from the old structure to the new organized structure

function main
    echo "🔄 Starting migration to new file structure..."
    
    # Create necessary directories if they don't exist
    mkdir -p src/platforms/leetcode
    mkdir -p src/platforms/codeforces
    mkdir -p src/algorithms/sorting
    mkdir -p src/algorithms/searching
    mkdir -p src/utils
    
    # Migrate LeetCode problems from com/LeetCode/ to platforms/leetcode/
    if test -d "src/com/LeetCode"
        echo "📁 Migrating LeetCode solutions..."
        for file in src/com/LeetCode/*.java
            if test -f "$file"
                set -l filename (basename "$file")
                echo "  Moving $filename to platforms/leetcode/"
                # Fix package declaration and move
                sed 's/package com\.LeetCode;/package platforms.leetcode;/' "$file" > "src/platforms/leetcode/$filename"
            end
        end
        echo "✅ LeetCode solutions migrated"
    end
    
    # Migrate Codeforces problems
    echo "📁 Migrating Codeforces solutions..."
    for file in src/CF*.java
        if test -f "$file"
            set -l filename (basename "$file")
            echo "  Moving $filename to platforms/codeforces/"
            # Add proper package declaration and move
            echo "package platforms.codeforces;" > "src/platforms/codeforces/$filename"
            echo "" >> "src/platforms/codeforces/$filename"
            cat "$file" >> "src/platforms/codeforces/$filename"
        end
    end
    echo "✅ Codeforces solutions migrated"
    
    # Migrate sorting algorithms
    echo "📁 Migrating sorting algorithms..."
    for file in src/*Sort*.java
        if test -f "$file"
            set -l filename (basename "$file")
            echo "  Moving $filename to algorithms/sorting/"
            # Fix package declaration and move
            sed 's/package com;/package algorithms.sorting;/' "$file" > "src/algorithms/sorting/$filename"
        end
    end
    echo "✅ Sorting algorithms migrated"
    
    # Migrate other LeetCode problems (LC*.java)
    echo "📁 Migrating remaining LeetCode problems..."
    for file in src/LC*.java
        if test -f "$file"
            set -l filename (basename "$file")
            echo "  Moving $filename to platforms/leetcode/"
            # Add proper package declaration and move
            echo "package platforms.leetcode;" > "src/platforms/leetcode/$filename"
            echo "" >> "src/platforms/leetcode/$filename"
            cat "$file" >> "src/platforms/leetcode/$filename"
        end
    end
    echo "✅ Remaining LeetCode problems migrated"
    
    # Fix imports in migrated files
    echo "🔧 Fixing imports in migrated files..."
    fix_imports
    
    echo ""
    echo "✅ Migration completed successfully!"
    echo ""
    echo "📂 New structure:"
    echo "  📁 src/platforms/leetcode/ - $(count src/platforms/leetcode/*.java 2>/dev/null || echo 0) files"
    echo "  📁 src/platforms/codeforces/ - $(count src/platforms/codeforces/*.java 2>/dev/null || echo 0) files"
    echo "  📁 src/algorithms/sorting/ - $(count src/algorithms/sorting/*.java 2>/dev/null || echo 0) files"
    echo "  📁 src/datastructures/ - $(count src/datastructures/*.java 2>/dev/null || echo 0) files"
    echo "  📁 src/utils/ - $(count src/utils/*.java 2>/dev/null || echo 0) files"
    echo ""
    echo "🗑️  You can now safely remove the old files:"
    echo "   rm -rf src/com/"
    echo "   rm src/CF*.java src/LC*.java src/*Sort*.java"
    echo ""
    echo "🚀 Use './scripts/auto-push.sh' to commit and push changes!"
end

function fix_imports
    # Fix ListNode imports in LeetCode solutions
    for file in src/platforms/leetcode/*.java
        if test -f "$file"
            sed -i 's/import DataStructures\.ListNode;/import datastructures.ListNode;/' "$file"
            sed -i 's/import DataStructures\.TreeNode;/import datastructures.TreeNode;/' "$file"
        end
    end
    
    # Add missing imports where needed
    for file in src/platforms/codeforces/*.java
        if test -f "$file"
            if grep -q "Scanner" "$file" && not grep -q "import java.util.Scanner;" "$file"
                sed -i '1a import java.util.Scanner;' "$file"
            end
            if grep -q "Arrays" "$file" && not grep -q "import java.util.Arrays;" "$file"
                sed -i '1a import java.util.Arrays;' "$file"
            end
        end
    end
end

# Run the main function
main $argv