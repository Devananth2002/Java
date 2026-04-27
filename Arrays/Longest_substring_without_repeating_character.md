# Longest Substring Without Repeating Characters (Java)

## What is it?
- You are given a string
- You need to find the **length of the longest substring**
- Substring must have **no repeating characters**

---

## Visual Idea
- String: "abcabcbb"

Think like this:
- Start building a substring
- If a character repeats → shrink from left
- Keep track of the longest valid substring

Example:
- "abc" → valid (length 3)
- next "a" repeats → move left
- continue...

Final answer = 3

---

## Types (if applicable)

### 1. Brute Force
- When to use
  - Small strings
  - Easy understanding

- Idea (step-by-step logic)
  - Generate all substrings
  - Check if all characters are unique
  - Track maximum length

---

### 2. Sliding Window (Using Set)
- When to use
  - Interviews
  - Standard approach

- Idea (step-by-step logic)
  - Use two pointers (left, right)
  - Expand right pointer
  - If duplicate → remove from left until valid
  - Track max length

---

### 3. Sliding Window (Using HashMap - Optimized)
- When to use
  - Best and most optimized
  - Avoids unnecessary removals

- Idea (step-by-step logic)
  - Store character → last index
  - If duplicate found:
    - Move left pointer directly
  - Track max length

---

## Example: Longest Substring (Sliding Window - Set)

### Description
- Find length of longest substring with unique characters.

### Sample Input
```
s = "abcabcbb"
```

### Sample Output
```
3
```

### Explanation
- Start with empty set
- Add 'a','b','c' → length = 3
- Next 'a' repeats → remove from left
- Continue process
- Max length = 3

---

### Code (Java)
```java
import java.util.*;

class LongestSubstringSet {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

### Complexity
- Time: O(n)
- Space: O(n)

---

## Example: Longest Substring (Optimized - HashMap)

### Description
- Move left pointer directly using last seen index.

### Sample Input
```
s = "abcabcbb"
```

### Sample Output
```
3
```

### Explanation
- Track last index of each character
- If duplicate:
  - Jump left pointer to correct position
- Avoid unnecessary removals

---

### Code (Java)
```java
import java.util.*;

class LongestSubstringMap {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

### Complexity
- Time: O(n)
- Space: O(n)

---

## Example: Longest Substring (Brute Force)

### Description
- Check all substrings.

### Sample Input
```
s = "bbbbb"
```

### Sample Output
```
1
```

### Explanation
- Possible substrings:
  - "b" → valid
  - "bb" → invalid
- Longest = 1

---

### Code (Java)
```java
import java.util.*;

class LongestSubstringBrute {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();

            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }
}
```

### Complexity
- Time: O(n^2)
- Space: O(n)

---

## When to Use
- When dealing with substrings and uniqueness
- When asked for longest/shortest substring
- Common sliding window problem

---

## Simple Rule
- Expand right pointer
- If duplicate → shrink from left
- Track max length

---

## Common Mistakes
- Not updating left pointer correctly
- Forgetting Math.max for left jump
- Using substring instead of window (slow)
- Confusing substring with subsequence

---

## Summary Table

| Type                    | Use                  | Time   | Space |
|-------------------------|----------------------|--------|-------|
| Brute Force             | Small inputs         | O(n^2) | O(n)  |
| Sliding Window (Set)    | Standard approach    | O(n)   | O(n)  |
| Sliding Window (Map)    | Best optimized       | O(n)   | O(n)  |
