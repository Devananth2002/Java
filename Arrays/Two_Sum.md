# Two Sum in Arrays (Java)

- You are given an array of numbers and a target number.
- You must find **two numbers in the array whose sum = target**.

---

## Visual Idea
- Array: [2, 7, 11, 15]
- Target: 9

Think like this:
- Pick 2 → need 7 to make 9
- 7 exists → answer found

---

## Types (if applicable)

### 1. Brute Force (Simple Way)
- When to use
  - When array is very small
  - When you want simplest logic

- Idea (step-by-step logic)
  - Take first number
  - Check with every other number
  - If sum matches → return answer

---

### 2. HashMap (Best & Most Used)
- When to use
  - In interviews
  - When you need fast solution

- Idea (step-by-step logic)
  - Create a map (number → index)
  - Loop through array
  - For each number:
    - Find target - current
    - If it exists in map → answer found
    - Else store current number

---

### 3. Two Pointers (Sorted Array)
- When to use
  - Only when array is sorted

- Idea (step-by-step logic)
  - Start one pointer at beginning
  - One pointer at end
  - If sum too small → move left pointer
  - If sum too big → move right pointer

---

## Example: Two Sum (Using HashMap)

### Description
- Find two indices such that their values add up to target.

### Sample Input
```
nums = [2, 7, 11, 15]
target = 9
```

### Sample Output
```
[0, 1]
```

### Explanation
- Start with empty map
- Check 2 → need 7 → not found → store 2
- Check 7 → need 2 → found → return indices

### Code (Java)
```java
import java.util.*;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (map.containsKey(needed)) {
                return new int[]{map.get(needed), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
```

### Complexity
- Time: O(n)
- Space: O(n)

---

## Example: Two Sum (Brute Force)

### Description
- Check all pairs and find matching sum.

### Sample Input
```
nums = [3, 2, 4]
target = 6
```

### Sample Output
```
[1, 2]
```

### Explanation
- Check (3,2) → 5  
- Check (3,4) → 7  
- Check (2,4) → 6 → answer found

### Code (Java)
```java
class TwoSumBrute {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
```

### Complexity
- Time: O(n^2)
- Space: O(1)

---

## Example: Two Sum (Sorted - Two Pointers)

### Description
- Use two pointers on sorted array.

### Sample Input
```
nums = [1, 2, 3, 4, 6]
target = 6
```

### Sample Output
```
[1, 3]
```

### Explanation
- Start: (1,6) → 7  
- Move right pointer  
- (1,4) → 5  
- Move left pointer  
- (2,4) → 6 → answer found

### Code (Java)
```java
class TwoSumSorted {
    public static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
```

### Complexity
- Time: O(n)
- Space: O(1)

---

## When to Use
- When asked to find pair with given sum
- When solving array problems
- Base problem for many patterns (like 3Sum, 4Sum)

---

## Simple Rule
- Unsorted array → use HashMap
- Sorted array → use Two Pointers
- Small input → Brute Force

---

## Common Mistakes
- Forgetting to return indices (not values)
- Using Two Pointers on unsorted array
- Overwriting values in HashMap incorrectly
- Not checking if element already exists

---

## Summary Table

| Type         | Use                | Time   | Space |
|--------------|--------------------|--------|-------|
| Brute Force  | Small arrays       | O(n^2) | O(1)  |
| HashMap      | Best general case  | O(n)   | O(n)  |
| Two Pointers | Sorted arrays only | O(n)   | O(1)  |
