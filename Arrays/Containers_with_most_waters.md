# Container With Most Water (Java)

## What is it?
- You are given an array where each value represents height
- You need to pick **two lines** such that they form a container
- The container should hold the **maximum water**

<img width="801" height="383" alt="image" src="https://github.com/user-attachments/assets/bf18d54e-e7dc-4635-8221-15ec32f7bf20" />

---

## Visual Idea
- Array: [1,8,6,2,5,4,8,3,7]

Think like this:
- Pick two indices → they form walls
- Water stored = width × minimum height

Example:
- Between index 1 (8) and 8 (7)
- Width = 7
- Height = min(8,7) = 7
- Area = 7 × 7 = 49 (maximum)

---

## Types (if applicable)

### 1. Brute Force
- When to use
  - Small arrays
  - Easy understanding

- Idea (step-by-step logic)
  - Try all pairs (i, j)
  - Calculate area
  - Track maximum

---

### 2. Two Pointers (Optimal)
- When to use
  - Best approach
  - Interview standard

- Idea (step-by-step logic)
  - Start with two pointers (start, end)
  - Calculate area
  - Move the pointer with smaller height
  - Repeat until pointers meet

---

## Example: Container With Most Water (Two Pointers)

### Description
- Find maximum water that can be stored between two lines.

### Sample Input
```
height = [1,8,6,2,5,4,8,3,7]
```

### Sample Output
```
49
```

### Explanation
- Start: (1,7) → area = 8  
- Move smaller height pointer  
- Keep checking and updating max  
- Best found between index 1 and 8  
- Area = 7 × 7 = 49

---

### Code (Java)
```java
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxSpace = 0;

        while (start < end) {
            int w = end - start;
            int h = Math.min(height[start], height[end]);
            int s = h * w;

            maxSpace = s > maxSpace ? s : maxSpace;

            if (height[end] < height[start]) {
                end--;
            } else {
                start++;
            }
        }

        return maxSpace;
    }
}
```

### Complexity
- Time: O(n)
- Space: O(1)

---

## Example: Container With Most Water (Brute Force)

### Description
- Check all pairs.

### Sample Input
```
height = [1,8,6]
```

### Sample Output
```
6
```

### Explanation
- (1,8) → area = 1  
- (1,6) → area = 2  
- (8,6) → area = 6 → max

---

### Code (Java)
```java
class ContainerBrute {
    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                int area = h * w;

                if (area > max) {
                    max = area;
                }
            }
        }

        return max;
    }
}
```

### Complexity
- Time: O(n^2)
- Space: O(1)

---

## When to Use
- When asked to find maximum area between two points
- When problem involves width × height
- Classic two-pointer optimization problem

---

## Simple Rule
- Always move the pointer with smaller height
- Because bigger height cannot help if width reduces

---

## Common Mistakes
- Moving the larger height pointer (wrong)
- Not calculating width correctly (end - start)
- Forgetting to update max area
- Using brute force in interview

---

## Summary Table

| Type            | Use                | Time   | Space |
|-----------------|--------------------|--------|-------|
| Brute Force     | Small arrays       | O(n^2) | O(1)  |
| Two Pointers    | Best approach      | O(n)   | O(1)  |
