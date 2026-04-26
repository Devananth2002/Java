# Sliding Window in Arrays — Java

## What is Sliding Window?

Sliding window is a technique used to reduce time complexity from **O(n²) → O(n)**.

Instead of checking every subarray again and again,  
we maintain a **window (continuous part of array)** and move it forward.

We use two pointers:
- `left` → start of window
- `right` → end of window

---

## Visual Idea

Example array:
```
[ 2, 4, 6, 8, 10 ]
```

Window of size 3:
```
[2, 4, 6] → [4, 6, 8] → [6, 8, 10]
```

Instead of recalculating everything,
we:
- **add new element**
- **remove old element**

---

# Type 1 — Fixed Size Window

## When to use?
- When window size `k` is given

## Idea
1. Take first `k` elements
2. Slide window:
   - Add next element
   - Remove first element

---

## Example: Maximum sum of subarray of size k

### Description
Find the **maximum sum** of any contiguous subarray of size `k`.

### Sample Input
```
arr = [2, 4, 6, 8, 10]
k = 3
```

### Sample Output
```
24
```

### Explanation
Subarrays of size 3:
```
[2,4,6] → 12
[4,6,8] → 18
[6,8,10] → 24
```
Maximum = **24**

```java
public static int maxSumFixed(int[] arr, int k) {
    int windowSum = 0;

    // Step 1: first window
    for (int i = 0; i < k; i++) {
        windowSum += arr[i];
    }

    int maxSum = windowSum;

    // Step 2: slide window
    for (int i = k; i < arr.length; i++) {
        windowSum += arr[i];        // add new
        windowSum -= arr[i - k];    // remove old
        maxSum = Math.max(maxSum, windowSum);
    }

    return maxSum;
}
```

## Complexity
- Time → O(n)
- Space → O(1)

---

# Type 2 — Dynamic (Variable Size Window)

## When to use?
- When condition is given:
  - sum ≥ target
  - unique characters
  - at most k distinct

## Idea
- Expand window using `right`
- Shrink window using `left` when needed

---

## Example: Smallest subarray with sum ≥ target

### Description
Find the **minimum length** of a subarray whose sum is **greater than or equal to target**.

### Sample Input
```
arr = [2, 3, 1, 2, 4, 3]
target = 7
```

### Sample Output
```
2
```

### Explanation
```
Subarrays with sum ≥ 7:
[2,3,1,2] → 8 (length 4)
[3,1,2,4] → 10 (length 4)
[4,3]     → 7 (length 2) ✅ smallest
```

```java
public static int minLengthDynamic(int[] arr, int target) {
    int left = 0;
    int windowSum = 0;
    int minLen = Integer.MAX_VALUE;

    for (int right = 0; right < arr.length; right++) {
        windowSum += arr[right];   // expand

        while (windowSum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            windowSum -= arr[left]; // shrink
            left++;
        }
    }

    return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
}
```

## Complexity
- Time → O(n)
- Space → O(1)

---

# Important Variations

## 1. Longest Substring with K Distinct Characters

### Description
Find the **length of the longest substring** that contains **at most k distinct characters**.

### Sample Input
```
s = "eceba"
k = 2
```

### Sample Output
```
3
```

### Explanation
```
"ece" → valid (2 distinct)
"ceba" → invalid (>2 distinct)
```
Answer = **3**

```java
public static int longestKDistinct(String s, int k) {
    Map<Character, Integer> freq = new HashMap<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        freq.put(c, freq.getOrDefault(c, 0) + 1);

        while (freq.size() > k) {
            char l = s.charAt(left);
            freq.put(l, freq.get(l) - 1);
            if (freq.get(l) == 0) freq.remove(l);
            left++;
        }

        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
```

---

## 2. Longest Substring Without Repeating Characters

### Description
Find the **length of the longest substring** without repeating characters.

### Sample Input
```
s = "abcabcbb"
```

### Sample Output
```
3
```

### Explanation
```
"abc" → valid
"abcabcbb" → repeating
Longest = "abc"
```

```java
public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0, maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);

        if (map.containsKey(c)) {
            left = Math.max(left, map.get(c) + 1);
        }

        map.put(c, right);
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
```

---

# When to Use Sliding Window?

Use it when:
- Problem involves **subarray / substring**
- Need **max / min / count**
- Continuous elements only

---

# Simple Rule

- Fixed size `k` → **Type 1**
- Condition-based → **Type 2**

---

# Common Mistakes

- Don’t move `left` backward
- Remove element from map when count = 0
- Handle edge case (no valid window)

---

# Summary

| Type | Use | Time | Space |
|------|-----|------|-------|
| Fixed Window | Size k | O(n) | O(1) |
| Dynamic Window | Condition | O(n) | O(1) |
| With Map | Strings | O(n) | O(k) |

---

Sliding window is one of the most important techniques to optimize array and string problems.
