# Move Zeroes (Java)

## What is it?
- You are given an array of numbers
- You need to **move all 0s to the end**
- Maintain the **order of non-zero elements**

---

## Visual Idea
- Array: [0, 1, 0, 3, 12]

Think like this:
- Move all non-zero elements to front
- Fill remaining places with 0

Result:
- [1, 3, 12, 0, 0]

---

## Types (if applicable)

### 1. Brute Force (Extra Array)
- When to use
  - Easy understanding
  - Not memory efficient

- Idea (step-by-step logic)
  - Create a new array
  - Add all non-zero elements
  - Fill remaining with 0

---

### 2. Two Pass (In-place)
- When to use
  - Better than brute force
  - Still simple

- Idea (step-by-step logic)
  - First pass: move non-zero elements forward
  - Second pass: fill rest with zeros

---

### 3. Two Pointers (Optimal - Single Pass)
- When to use
  - Best approach
  - Interview preferred

- Idea (step-by-step logic)
  - Use pointer `j` for position of next non-zero
  - Traverse array with `i`
  - If nums[i] != 0:
    - Swap nums[i] and nums[j]
    - Increment j

---

## Example: Move Zeroes (Two Pointers - Optimal)

### Description
- Move all zeros to the end without using extra space.

### Sample Input
```
nums = [0, 1, 0, 3, 12]
```

### Sample Output
```
[1, 3, 12, 0, 0]
```

### Explanation
- i=0 → 0 → skip  
- i=1 → 1 → swap with index 0  
- i=2 → 0 → skip  
- i=3 → 3 → swap  
- i=4 → 12 → swap  

Final array:
[1, 3, 12, 0, 0]

---

### Code (Java)
```java
class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
```

### Complexity
- Time: O(n)
- Space: O(1)

---

## Example: Move Zeroes (Two Pass)

### Description
- Move non-zero elements first, then fill zeros.

### Sample Input
```
nums = [0, 1, 0, 3, 12]
```

### Sample Output
```
[1, 3, 12, 0, 0]
```

### Code (Java)
```java
class MoveZeroesTwoPass {
    public static void moveZeroes(int[] nums) {
        int index = 0;

        // Move non-zero elements
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        // Fill remaining with zero
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
```

### Complexity
- Time: O(n)
- Space: O(1)

---

## Example: Move Zeroes (Brute Force)

### Description
- Use extra array.

### Sample Input
```
nums = [0, 1, 0, 3, 12]
```

### Sample Output
```
[1, 3, 12, 0, 0]
```

### Code (Java)
```java
class MoveZeroesBrute {
    public static int[] moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        return result;
    }
}
```

### Complexity
- Time: O(n)
- Space: O(n)

---

## When to Use
- When asked to rearrange array
- When order must be maintained
- Common two-pointer pattern problem

---

## Simple Rule
- Keep non-zero elements in front
- Push zeros to end

---

## Common Mistakes
- Not maintaining order
- Using extra space unnecessarily
- Forgetting to fill remaining zeros
- Swapping when i == j (not wrong, but unnecessary)

---

## Summary Table

| Type            | Use                | Time | Space |
|-----------------|--------------------|------|-------|
| Brute Force     | Simple logic       | O(n) | O(n)  |
| Two Pass        | In-place           | O(n) | O(1)  |
| Two Pointers    | Best approach      | O(n) | O(1)  |
