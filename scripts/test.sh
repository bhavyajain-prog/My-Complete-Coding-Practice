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
    
    # Check if file uses preview features (implicit main method)
    set -l uses_preview_features false
    if grep -q "void main()" "$file_path"
        set uses_preview_features true
    end
    
    echo "🔨 Compiling $class_name..."
    
    # Compile with or without preview features
    set -l compile_cmd "javac -cp src"
    if test "$uses_preview_features" = "true"
        set compile_cmd "javac --enable-preview --release 21 -cp src"
        echo "📝 Using --enable-preview for Java 21 features"
    end
    
    if eval "$compile_cmd \"$file_path\""
        echo "✅ Compilation successful"
        
        echo "🚀 Running $class_name..."
        echo "─────────────────────────────────"
        
        # Run with or without preview features
        set -l run_cmd "java -cp src"
        if test "$uses_preview_features" = "true"
            set run_cmd "java --enable-preview -cp src"
        end
        
        if eval "$run_cmd \"$full_class_name\""
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