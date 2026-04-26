# Two Pointers in Arrays — Java

## What is Two Pointers?

Two pointers is a technique where we use **two indices (pointers)** to iterate through an array or string.

Instead of using nested loops (O(n²)),  
we move pointers intelligently to solve problems in **O(n)** time.

We usually use:
- `left` → starting index
- `right` → ending index

---

## Visual Idea

Example array:
```
[1, 2, 3, 4, 6]
```

Target = 6

```
left → 1
right → 6

Move pointers based on condition:
1 + 6 > 6 → move right
1 + 4 < 6 → move left
2 + 4 = 6 ✅
```

---

# Type 1 — Opposite Direction (Two Ends)

## When to use?
- Sorted array
- Pair problems (sum, difference)
- Palindrome checking

---

## Example: Two Sum (Sorted Array)

### Description
Find two numbers in a **sorted array** that add up to a given target.

### Sample Input
```
arr = [1, 2, 3, 4, 6]
target = 6
```

### Sample Output
```
[2, 4]
```

### Explanation
```
1 + 6 = 7 → too big → move right
1 + 4 = 5 → too small → move left
2 + 4 = 6 ✅
```

```java
public static int[] twoSumSorted(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) {
            return new int[]{arr[left], arr[right]};
        } else if (sum < target) {
            left++;   // increase sum
        } else {
            right--;  // decrease sum
        }
    }

    return new int[]{-1, -1};
}
```

## Complexity
- Time → O(n)
- Space → O(1)

---

# Type 2 — Same Direction (Fast & Slow)

## When to use?
- Removing duplicates
- Moving elements
- Partitioning array

---

## Example: Remove Duplicates from Sorted Array

### Description
Remove duplicates from a sorted array and return the **new length**.

### Sample Input
```
arr = [1, 1, 2, 2, 3]
```

### Sample Output
```
3
```

### Explanation
```
Unique elements → [1, 2, 3]
```

```java
public static int removeDuplicates(int[] arr) {
    if (arr.length == 0) return 0;

    int left = 0;

    for (int right = 1; right < arr.length; right++) {
        if (arr[right] != arr[left]) {
            left++;
            arr[left] = arr[right];
        }
    }

    return left + 1;
}
```

## Complexity
- Time → O(n)
- Space → O(1)

---

# Type 3 — Palindrome Check

## When to use?
- String problems
- Reverse checking

---

## Example: Check Palindrome

### Description
Check if a string is a palindrome (same forward and backward).

### Sample Input
```
s = "madam"
```

### Sample Output
```
true
```

### Explanation
```
Compare:
m == m
a == a
d == d
```

```java
public static boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }

    return true;
}
```

## Complexity
- Time → O(n)
- Space → O(1)

---

# Type 4 — Container With Most Water (Important)

## Description
Find two lines that form a container with maximum water.

### Sample Input
```
height = [1,8,6,2,5,4,8,3,7]
```

### Sample Output
```
49
```

### Explanation
```
Between height[1] = 8 and height[8] = 7
Area = min(8,7) * width(7) = 49
```

```java
public static int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;

    while (left < right) {
        int width = right - left;
        int h = Math.min(height[left], height[right]);
        int area = width * h;

        maxArea = Math.max(maxArea, area);

        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxArea;
}
```

## Complexity
- Time → O(n)
- Space → O(1)

---

# When to Use Two Pointers?

Use it when:
- Array is **sorted**
- Need to find **pair / triplet**
- Comparing from **both ends**
- Removing duplicates
- String reversal / palindrome

---

# Simple Rule

- Sorted + pair → Opposite direction  
- Modify array → Same direction  
- String compare → Both ends  

---

# Common Mistakes

- Using on unsorted array (when logic needs sorted)
- Moving both pointers incorrectly
- Infinite loop (forgetting condition)

---

# Summary

| Type | Use | Time | Space |
|------|-----|------|-------|
| Opposite Direction | Pair problems | O(n) | O(1) |
| Same Direction | Modify array | O(n) | O(1) |
| Palindrome | String check | O(n) | O(1) |

---

Two pointers is a simple but powerful technique to reduce nested loops into a single pass.
