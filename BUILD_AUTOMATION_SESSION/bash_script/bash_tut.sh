#!/bin/bash

# Basic Bash Script Template

# ----------------------------
# 1. Variables
# ----------------------------
SCRIPT_NAME="Basic Bash Script"
AUTHOR="Your Name"
VERSION="1.0"
current_date=$(date +"%Y-%m-%d")  # Command substitution

# ----------------------------
# 2. User Input
# ----------------------------
echo "Welcome to $SCRIPT_NAME (v$VERSION)"
read -p "What's your name? " username
echo "Hello, $username!"

# ----------------------------
# 3. Conditionals
# ----------------------------
read -p "How old are you? " age

if [ "$age" -ge 18 ]; then
    echo "You're an adult."
elif [ "$age" -ge 13 ]; then
    echo "You're a teenager."
else
    echo "You're a child."
fi

# ----------------------------
# 4. Loops
# ----------------------------
# For loop
echo -n "Counting to 5: "
for i in {1..5}; do
    echo -n "$i "
done
echo

# While loop
counter=3
echo -n "Countdown: "
while [ "$counter" -gt 0 ]; do
    echo -n "$counter "
    ((counter--))
done
echo "Blastoff!"

# ----------------------------
# 5. Functions
# ----------------------------
function greet() {
    local time_of_day=$1
    echo "Good $time_of_day, $username!"
}

greet "morning"

# ----------------------------
# 6. File Operations
# ----------------------------
file_path="example.txt"

echo "Creating example file..."
echo "This is some sample text." > "$file_path"

echo "File contents:"
cat "$file_path"

# Check if file exists
if [ -f "$file_path" ]; then
    echo "File exists and its word count is: $(wc -w < "$file_path")"
else
    echo "File does not exist."
fi

# ----------------------------
# 7. Arrays
# ----------------------------
fruits=("Apple" "Banana" "Cherry" "Date")

echo "Favorite fruits:"
for fruit in "${fruits[@]}"; do
    echo "- $fruit"
done

# ----------------------------
# 8. Exit Status and Return Codes
# ----------------------------
echo "Script completed successfully."
exit 0