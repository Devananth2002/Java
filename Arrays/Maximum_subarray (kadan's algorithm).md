# Maximum Subarray (Kadane’s Algorithm) - Java

## What is it?
- You are given an array of numbers (can be positive and negative)
- You need to find a **continuous subarray** with the **maximum sum**

---

## Visual Idea
- Array: [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Think like this:
- Keep adding numbers
- If sum becomes negative → drop it and start fresh
- Track the maximum sum seen so far

Best subarray here: [4, -1, 2, 1] → sum = 6

---

## Types (if applicable)

### 1. Brute Force
- When to use
  - Small arrays
  - Easy understanding

- Idea (step-by-step logic)
  - Try every subarray
  - Calculate sum
  - Track maximum

---

### 2. Kadane’s Algorithm (Best)
- When to use
  - Interviews
  - Large arrays

- Idea (step-by-step logic)
  - Keep a current sum
  - Add current element
  - If sum < 0 → reset to 0
  - Track max sum at every step

---

## Example: Maximum Subarray (Kadane’s Algorithm)

### Description
- Find the subarray with the largest sum.

### Sample Input
```
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

### Sample Output
```
6
```

### Explanation
- Start with sum = 0, max = very small
- Add -2 → sum = -2 → reset to 0
- Add 1 → sum = 1
- Add -3 → sum = -2 → reset to 0
- Add 4 → sum = 4
- Add -1 → sum = 3
- Add 2 → sum = 5
- Add 1 → sum = 6 → max = 6
- Continue → final max = 6

---

### Code (Java)
```java
class Kadane {
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}
```

### Complexity
- Time: O(n)
- Space: O(1)

---

## Example: Maximum Subarray (Brute Force)

### Description
- Check all possible subarrays.

### Sample Input
```
nums = [1, -2, 3]
```

### Sample Output
```
3
```

### Explanation
- Subarrays:
  - [1] → 1
  - [1,-2] → -1
  - [1,-2,3] → 2
  - [-2] → -2
  - [-2,3] → 1
  - [3] → 3 → max

---

### Code (Java)
```java
class MaxSubarrayBrute {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}
```

### Complexity
- Time: O(n^2)
- Space: O(1)

---

## When to Use
- When asked for maximum sum subarray
- When array has negative numbers
- Base for many DP problems

---

## Simple Rule
- If current sum becomes negative → reset to 0
- Always track maximum

---

## Common Mistakes
- Initializing maxSum as 0 (wrong for all negative arrays)
- Forgetting to update max before reset
- Not handling single element array

---

## Summary Table

| Type            | Use                | Time   | Space |
|-----------------|--------------------|--------|-------|
| Brute Force     | Small arrays       | O(n^2) | O(1)  |
| Kadane’s Algo   | Best approach      | O(n)   | O(1)  |
