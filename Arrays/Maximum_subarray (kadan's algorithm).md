# Maximum Subarray (Kadane’s Algorithm) - Java

## What is it?
- You are given an array of numbers (can be positive and negative)
- You need to find a **continuous subarray** with the **maximum sum**

---

## Visual Idea
- Array: [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Think like this:
- Keep adding numbers
- If starting fresh is better than continuing → restart
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

### 2. Kadane’s Algorithm (Reset to 0 version)
- When to use
  - Interviews
  - Large arrays

- Idea (step-by-step logic)
  - Keep a current sum
  - Add current element
  - If sum < 0 → reset to 0
  - Track max sum at every step

---

### 3. Kadane’s Algorithm (Better version - Your Approach)
- When to use
  - Best and clean approach
  - Handles negative cases clearly

- Idea (step-by-step logic)
  - Add current number to current sum
  - Compare:
    - Continue previous subarray OR
    - Start new from current element
  - Take the better one
  - Track max sum

---

## Example: Maximum Subarray (Kadane’s - Your Approach)

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
- Start:
  - currSum = -2, max = -2
- Next:
  - Compare (currSum + 1 = -1) vs (1) → take 1
- Continue:
  - Compare extend vs restart at each step
- Best subarray becomes:
  - [4, -1, 2, 1] → sum = 6

---

### Code (Java)
```java
class KadaneBetter {
    public static int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];

            if (currSum < nums[i]) {
                currSum = nums[i];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
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

## Example: Maximum Subarray (Kadane - Reset Version)

### Description
- Standard version using reset to 0.

### Sample Input
```
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

### Sample Output
```
6
```

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
- Used in dynamic programming problems

---

## Simple Rule
- At each step:
  - Continue OR restart → choose max
- Always track global maximum

---

## Common Mistakes
- Initializing maxSum as 0 (fails for all negative arrays)
- Resetting incorrectly
- Forgetting to compare with current element

---

## Summary Table

| Type                     | Use                | Time   | Space |
|--------------------------|--------------------|--------|-------|
| Brute Force              | Small arrays       | O(n^2) | O(1)  |
| Kadane (Reset)           | Standard approach  | O(n)   | O(1)  |
| Kadane (Better version)  | Clean & optimal    | O(n)   | O(1)  |
