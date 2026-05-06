# Space Complexity in Programming (Complete Interview Guide)

---

# What is Space Complexity?

Space Complexity measures:

> How much extra memory an algorithm uses as input size increases.

It includes:

1. Input space (given data)
2. Auxiliary space (extra memory used by algorithm)

---

# Key Idea

We mainly focus on:

> Auxiliary Space (extra memory used)

Because input is already given.

---

# Why Space Complexity is Important

## In Real Systems

- Memory is limited
- Large data → memory overflow risk
- Important in:
  - Mobile apps
  - Embedded systems
  - Large-scale systems

---

## In Interviews

Interviewers check:

- Can you optimize memory?
- Can you trade space for time?

---

# Types of Space Usage

---

## 1. Input Space

Memory used to store input.

Example:

```java
int[] arr = new int[n];
```

Space = O(n)

---

## 2. Auxiliary Space

Extra memory used by algorithm.

Example:

```java
int sum = 0;
```

Space = O(1)

---

# Common Space Complexities

---

# 1. O(1) - Constant Space

## Meaning

Memory does not grow with input size.

## Example

```java
int sum(int[] arr) {
    int total = 0;

    for(int i = 0; i < arr.length; i++) {
        total += arr[i];
    }

    return total;
}
```

## Analysis

Only one variable used.

## Complexity

O(1)

## Interview Notes

Best space efficiency.

---

# 2. O(n) - Linear Space

## Meaning

Memory grows with input size.

## Example

```java
int[] copy(int[] arr) {
    int[] newArr = new int[arr.length];

    for(int i = 0; i < arr.length; i++) {
        newArr[i] = arr[i];
    }

    return newArr;
}
```

## Analysis

New array of size n.

## Complexity

O(n)

## Interview Notes

Common when copying data.

---

# 3. O(n^2) - Quadratic Space

## Meaning

Memory grows as square of input.

## Example

```java
int[][] matrix = new int[n][n];
```

## Analysis

n rows * n columns

## Complexity

O(n^2)

---

# Space Complexity in Recursion

---

# Call Stack Space

Each recursive call uses memory.

---

## Example: Factorial

```java
int fact(int n) {
    if(n == 0) return 1;

    return n * fact(n - 1);
}
```

## Analysis

Calls:

fact(5)
fact(4)
fact(3)
fact(2)
fact(1)

Total stack depth = n

## Complexity

O(n)

---

## Example: Fibonacci (Recursive)

```java
int fib(int n) {
    if(n <= 1) return n;

    return fib(n-1) + fib(n-2);
}
```

## Analysis

Tree recursion.

Max depth = n

## Space Complexity

O(n)

(Not O(2^n) for space — that is time)

---

# Important Rules

---

# Rule 1: Ignore Input Space (Usually)

Focus on auxiliary space.

---

# Rule 2: Variables Count

```java
int a, b, c;
```

Space = O(1)

---

# Rule 3: Arrays / Lists Matter

```java
int[] arr = new int[n];
```

Space = O(n)

---

# Rule 4: Recursion Adds Stack Space

Each call uses memory.

---

# Rule 5: In-place Algorithms

If no extra memory used:

Space = O(1)

---

# In-place vs Extra Space

---

## In-place Algorithm

Modifies input directly.

Example:

```java
for(int i = 0; i < n/2; i++) {
    int temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;
}
```

Space = O(1)

---

## Extra Space Algorithm

Uses new memory.

Example:

```java
int[] reversed = new int[n];
```

Space = O(n)

---

# Space vs Time Trade-off

---

## Concept

Sometimes we use more memory to reduce time.

---

## Example

### Without HashMap

```java
for(int i = 0; i < n; i++) {
    for(int j = i+1; j < n; j++) {
        if(arr[i] + arr[j] == target) {
            return true;
        }
    }
}
```

Time = O(n^2)  
Space = O(1)

---

### With HashMap

```java
HashSet<Integer> set = new HashSet<>();

for(int num : arr) {
    if(set.contains(target - num)) {
        return true;
    }
    set.add(num);
}
```

Time = O(n)  
Space = O(n)

---

## Interview Insight

Trade:

More space → less time  
Less space → more time

---

# Common Interview Questions

---

## Q1. What is space complexity?

Answer:

Space complexity measures how much memory an algorithm uses as input size increases.

---

## Q2. Difference between O(1) and O(n) space?

Answer:

O(1):

Constant memory.

O(n):

Memory grows with input.

---

## Q3. Does recursion use space?

Answer:

Yes.

Call stack uses memory.

---

## Q4. Why is recursion O(n) space?

Answer:

Each function call stays in stack until completion.

---

## Q5. Can space be optimized?

Answer:

Yes:

- Use in-place algorithms
- Avoid unnecessary data structures

---

# Real-Life Analogy

---

## O(1)

You carry one notebook regardless of task.

---

## O(n)

You take one notebook per student.

---

## O(n^2)

You store data in a full classroom grid.

---

# Quick Cheat Sheet

| Pattern | Space Complexity |
|---|---|
| Variables only | O(1) |
| New array of size n | O(n) |
| Matrix n x n | O(n^2) |
| Recursion depth n | O(n) |
| In-place algorithm | O(1) |

---

# Final Summary

Space Complexity tells:

- How memory grows with input

Focus:

- Auxiliary space
- Stack space (recursion)

Goal:

Prefer:

- O(1) space

Use O(n) only if needed for speed improvement.
