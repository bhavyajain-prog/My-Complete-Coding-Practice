#!/usr/bin/env fish

# Test runner script for Java solutions
# Usage: ./scripts/test.sh <file-path>

function main
    set -l file_path $argv[1]
    
    if test -z "$file_path"
        echo "❌ Usage: ./scripts/test.sh <java-file>"
        echo "Example: ./scripts/test.sh src/platforms/leetcode/Q1.java"
        exit 1
    end
    
    if not test -f "$file_path"
        echo "❌ File not found: $file_path"
        exit 1
    end
    
    # Extract class name and package
    set -l class_name (basename "$file_path" .java)
    set -l package_path (dirname "$file_path" | sed 's|src/||')
    set -l full_class_name (echo "$package_path/$class_name" | tr '/' '.')
    
    echo "🔨 Compiling $class_name..."
    
    # Compile the Java file
    if javac -cp src "$file_path"
        echo "✅ Compilation successful"
        
        echo "🚀 Running $class_name..."
        echo "─────────────────────────────────"
        
        # Run the Java program
        if java -cp src "$full_class_name"
            echo "─────────────────────────────────"
            echo "✅ Program executed successfully"
        else
            echo "─────────────────────────────────"
            echo "❌ Runtime error occurred"
            exit 1
        end
    else
        echo "❌ Compilation failed"
        exit 1
    end
    
    # Clean up class files
    find src -name "*.class" -delete
end

# Run the main function
main $argv