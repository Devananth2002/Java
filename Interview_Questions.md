# Java Interview Guide
## Core Java Beginner to Intermediate Questions

---

# 1. What is Java?

Java is a high-level, object-oriented, platform-independent programming language developed by Sun Microsystems.

Java is designed with the idea:

```text
Write Once Run Anywhere
```

This means Java programs can run on any operating system that has a JVM installed.

---

## Main Features of Java

- Object-Oriented
- Platform Independent
- Secure
- Robust
- Multithreaded
- Automatic Memory Management
- Distributed
- Portable

---

## How Java Works

```text
.java file
   ↓
Compiler (javac)
   ↓
Bytecode (.class)
   ↓
JVM
   ↓
Machine Code
```

---

## Example

```java
class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

---

# Follow-up Questions

---

## Why is Java platform independent?

Java source code is converted into bytecode.

This bytecode can run on any machine that has JVM installed.

Since JVM exists for multiple operating systems:
- Windows
- Linux
- macOS

the same Java program works everywhere.

---

## What is bytecode?

Bytecode is the intermediate code generated after compilation.

```text
.java → .class
```

JVM understands bytecode and converts it into machine instructions.

---

## Why is Java secure?

Java provides security through:
- No direct pointer access
- Bytecode verification
- JVM sandbox
- Automatic memory management

---

# 2. What is the difference between JDK, JRE, and JVM?

JDK, JRE, and JVM are core parts of Java.

---

## JVM (Java Virtual Machine)

JVM is responsible for running Java bytecode.

Responsibilities:
- Executes bytecode
- Memory management
- Garbage collection
- Platform independence

---

## JRE (Java Runtime Environment)

JRE provides environment to run Java applications.

Contains:
- JVM
- Java libraries
- Runtime files

Does NOT contain compiler.

---

## JDK (Java Development Kit)

JDK is used for developing Java applications.

Contains:
- JRE
- Compiler (javac)
- Debugger
- Development tools

---

## Hierarchy

```text
JDK
 └── JRE
      └── JVM
```

---

## Example

```bash
javac Main.java
```

Uses JDK compiler.

```bash
java Main
```

Uses JRE and JVM.

---

# Follow-up Questions

---

## Can we run Java program without JDK?

Yes.

To run Java applications, only JRE is enough.

JDK is needed only for development.

---

## Does JVM understand Java source code?

No.

JVM understands only bytecode.

Compiler converts source code into bytecode first.

---

# 3. Explain primitive data types in Java

Primitive data types store actual values directly in memory.

Java has 8 primitive types.

---

## Primitive Types

| Type | Size | Example |
|---|---|---|
| byte | 1 byte | 10 |
| short | 2 bytes | 100 |
| int | 4 bytes | 1000 |
| long | 8 bytes | 10000L |
| float | 4 bytes | 10.5f |
| double | 8 bytes | 20.99 |
| char | 2 bytes | 'A' |
| boolean | JVM dependent | true |

---

## Example

```java
int age = 25;
double salary = 45000.75;
char grade = 'A';
boolean active = true;
```

---

## Why Primitives Are Fast

Primitives:
- Store value directly
- Require less memory
- No object overhead

---

# Follow-up Questions

---

## Difference between primitive and object?

| Primitive | Object |
|---|---|
| Stores actual value | Stores reference |
| Faster | Slower |
| Fixed size | Dynamic |
| Cannot call methods | Can call methods |

---

## Why wrapper classes are needed?

Collections work only with objects.

Example:

```java
ArrayList<Integer> list = new ArrayList<>();
```

Wrapper classes also provide utility methods.

---

## What are wrapper classes?

Wrapper classes convert primitives into objects.

| Primitive | Wrapper |
|---|---|
| int | Integer |
| double | Double |
| char | Character |
| boolean | Boolean |

---

# 4. Difference between == and equals()

`==` compares memory references.

`equals()` compares actual content.

---

## Example

```java
String a = new String("java");
String b = new String("java");

System.out.println(a == b);
System.out.println(a.equals(b));
```

Output:

```text
false
true
```

---

## Why?

- `==` checks if both references point to same object
- `equals()` checks values inside objects

---

## Primitive Example

```java
int x = 10;
int y = 10;

System.out.println(x == y);
```

Output:

```text
true
```

Because primitives store actual values.

---

# Follow-up Questions

---

## Why does == sometimes work for String literals?

Because Java stores string literals in String Pool.

Example:

```java
String a = "hello";
String b = "hello";
```

Both references point to same object.

---

## What is String Pool?

String Pool is special memory area inside heap.

Duplicate string literals are reused to save memory.

---

## Difference between equals() and hashCode()?

- equals() compares content
- hashCode() returns integer hash value

Important rule:

```text
If equals() is true,
hashCode() must also be same
```

Used heavily in:
- HashMap
- HashSet

---

# 5. What is String immutability?

String objects cannot be modified after creation.

Any modification creates a new object.

---

## Example

```java
String s = "Hello";

s.concat(" World");

System.out.println(s);
```

Output:

```text
Hello
```

Because concat() creates new object.

---

## Correct Way

```java
s = s.concat(" World");
```

---

## Why String is Immutable

- Security
- Thread safety
- String pool optimization
- HashMap optimization

---

## Real Example

Database URL should not change accidentally.

Immutable strings prevent this.

---

# Follow-up Questions

---

## Where are Strings stored?

String objects are stored in heap.

String literals may be stored inside String Pool.

---

## Why StringBuilder is faster?

StringBuilder modifies same object instead of creating new objects repeatedly.

---

# 6. Difference between String, StringBuilder, and StringBuffer

| Feature | String | StringBuilder | StringBuffer |
|---|---|---|---|
| Mutable | No | Yes | Yes |
| Thread Safe | Yes | No | Yes |
| Performance | Slow | Fast | Medium |

---

## String Example

```java
String s = "A";
s += "B";
```

Creates new object.

---

## StringBuilder Example

```java
StringBuilder sb = new StringBuilder("A");
sb.append("B");
```

Modifies same object.

---

## StringBuffer Example

```java
StringBuffer sb = new StringBuffer("A");
sb.append("B");
```

Thread safe using synchronization.

---

# Follow-up Questions

---

## When should we use StringBuilder?

Use StringBuilder in:
- Single-threaded applications
- Frequent string modifications

Example:
- Building SQL queries
- Loops

---

## Why is StringBuffer slower?

Because methods are synchronized for thread safety.

Synchronization adds overhead.

---

# 7. Explain constructors in Java

Constructors initialize objects.

Constructor name must match class name.

Constructors do not have return type.

---

## Example

```java
class Student {

    Student() {
        System.out.println("Constructor called");
    }
}
```

---

## Types of Constructors

### Default Constructor

```java
Student() {
}
```

---

### Parameterized Constructor

```java
Student(String name) {
    this.name = name;
}
```

---

# Follow-up Questions

---

## Can constructor be private?

Yes.

Used in:
- Singleton pattern
- Utility classes

---

## Can constructor be inherited?

No.

Constructors belong to class initialization only.

---

## Can constructor be overloaded?

Yes.

Multiple constructors with different parameters are allowed.

---

# 8. What is method overloading?

Method overloading means multiple methods with same name but different parameters.

It is compile-time polymorphism.

---

## Example

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

---

## Rules

Can change:
- Number of parameters
- Type of parameters
- Order of parameters

Cannot overload only using return type.

---

# Follow-up Questions

---

## Why can't methods overload only by return type?

Compiler cannot determine which method to call.

Example:

```java
int test()
double test()
```

Creates ambiguity.

---

## Is overloading compile-time or runtime?

Compile-time.

Compiler decides method using parameters.

---

# 9. What is method overriding?

Method overriding means redefining parent class method in child class.

It is runtime polymorphism.

---

## Example

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

---

## Runtime Example

```java
Animal a = new Dog();
a.sound();
```

Output:

```text
Bark
```

JVM decides method during runtime.

---

# Follow-up Questions

---

## Can static methods be overridden?

No.

Static methods belong to class.

This is called method hiding.

---

## Can private methods be overridden?

No.

Private methods are not visible in child class.

---

## Difference between overload and override?

| Overloading | Overriding |
|---|---|
| Same class | Parent-child class |
| Compile time | Runtime |
| Parameters differ | Parameters same |

---

# 10. Explain inheritance in Java

Inheritance allows child class to acquire properties and methods from parent class.

Promotes:
- Code reuse
- Better organization

---

## Example

```java
class Vehicle {

    void move() {
        System.out.println("Moving");
    }
}

class Car extends Vehicle {
}
```

Car inherits move().

---

## Types of Inheritance

- Single
- Multilevel
- Hierarchical

Java does not support multiple inheritance with classes.

---

# Follow-up Questions

---

## Why Java doesn't support multiple inheritance?

To avoid Diamond Problem ambiguity.

---

## What is IS-A relationship?

Inheritance represents IS-A relationship.

Example:

```text
Dog IS-A Animal
```

---

# 11. What is encapsulation?

Encapsulation means binding data and methods together while restricting direct access.

Done using:
- private variables
- getters/setters

---

## Example

```java
class Employee {

    private int salary;

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
```

---

## Advantages

- Data hiding
- Security
- Better maintainability

---

# Follow-up Questions

---

## Why use getters and setters?

They provide controlled access to variables.

Validation can also be added.

Example:

```java
if(salary > 0)
```

---

## Difference between abstraction and encapsulation?

| Abstraction | Encapsulation |
|---|---|
| Hides implementation | Hides data |
| Focus on behavior | Focus on security |

---

# 12. What is abstraction?

Abstraction hides implementation details and shows only important functionality.

Achieved using:
- Abstract classes
- Interfaces

---

## Example

```java
abstract class Vehicle {

    abstract void start();
}
```

---

## Real Example

Car driver only uses:
- Steering
- Brake
- Accelerator

Internal engine details are hidden.

---

# Follow-up Questions

---

## Difference between abstract class and interface?

| Abstract Class | Interface |
|---|---|
| Can have constructors | Cannot |
| Can have normal methods | Mostly abstract methods |
| Supports partial abstraction | Full abstraction |

---

## Can abstract class have constructor?

Yes.

Used during child object initialization.

---

# 13. What is polymorphism?

Polymorphism means one entity behaving in multiple ways.

Two types:
- Compile-time polymorphism
- Runtime polymorphism

---

## Compile-Time Polymorphism

Achieved using method overloading.

---

## Runtime Polymorphism

Achieved using method overriding.

---

## Example

```java
Animal a = new Dog();
a.sound();
```

Behavior changes during runtime.

---

# Follow-up Questions

---

## What is dynamic method dispatch?

Method call resolved during runtime.

JVM decides which overridden method to execute.

---

# 14. Difference between Array and ArrayList

| Array | ArrayList |
|---|---|
| Fixed size | Dynamic size |
| Faster | Slightly slower |
| Stores primitives | Stores objects |
| Length property | size() method |

---

## Array Example

```java
int[] arr = new int[5];
```

---

## ArrayList Example

```java
ArrayList<Integer> list = new ArrayList<>();
```

---

## Advantages of ArrayList

- Dynamic resizing
- Built-in methods
- Easy insertion/deletion

---

# Follow-up Questions

---

## Why ArrayList cannot store primitives?

Collections work only with objects.

Wrapper classes are used instead.

---

## Difference between ArrayList and LinkedList?

| ArrayList | LinkedList |
|---|---|
| Fast random access | Fast insertion/deletion |
| Uses dynamic array | Uses doubly linked list |

---

# 15. What are exceptions in Java?

Exceptions are runtime problems that interrupt normal execution flow.

Java handles exceptions using:
- try
- catch
- finally

---

## Example

```java
try {
    int x = 10 / 0;
}
catch(ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
finally {
    System.out.println("Done");
}
```

---

## Exception Hierarchy

```text
Throwable
 ├── Error
 └── Exception
       ├── Checked
       └── Unchecked
```

---

## Checked Exceptions

Checked during compile time.

Example:
- IOException
- SQLException

---

## Unchecked Exceptions

Occur during runtime.

Example:
- NullPointerException
- ArithmeticException

---

# Follow-up Questions

---

## Difference between throw and throws?

| throw | throws |
|---|---|
| Used to throw exception | Declares exceptions |
| Inside method | Method signature |

---

## Can finally block skip execution?

Usually no.

But may skip in cases like:
- System.exit()
- JVM crash

---

## What is custom exception?

User-defined exception created by extending Exception class.

Example:

```java
class InvalidAgeException extends Exception {
}
```

---

# 16. What is the Java Collections Framework?

Java Collections Framework (JCF) is a set of classes and interfaces used to store and manipulate groups of objects efficiently.

It provides:
- Dynamic data structures
- Searching
- Sorting
- Insertion
- Deletion
- Traversal utilities

---

## Main Interfaces

```text
Collection
 ├── List
 ├── Set
 └── Queue

Map (separate hierarchy)
```

---

## Important Implementations

| Interface | Common Classes |
|---|---|
| List | ArrayList, LinkedList, Vector |
| Set | HashSet, LinkedHashSet, TreeSet |
| Queue | PriorityQueue |
| Map | HashMap, LinkedHashMap, TreeMap |

---

## Advantages

- Reusable data structures
- Reduces coding effort
- Improves performance
- Built-in algorithms

---

# Follow-up Questions

---

## Why Map is not part of Collection interface?

Map stores key-value pairs instead of individual objects.

So its structure differs from Collection hierarchy.

---

## Difference between Collection and Collections?

| Collection | Collections |
|---|---|
| Interface | Utility class |
| Represents data structure | Provides helper methods |

Example:

```java
Collections.sort(list);
```

---

# 17. Difference between ArrayList and LinkedList

Both implement List interface but internally work differently.

---

## ArrayList

Uses dynamic array internally.

Best for:
- Fast random access
- Read-heavy operations

---

## LinkedList

Uses doubly linked list internally.

Best for:
- Frequent insertion/deletion

---

## Comparison

| Feature | ArrayList | LinkedList |
|---|---|---|
| Internal Structure | Dynamic Array | Doubly Linked List |
| Random Access | Fast | Slow |
| Insertion Middle | Slow | Fast |
| Memory Usage | Less | More |

---

## Example

```java
List<Integer> list = new ArrayList<>();
```

```java
List<Integer> list = new LinkedList<>();
```

---

# Follow-up Questions

---

## Why random access is slow in LinkedList?

LinkedList nodes are connected using references.

To access an element, traversal is required.

---

## Which is better for searching?

ArrayList.

Because indexing is fast.

---

# 18. Difference between HashMap and Hashtable

Both store key-value pairs.

---

## HashMap

- Not synchronized
- Faster
- Allows one null key
- Allows multiple null values

---

## Hashtable

- Synchronized
- Slower
- No null key/value allowed

---

## Comparison

| Feature | HashMap | Hashtable |
|---|---|---|
| Thread Safe | No | Yes |
| Performance | Faster | Slower |
| Null Key | Allowed | Not Allowed |
| Null Values | Allowed | Not Allowed |

---

## Example

```java
HashMap<Integer, String> map = new HashMap<>();
```

---

# Follow-up Questions

---

## Why is HashMap faster?

No synchronization overhead.

---

## Is HashMap thread-safe?

No.

Use:
- ConcurrentHashMap
- Collections.synchronizedMap()

for thread safety.

---

# 19. How does HashMap work internally?

HashMap stores data in key-value pairs using hashing.

---

## Internal Working

### Step 1 — hashCode()

HashMap calculates hashcode of key.

```java
key.hashCode()
```

---

### Step 2 — Bucket Index

Hash determines bucket location.

---

### Step 3 — Store Entry

Data stored as:

```text
Node<Key, Value>
```

---

### Step 4 — Collision Handling

If multiple keys map to same bucket:
- Linked List used
- Java 8 may convert to Red-Black Tree

---

## Example

```java
map.put(101, "John");
```

---

## Internal Structure

```text
Bucket
  ↓
[101=John] → [201=Sam]
```

---

# Follow-up Questions

---

## What is collision in HashMap?

When multiple keys map to same bucket.

---

## Why equals() and hashCode() are important?

HashMap uses:
- hashCode() to locate bucket
- equals() to compare keys

---

## What happens if hashCode() is same?

equals() is used for exact comparison.

---

## Why HashMap performance becomes slow sometimes?

Too many collisions increase traversal time.

---

# 20. Difference between HashSet, LinkedHashSet, and TreeSet

All implement Set interface.

Set stores unique values only.

---

## HashSet

- No order maintained
- Fastest

---

## LinkedHashSet

- Maintains insertion order

---

## TreeSet

- Stores sorted data
- Uses Red-Black Tree

---

## Comparison

| Feature | HashSet | LinkedHashSet | TreeSet |
|---|---|---|---|
| Order | No | Insertion Order | Sorted |
| Performance | Fastest | Medium | Slow |
| Null Allowed | Yes | Yes | Usually One |

---

## Example

```java
Set<Integer> set = new TreeSet<>();
```

---

# Follow-up Questions

---

## Why TreeSet is slower?

Sorting is maintained internally.

Uses tree operations.

---

## Can duplicates exist in Set?

No.

---

# 21. Difference between Comparable and Comparator

Both used for sorting.

---

## Comparable

Defines natural sorting order inside class.

Method:

```java
compareTo()
```

---

## Example

```java
class Student implements Comparable<Student> {

    int age;

    public int compareTo(Student s) {
        return this.age - s.age;
    }
}
```

---

## Comparator

Used for custom sorting externally.

Method:

```java
compare()
```

---

## Example

```java
Comparator<Student> c =
    (a, b) -> a.age - b.age;
```

---

## Comparison

| Comparable | Comparator |
|---|---|
| Inside class | Outside class |
| One sorting logic | Multiple sorting logic |
| compareTo() | compare() |

---

# Follow-up Questions

---

## Which is better?

Depends.

- Comparable → default sorting
- Comparator → multiple custom sorting

---

# 22. What is Iterator?

Iterator is used to traverse collections one element at a time.

---

## Methods

| Method | Purpose |
|---|---|
| hasNext() | Checks next element |
| next() | Returns next element |
| remove() | Removes element |

---

## Example

```java
Iterator<Integer> it = list.iterator();

while(it.hasNext()) {
    System.out.println(it.next());
}
```

---

# Follow-up Questions

---

## Difference between Iterator and ListIterator?

| Iterator | ListIterator |
|---|---|
| Forward only | Both directions |
| Works on all collections | Works on List only |

---

## What is fail-fast iterator?

Throws ConcurrentModificationException if collection modified during iteration.

---

# 23. What is Generics in Java?

Generics provide type safety.

Allows specifying data type during object creation.

---

## Without Generics

```java
ArrayList list = new ArrayList();
```

Any object can be inserted.

---

## With Generics

```java
ArrayList<String> list = new ArrayList<>();
```

Only String allowed.

---

## Advantages

- Type safety
- Compile-time checking
- Removes type casting

---

# Follow-up Questions

---

## What is type erasure?

Generic type information removed during compilation.

Java maintains backward compatibility.

---

## Can we use primitive types in Generics?

No.

Use wrapper classes.

Example:

```java
ArrayList<Integer>
```

---

# 24. What is the difference between fail-fast and fail-safe?

---

## Fail-Fast

Throws exception if collection modified during iteration.

Example:
- ArrayList iterator

---

## Fail-Safe

Works on cloned copy.

No exception occurs.

Example:
- ConcurrentHashMap

---

## Example

```java
ConcurrentHashMap<Integer, String> map
```

---

# Follow-up Questions

---

## Why fail-fast exists?

To prevent inconsistent behavior during iteration.

---

# 25. What is ConcurrentModificationException?

Occurs when collection modified while iterating.

---

## Example

```java
for(String s : list) {
    list.remove(s);
}
```

May throw:

```text
ConcurrentModificationException
```

---

## Correct Way

Use Iterator remove():

```java
Iterator<String> it = list.iterator();

while(it.hasNext()) {
    it.next();
    it.remove();
}
```

---

# Follow-up Questions

---

## Does ConcurrentModificationException occur always?

No.

It is best-effort behavior.

---

# 26. What is immutable class?

Immutable class objects cannot change after creation.

---

## Example

String class is immutable.

---

## Rules to Create Immutable Class

- Make class final
- Make fields private final
- No setters
- Initialize through constructor

---

## Example

```java
final class Employee {

    private final int id;

    Employee(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
```

---

# Follow-up Questions

---

## Why immutable objects are useful?

- Thread safe
- Secure
- Easy caching
- Safe sharing

---

# 27. What is Object class in Java?

Object class is parent of all Java classes.

Every class implicitly extends Object.

---

## Important Methods

| Method | Purpose |
|---|---|
| toString() | Object string representation |
| equals() | Compare objects |
| hashCode() | Hash value |
| clone() | Copy object |
| finalize() | Cleanup |

---

## Example

```java
class Student {
}
```

Actually becomes:

```java
class Student extends Object {
}
```

---

# Follow-up Questions

---

## Why override toString()?

Provides meaningful object output.

---

## Example

```java
System.out.println(obj);
```

Internally calls:

```java
obj.toString()
```

---

# 28. What is garbage collection?

Garbage collection automatically removes unused objects from memory.

Handled by JVM.

---

## Example

```java
Student s = new Student();

s = null;
```

Object becomes eligible for garbage collection.

---

## Advantages

- Automatic memory management
- Prevents memory leaks
- Simplifies programming

---

# Follow-up Questions

---

## Can we force garbage collection?

We can request using:

```java
System.gc();
```

But JVM may ignore it.

---

## What is memory leak in Java?

Unused objects retained unnecessarily.

Usually due to references not cleared.

---

# 29. Difference between stack and heap memory

---

## Stack Memory

Stores:
- Local variables
- Method calls

Fast access.

---

## Heap Memory

Stores:
- Objects
- Instance variables

Shared across threads.

---

## Comparison

| Stack | Heap |
|---|---|
| Method memory | Object memory |
| Faster | Slower |
| Thread specific | Shared |

---

# Follow-up Questions

---

## Where are objects stored?

Heap memory.

---

## Where are references stored?

Usually in stack for local variables.

---

# 30. What is static keyword in Java?

static belongs to class instead of object.

Shared among all objects.

---

## Static Variable Example

```java
class Student {

    static String college = "ABC";
}
```

Single copy shared.

---

## Static Method Example

```java
static void show() {
}
```

Can be called without object.

---

## Example

```java
Math.max(10, 20);
```

---

# Follow-up Questions

---

## Can static methods access non-static variables?

No.

Because non-static variables belong to objects.

---

## Why main method is static?

JVM calls main() without creating object.


---

# 31. What is the difference between class and object?

A class is a blueprint or template.

An object is a real instance created from the class.

---

## Example

```java
class Car {

    String color;

    void drive() {
        System.out.println("Driving");
    }
}
```

Object creation:

```java
Car c = new Car();
```

---

## Real-Time Example

```text
Class  → Car Blueprint
Object → Actual Car
```

---

# Follow-up Questions

---

## Where are objects stored?

Objects are stored in heap memory.

---

## What does new keyword do?

- Allocates memory
- Creates object
- Returns reference

---

# 32. What is the difference between instance variable, local variable, and static variable?

---

## Instance Variable

Belongs to object.

Each object gets separate copy.

---

## Static Variable

Belongs to class.

Shared among all objects.

---

## Local Variable

Declared inside methods.

Exists only during method execution.

---

## Example

```java
class Test {

    static int x = 10;     // static
    int y = 20;            // instance

    void show() {
        int z = 30;        // local
    }
}
```

---

## Comparison

| Variable | Memory | Scope |
|---|---|---|
| Static | Method Area | Class |
| Instance | Heap | Object |
| Local | Stack | Method |

---

# Follow-up Questions

---

## Which variables get default values?

- Static variables
- Instance variables

Local variables do not.

---

## Why local variables don't get default values?

Compiler forces initialization to avoid garbage values.

---

# 33. What is this keyword?

`this` refers to current object.

---

## Uses of this

- Access current object variables
- Call current object methods
- Invoke constructors
- Pass current object

---

## Example

```java
class Student {

    int id;

    Student(int id) {
        this.id = id;
    }
}
```

---

## Why this is needed?

To differentiate:
- instance variable
- local variable

---

# Follow-up Questions

---

## Can we use this inside static method?

No.

Static methods belong to class, not object.

---

## What is this()?

Used to call another constructor in same class.

---

## Example

```java
class Test {

    Test() {
        this(10);
    }

    Test(int x) {
    }
}
```

---

# 34. What is super keyword?

`super` refers to parent class object.

---

## Uses

- Access parent variables
- Access parent methods
- Call parent constructor

---

## Example

```java
class Animal {

    void sound() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {

    void sound() {
        super.sound();
        System.out.println("Dog");
    }
}
```

---

# Follow-up Questions

---

## What is super()?

Calls parent constructor.

Automatically added by compiler.

---

## Can we use both this() and super() together?

No.

Constructor first statement can only be one.

---

# 35. What are access modifiers in Java?

Access modifiers control visibility.

---

## Types

| Modifier | Same Class | Same Package | Child Class | Other Package |
|---|---|---|---|---|
| private | Yes | No | No | No |
| default | Yes | Yes | No | No |
| protected | Yes | Yes | Yes | No |
| public | Yes | Yes | Yes | Yes |

---

## Example

```java
private int salary;
```

---

# Follow-up Questions

---

## What is default access modifier?

No modifier specified.

Accessible only inside same package.

---

## Which modifier gives maximum restriction?

private

---

# 36. What is final keyword?

final restricts modification.

---

## final Variable

Cannot change value.

```java
final int x = 10;
```

---

## final Method

Cannot override.

---

## final Class

Cannot inherit.

---

## Example

```java
final class Utility {
}
```

---

# Follow-up Questions

---

## Why String class is final?

To prevent inheritance and maintain immutability/security.

---

## Can final variable be initialized later?

Yes.

Inside constructor.

---

# 37. What is instanceof operator?

Checks whether object belongs to specific class.

---

## Example

```java
Dog d = new Dog();

System.out.println(d instanceof Dog);
```

Output:

```text
true
```

---

# Follow-up Questions

---

## Why instanceof is useful?

Used before type casting to avoid ClassCastException.

---

# 38. What is type casting in Java?

Converting one type into another.

---

## Primitive Casting

### Widening

Automatic conversion.

```java
int x = 10;
double y = x;
```

---

### Narrowing

Manual conversion.

```java
double x = 10.5;
int y = (int)x;
```

---

## Object Casting

---

### Upcasting

Child → Parent

```java
Animal a = new Dog();
```

---

### Downcasting

Parent → Child

```java
Dog d = (Dog)a;
```

---

# Follow-up Questions

---

## Why downcasting is risky?

May throw:

```text
ClassCastException
```

if object type mismatches.

---

# 39. What is aggregation?

Aggregation represents HAS-A relationship.

One class contains another class reference.

---

## Example

```java
class Address {
}

class Employee {

    Address address;
}
```

Employee HAS-A Address.

---

## Special Point

Contained object can exist independently.

---

# Follow-up Questions

---

## Difference between aggregation and inheritance?

| Aggregation | Inheritance |
|---|---|
| HAS-A | IS-A |
| Reuse by composition | Reuse by extension |

---

# 40. What is composition?

Strong form of aggregation.

Contained object cannot exist independently.

---

## Example

```java
class Engine {
}

class Car {

    private Engine engine = new Engine();
}
```

Destroying Car destroys Engine relation.

---

# Follow-up Questions

---

## Difference between aggregation and composition?

| Aggregation | Composition |
|---|---|
| Weak relationship | Strong relationship |
| Independent lifecycle | Dependent lifecycle |

---

# 41. What is association?

Association represents relationship between objects.

---

## Example

```text
Teacher teaches Student
```

Both can exist independently.

---

## Types

- One-to-One
- One-to-Many
- Many-to-Many

---

# 42. What is coupling in Java?

Coupling means dependency between classes.

---

## Tight Coupling

Classes heavily depend on each other.

Hard to maintain.

---

## Loose Coupling

Minimal dependency.

Easy to maintain/test.

---

## Example

Using interfaces promotes loose coupling.

---

# Follow-up Questions

---

## Why loose coupling is preferred?

- Easier testing
- Better maintainability
- Flexible design

---

# 43. What is cohesion?

Cohesion measures how strongly related class responsibilities are.

---

## High Cohesion

Class performs single focused task.

Preferred design.

---

## Low Cohesion

Class performs unrelated tasks.

Bad design.

---

# Follow-up Questions

---

## Difference between coupling and cohesion?

| Coupling | Cohesion |
|---|---|
| Between classes | Within class |
| Low preferred | High preferred |

---

# 44. What is package in Java?

Package groups related classes/interfaces.

---

## Advantages

- Avoid naming conflicts
- Better organization
- Access control

---

## Example

```java
package com.company.project;
```

---

# Follow-up Questions

---

## Difference between import and package?

| package | import |
|---|---|
| Declares package | Uses package classes |

---

# 45. What is singleton class?

Singleton allows only one object creation.

---

## Example

```java
class Singleton {

    private static Singleton obj =
        new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return obj;
    }
}
```

---

## Uses

- Logging
- Configuration
- Database connection

---

# Follow-up Questions

---

## Why constructor is private in Singleton?

Prevents external object creation.

---

## Is Singleton thread-safe?

Depends on implementation.

Need synchronization for multithreading.

---

# 46. What is mutable and immutable object?

---

## Mutable Object

Object state can change.

Example:

```java
StringBuilder
```

---

## Immutable Object

Object state cannot change.

Example:

```java
String
```

---

# Follow-up Questions

---

## Why immutable objects are thread-safe?

State never changes after creation.

No synchronization needed.

---

# 47. What is shallow copy and deep copy?

---

## Shallow Copy

Copies references.

Nested objects shared.

---

## Deep Copy

Copies entire object hierarchy.

Independent objects created.

---

## Example

```text
Shallow → Shared references
Deep    → Separate references
```

---

# Follow-up Questions

---

## Which is safer?

Deep copy.

Because changes won't affect original object.

---

# 48. What is clone() method?

clone() creates copy of object.

Defined in Object class.

---

## Example

```java
Student s2 = (Student)s1.clone();
```

---

## Important Point

Class must implement:

```java
Cloneable
```

otherwise:

```text
CloneNotSupportedException
```

occurs.

---

# Follow-up Questions

---

## Why clone() is controversial?

- Shallow copy issues
- Complex implementation
- Constructor bypassing

Many developers prefer copy constructors.

---

# 49. What is marker interface?

Interface without methods.

Used to provide metadata to JVM/compiler.

---

## Examples

- Serializable
- Cloneable

---

## Example

```java
interface Serializable {
}
```

---

# Follow-up Questions

---

## Why marker interfaces are used?

To signal special behavior.

Example:
- Serialization support

---

# 50. What is serialization in Java?

Serialization converts object into byte stream.

Used for:
- File storage
- Network transfer
- Caching

---

## Example

```java
class Student implements Serializable {
}
```

---

## Deserialization

Byte stream converted back into object.

---

# Follow-up Questions

---

## What is transient keyword?

Prevents variable serialization.

---

## Example

```java
transient String password;
```

---

## Why serialization is useful?

- Data persistence
- Distributed systems
- Session storage

---

