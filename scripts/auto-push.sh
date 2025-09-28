#!/usr/bin/env fish

# Auto-push script for DSA practice repository
# Automatically stages changes, creates meaningful commit messages, and pushes to GitHub

function main
    # Check if we're in a git repository
    if not git rev-parse --git-dir > /dev/null 2>&1
        echo "❌ Error: Not in a git repository!"
        exit 1
    end

    # Check for changes
    set -l status_output (git status --porcelain)
    if test -z "$status_output"
        echo "✅ No changes to commit"
        exit 0
    end

    echo "🔍 Analyzing changes..."
    
    # Stage all changes
    git add .
    
    # Generate commit message based on changes
    set -l commit_msg (generate_commit_message)
    
    echo "📝 Commit message: $commit_msg"
    
    # Commit changes
    git commit -m "$commit_msg"
    
    # Push to remote
    echo "🚀 Pushing to GitHub..."
    if git push
        echo "✅ Successfully pushed changes to GitHub!"
        
        # Show summary
        echo ""
        echo "📊 Repository Summary:"
        count_solutions
    else
        echo "❌ Failed to push to GitHub"
        exit 1
    end
end

function generate_commit_message
    set -l added_files (git diff --cached --name-only --diff-filter=A)
    set -l modified_files (git diff --cached --name-only --diff-filter=M)
    set -l deleted_files (git diff --cached --name-only --diff-filter=D)
    
    set -l leetcode_count (echo $added_files $modified_files | tr ' ' '\n' | grep -c "platforms/leetcode\|com/LeetCode" | head -1)
    set -l codeforces_count (echo $added_files $modified_files | tr ' ' '\n' | grep -c "platforms/codeforces\|CF[0-9]" | head -1)
    set -l algorithm_count (echo $added_files $modified_files | tr ' ' '\n' | grep -c "algorithms/" | head -1)
    
    if test $leetcode_count -gt 0
        if test $leetcode_count -eq 1
            echo "✨ Add LeetCode solution"
        else
            echo "✨ Add $leetcode_count LeetCode solutions"
        end
    else if test $codeforces_count -gt 0
        if test $codeforces_count -eq 1
            echo "🎯 Add Codeforces solution"
        else
            echo "🎯 Add $codeforces_count Codeforces solutions"
        end
    else if test $algorithm_count -gt 0
        echo "🧮 Update algorithms and data structures"
    else if test (count $modified_files) -gt 0
        echo "🔧 Update existing solutions and improvements"
    else if test (count $added_files) -gt 0
        echo "📚 Add new practice problems and solutions"
    else if test (count $deleted_files) -gt 0
        echo "🧹 Clean up and organize codebase"
    else
        echo "📝 Update DSA practice repository - $(date '+%Y-%m-%d')"
    end
end

function count_solutions
    set -l leetcode_count (find src/platforms/leetcode src/com/LeetCode -name "*.java" 2>/dev/null | wc -l)
    set -l codeforces_count (find src/platforms/codeforces src/ -name "CF*.java" 2>/dev/null | wc -l)
    set -l total_java (find src/ -name "*.java" 2>/dev/null | wc -l)
    
    echo "  📈 LeetCode solutions: $leetcode_count"
    echo "  🎯 Codeforces solutions: $codeforces_count"
    echo "  📁 Total Java files: $total_java"
    echo ""
    echo "🌟 Keep up the great work on your DSA journey!"
end

# Run the main function
main $argv