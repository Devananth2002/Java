# Time Complexity in Programming (Complete Interview Guide)

---

# What is Time Complexity?

Time Complexity measures:

> How the running time of an algorithm grows as input size increases.

It does **NOT** measure actual seconds.

It tells:

- If input becomes very large, will program still be efficient?
- How much work algorithm performs

Example:

- Input size = 10 → fast
- Input size = 1000000 → maybe slow

Time complexity helps predict this.

---

# Why Time Complexity is Important

## In Real Projects

Used to:

- Build scalable software
- Avoid slow systems
- Optimize APIs
- Handle large datasets

Example:

Searching 10 users is easy.

Searching 10 million users needs efficient algorithm.

---

## In Interviews

Interviewers check:

- Can you analyze algorithm efficiency?
- Can you optimize brute force solutions?

Common interview question:

"Can you improve this solution?"

---

# Big O Notation

Big O describes upper bound (worst case).

Syntax:

O(expression)

Examples:

- O(1)
- O(n)
- O(log n)
- O(n^2)

---

# Common Time Complexities

---

# 1. O(1) - Constant Time

## Meaning

Execution time does not depend on input size.

Same work always.

## Example

```java
int getFirst(int[] arr) {
    return arr[0];
}
```

## Analysis

Only 1 operation:

- Access first element

Array size:

- 10
- 1000
- 1000000

Still same.

## Complexity

O(1)

## Real Examples

- Array index access
- Stack push/pop
- HashMap get() average

## Interview Notes

Best possible complexity.

---

# 2. O(n) - Linear Time

## Meaning

Work grows proportional to input.

More data = more work.

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

If n = 5:

Loop runs 5 times.

If n = 100:

Loop runs 100 times.

## Complexity

O(n)

## Real Examples

- Linear search
- Traversing array
- Counting items

## Interview Notes

Very common and acceptable.

---

# 3. O(n^2) - Quadratic Time

## Meaning

Nested loops usually create quadratic growth.

## Example

```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```

## Analysis

If n = 3:

Outer loop = 3

Inner loop = 3 each time

Total:

3 * 3 = 9

If n = 100:

100 * 100 = 10000

## Complexity

O(n^2)

## Real Examples

- Bubble sort
- Comparing all pairs

## Interview Notes

Bad for large input.

Try optimizing.

---

# 4. O(log n) - Logarithmic Time

## Meaning

Problem size halves each step.

Very efficient.

## Example: Binary Search

```java
int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;

    while(low <= high) {
        int mid = (low + high) / 2;

        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return -1;
}
```

## Analysis

Each step removes half data.

Example:

1000 elements

Steps:

1000 -> 500 -> 250 -> 125 -> 62 ...

Very small steps.

## Complexity

O(log n)

## Real Examples

- Binary search
- Balanced BST

## Interview Notes

Very efficient.

Requires sorted data.

---

# 5. O(n log n)

## Meaning

Common in efficient sorting.

## Example

- Merge Sort
- Heap Sort
- Quick Sort average

## Why?

Divide problem:

log n

Work each level:

n

Total:

n * log n

## Complexity

O(n log n)

## Interview Notes

Very good for sorting.

---

# 6. O(2^n) - Exponential Time

## Meaning

Work doubles every step.

Very slow.

## Example

```java
int fib(int n) {
    if(n <= 1) return n;

    return fib(n - 1) + fib(n - 2);
}
```

## Analysis

Repeated recalculation.

fib(5):

Calls fib(4), fib(3)

fib(4) again calls fib(3), fib(2)

Repeated work.

## Complexity

O(2^n)

## Interview Notes

Usually optimize using:

- Memoization
- Dynamic Programming

---

# Rules to Calculate Time Complexity

---

# Rule 1: Ignore Constants

Example:

```java
for(int i = 0; i < 2*n; i++) {}
```

Complexity:

O(2n)

Ignore constant 2.

Final:

O(n)

---

# Rule 2: Drop Smaller Terms

Example:

O(n^2 + n + 5)

Largest term dominates.

Final:

O(n^2)

---

# Rule 3: Sequential Loops Add

Example:

```java
for(int i = 0; i < n; i++) {}

for(int j = 0; j < n; j++) {}
```

O(n + n)

Simplify:

O(2n)

Final:

O(n)

---

# Rule 4: Nested Loops Multiply

Example:

```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < n; j++) {}
}
```

O(n * n)

Final:

O(n^2)

---

# Rule 5: Different Inputs

Example:

```java
for(int i = 0; i < n; i++) {
    for(int j = 0; j < m; j++) {}
}
```

Complexity:

O(n * m)

Not O(n^2)

Because different inputs.

---

# Best, Average, Worst Case

---

# Best Case

Minimum work.

Example:

Search first element immediately.

---

# Average Case

Typical scenario.

---

# Worst Case

Maximum work.

Most important in interviews.

Example:

Search last element.

---

# Complexity Order (Best to Worst)

```text
O(1)
O(log n)
O(n)
O(n log n)
O(n^2)
O(2^n)
O(n!)
```

---

# Common Interview Questions

---

## Q1. What is time complexity?

Answer:

Time complexity measures how algorithm running time grows with input size.

---

## Q2. Why ignore constants?

Answer:

Because growth matters more than exact operations.

---

## Q3. Difference between O(n) and O(log n)?

Answer:

O(n):

Check every element.

O(log n):

Reduce problem by half each step.

---

## Q4. Why is nested loop O(n^2)?

Answer:

Outer loop runs n times.

Inner loop runs n times for each outer iteration.

Total:

n * n

---

## Q5. Can O(n^2) be optimized?

Answer:

Often yes.

Using:

- HashMap
- Sorting
- Two pointers
- Binary search

---

# Real Life Analogies

---

## O(n)

Searching person in queue one by one.

---

## O(log n)

Searching word in dictionary.

Open middle.

Go left/right.

Repeat.

---

## O(1)

Open first page directly.

---

# Tips for Interviews

1. Always mention worst case.

2. Explain loops carefully.

3. Watch nested loops.

4. Mention optimization possibilities.

Example:

Current solution O(n^2)

Can optimize to O(n) using HashMap.

---

# Quick Cheat Sheet

| Pattern | Complexity |
|---|---|
| Array access | O(1) |
| Single loop | O(n) |
| Nested loop | O(n^2) |
| Halving loop | O(log n) |
| Sorting efficient | O(n log n) |
| Recursive brute force | O(2^n) |

---

# Final Summary

Time Complexity tells:

- How algorithm scales
- Efficiency for large input

Goal:

Prefer:

- O(1)
- O(log n)
- O(n)

Avoid when possible:

- O(n^2)
- O(2^n)

---

# Next Topics

After Time Complexity, learn:

1. Space Complexity
2. Recursion Complexity
3. Sorting Complexity
4. Amortized Analysis
5. Big Omega
6. Big Theta
