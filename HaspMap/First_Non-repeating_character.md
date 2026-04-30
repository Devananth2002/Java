# First Non-Repeating Character of Given String (Java)

## What is it?
- You are given a string
- You need to find the **first character that appears only once**
- If all characters repeat → return no result (or special value)

---

## Visual Idea
- String: "aabbcde"

Think like counting:
- a → repeats ❌  
- b → repeats ❌  
- c → appears once ✅  

👉 First non-repeating = **c**

---

## Types (if applicable)

### 1. Brute Force
- When to use
  - Very small strings
  - For understanding logic

- Idea (step-by-step logic)
  - For each character:
    - Count how many times it appears
  - If count = 1 → return it
  - First such character is answer

---

### 2. HashMap (Best for Interviews)
- When to use
  - Standard and most common approach
  - Works for all cases

- Idea (step-by-step logic)
  - Count frequency of each character using map
  - Loop again through string
  - First character with count = 1 → answer

---

### 3. Array (Optimized for lowercase letters)
- When to use
  - Only when characters are a–z
  - Faster and uses less memory

- Idea (step-by-step logic)
  - Create array of size 26
  - Count frequency
  - Loop again to find first character with count = 1

---

## Example: First Non-Repeating Character (HashMap)

### Description
- Find the first character that does not repeat.

### Sample Input
s = "aabbcde"

### Sample Output
c

### Explanation
- Count:
  - a → 2
  - b → 2
  - c → 1 ✅
- First unique character = **c**

---

### Code (Java)
    import java.util.*;

    class FirstNonRepeatingMap {
        public static char findFirst(String s) {
            Map<Character, Integer> map = new HashMap<>();

            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            for (char ch : s.toCharArray()) {
                if (map.get(ch) == 1) {
                    return ch;
                }
            }

            return '_';
        }
    }

### Complexity
- Time: O(n)
- Space: O(n)

---

## Example: First Non-Repeating Character (Array)

### Description
- Use array instead of map for better performance (only a–z).

### Sample Input
s = "leetcode"

### Sample Output
l

### Explanation
- l → 1 ✅  
- e → repeats  
- First unique = **l**

---

### Code (Java)
    class FirstNonRepeatingArray {
        public static char findFirst(String s) {
            int[] freq = new int[26];

            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            for (char ch : s.toCharArray()) {
                if (freq[ch - 'a'] == 1) {
                    return ch;
                }
            }

            return '_';
        }
    }

### Complexity
- Time: O(n)
- Space: O(1)

---

## Example: First Non-Repeating Character (Brute Force)

### Description
- Check each character manually.

### Sample Input
s = "aabb"

### Sample Output
_

### Explanation
- a → repeats  
- b → repeats  
- No unique character  

---

### Code (Java)
    class FirstNonRepeatingBrute {
        public static char findFirst(String s) {
            for (int i = 0; i < s.length(); i++) {
                int count = 0;

                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        count++;
                    }
                }

                if (count == 1) {
                    return s.charAt(i);
                }
            }

            return '_';
        }
    }

### Complexity
- Time: O(n^2)
- Space: O(1)

---

## When to Use
- When interviewer asks:
  - First unique character
  - First non-repeating character

---

## Simple Rule
- First **count all characters**
- Then **find first with count = 1**

---

## Common Mistakes
- Trying to solve in one loop ❌
- Not maintaining order ❌
- Using map incorrectly ❌
- Forgetting edge case (no unique character) ❌

---

## Summary Table

| Type        | Use                     | Time   | Space |
|-------------|--------------------------|--------|-------|
| Brute Force | Small input              | O(n^2) | O(1)  |
| HashMap     | Best general solution    | O(n)   | O(n)  |
| Array       | Lowercase optimized      | O(n)   | O(1)  |
