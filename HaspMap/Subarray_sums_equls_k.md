# Subarray Sum Equals K (Java)

## What is it?
- You are given an array of integers
- You need to find the **number of subarrays whose sum equals k**
- A subarray means **continuous elements**

---

## Visual Idea
- Array: [1, 2, 3]
- k = 3

Think like this:
- [1,2] → sum = 3 ✅
- [3] → sum = 3 ✅

👉 Total = 2 subarrays

---

## Types (if applicable)

### 1. Brute Force
- When to use
  - Small arrays
  - For understanding

- Idea (step-by-step logic)
  - Fix starting index
  - Keep adding elements
  - Check if sum == k
  - Count all valid subarrays

---

### 2. Prefix Sum + HashMap (Optimal)
- When to use
  - Interviews
  - Large inputs

- Idea (step-by-step logic)
  - Keep running sum (prefix sum)
  - If (currentSum - k) exists → valid subarray found
  - Store prefix sums in map with frequency
  - Add counts accordingly

---

## Example: Brute Force

### Description
- Check all possible subarrays and count those with sum = k

### Sample Input
nums = [1,2,3]
k = 3

### Sample Output
2

### Explanation
- Start from index 0:
  - [1] → 1 ❌
  - [1,2] → 3 ✅
  - [1,2,3] → 6 ❌
- Start from index 1:
  - [2] → 2 ❌
  - [2,3] → 5 ❌
- Start from index 2:
  - [3] → 3 ✅
- Total = 2

---

### Code (Java)
    class SubarraySumBrute {
        public static int subarraySum(int[] nums, int k) {
            int count = 0;

            for (int i = 0; i < nums.length; i++) {
                int sum = 0;

                for (int j = i; j < nums.length; j++) {
                    sum += nums[j];

                    if (sum == k) {
                        count++;
                    }
                }
            }

            return count;
        }
    }

### Complexity
- Time: O(n^2)
- Space: O(1)

---

## Example: Prefix Sum + HashMap (Optimal)

### Description
- Use prefix sum and map to find subarrays efficiently

### Sample Input
nums = [1,2,3]
k = 3

### Sample Output
2

### Explanation
- prefixSum = 0 initially
- map = {0:1}

Step-by-step:
- Add 1 → sum = 1 → (1-3 = -2 not found)
- Add 2 → sum = 3 → (3-3 = 0 found in map) → count = 1
- Add 3 → sum = 6 → (6-3 = 3 found) → count = 2

---

### Code (Java)
    import java.util.*;

    class SubarraySumOptimal {
        public static int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);

            int sum = 0;
            int count = 0;

            for (int num : nums) {
                sum += num;

                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }

                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return count;
        }
    }

### Complexity
- Time: O(n)
- Space: O(n)

---

## Edge Cases
- Empty array
- Single element equal to k
- Negative numbers present
- All elements zero
- Large input size

---

## When to Use
- When problem asks:
  - Count of subarrays with given sum
  - Continuous subarray sum
- Works even with negative numbers (use HashMap approach)

---

## Simple Rule
- Use **prefix sum**
- Check **(currentSum - k)** in map

---

## Common Mistakes
- Forgetting to initialize map with (0 → 1) ❌
- Using sliding window (fails with negatives) ❌
- Not handling negative numbers ❌
- Overwriting map values instead of counting ❌

---

## Summary Table

| Approach       | Use Case            | Time   | Space |
|----------------|--------------------|--------|-------|
| Brute Force    | Small inputs       | O(n^2) | O(1)  |
| Prefix + Map   | Best / Interviews  | O(n)   | O(n)  |
