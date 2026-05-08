# Java Interview guide
## Core Java Beginner to Intermediate Questions

---

# 1. What is Java?

## Answer

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

## Q) Why is Java platform independent?

### Answer

Java source code is converted into bytecode.

This bytecode can run on any machine that has JVM installed.

Since JVM exists for multiple operating systems:
- Windows
- Linux
- macOS

the same Java program works everywhere.

---

## Q) What is bytecode?

### Answer

Bytecode is the intermediate code generated after compilation.

```text
.java → .class
```

JVM understands bytecode and converts it into machine instructions.

---

## Q) Why is Java secure?

### Answer

Java provides security through:
- No direct pointer access
- Bytecode verification
- JVM sandbox
- Automatic memory management
- Security manager

---

# 2. What is the difference between JDK, JRE, and JVM?

## Answer

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

## Q) Can we run Java program without JDK?

### Answer

Yes.

To run Java applications, only JRE is enough.

JDK is needed only for development.

---

## Q) Does JVM understand Java source code?

### Answer

No.

JVM understands only bytecode.

Compiler converts source code into bytecode first.

---

# 3. Explain primitive data types in Java

## Answer

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

## Q) Difference between primitive and object?

### Answer

| Primitive | Object |
|---|---|
| Stores actual value | Stores reference |
| Faster | Slower |
| Fixed size | Dynamic |
| Cannot call methods | Can call methods |

---

## Q) Why wrapper classes are needed?

### Answer

Collections work only with objects.

Example:

```java
ArrayList<Integer> list = new ArrayList<>();
```

Wrapper classes also provide utility methods.

---

# 4. Difference between == and equals()

## Answer

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

## Q) Why does == sometimes work for String literals?

### Answer

Because Java stores string literals in String Pool.

Example:

```java
String a = "hello";
String b = "hello";
```

Both references point to same object.

---

## Q) What is String Pool?

### Answer

String Pool is special memory area inside heap.

Duplicate string literals are reused to save memory.

---

## Q) Difference between equals() and hashCode()?

### Answer

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

## Answer

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

## Q) Where are Strings stored?

### Answer

String objects are stored in heap.

String literals may be stored inside String Pool.

---

## Q) Why StringBuilder is faster?

### Answer

StringBuilder modifies same object instead of creating new objects repeatedly.

---

# 6. Difference between String, StringBuilder, and StringBuffer

## Answer

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

## Q) When should we use StringBuilder?

### Answer

Use StringBuilder in:
- Single-threaded applications
- Frequent string modifications

Example:
- Building SQL queries
- Loops

---

## Q) Why is StringBuffer slower?

### Answer

Because methods are synchronized for thread safety.

Synchronization adds overhead.

---

# 7. Explain constructors in Java

## Answer

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

## Q) Can constructor be private?

### Answer

Yes.

Used in:
- Singleton pattern
- Utility classes

---

## Q) Can constructor be inherited?

### Answer

No.

Constructors belong to class initialization only.

---

## Q) Can constructor be overloaded?

### Answer

Yes.

Multiple constructors with different parameters are allowed.

---

# 8. What is method overloading?

## Answer

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

## Q) Why can't methods overload only by return type?

### Answer

Compiler cannot determine which method to call.

Example:

```java
int test()
double test()
```

Creates ambiguity.

---

## Q) Is overloading compile-time or runtime?

### Answer

Compile-time.

Compiler decides method using parameters.

---

# 9. What is method overriding?

## Answer

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

## Q) Can static methods be overridden?

### Answer

No.

Static methods belong to class.

This is called method hiding.

---

## Q) Can private methods be overridden?

### Answer

No.

Private methods are not visible in child class.

---

## Q) Difference between overload and override?

### Answer

| Overloading | Overriding |
|---|---|
| Same class | Parent-child class |
| Compile time | Runtime |
| Parameters differ | Parameters same |

---

# 10. Explain inheritance in Java

## Answer

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

## Q) Why Java doesn't support multiple inheritance?

### Answer

To avoid Diamond Problem ambiguity.

---

## Q) What is IS-A relationship?

### Answer

Inheritance represents IS-A relationship.

Example:

```text
Dog IS-A Animal
```

---

# 11. What is encapsulation?

## Answer

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

## Q) Why use getters and setters?

### Answer

They provide controlled access to variables.

Validation can also be added.

Example:

```java
if(salary > 0)
```

---

## Q) Difference between abstraction and encapsulation?

### Answer

| Abstraction | Encapsulation |
|---|---|
| Hides implementation | Hides data |
| Focus on behavior | Focus on security |

---

# 12. What is abstraction?

## Answer

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

## Q) Difference between abstract class and interface?

### Answer

| Abstract Class | Interface |
|---|---|
| Can have constructors | Cannot |
| Can have normal methods | Mostly abstract methods |
| Supports partial abstraction | Full abstraction |

---

## Q) Can abstract class have constructor?

### Answer

Yes.

Used during child object initialization.

---

# 13. What is polymorphism?

## Answer

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

## Q) What is dynamic method dispatch?

### Answer

Method call resolved during runtime.

JVM decides which overridden method to execute.

---

# 14. Difference between Array and ArrayList

## Answer

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

## Q) Why ArrayList cannot store primitives?

### Answer

Collections work only with objects.

Wrapper classes are used instead.

---

## Q) Difference between ArrayList and LinkedList?

### Answer

| ArrayList | LinkedList |
|---|---|
| Fast random access | Fast insertion/deletion |
| Uses dynamic array | Uses doubly linked list |

---

# 15. What are exceptions in Java?

## Answer

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

## Q) Difference between throw and throws?

### Answer

| throw | throws |
|---|---|
| Used to throw exception | Declares exceptions |
| Inside method | Method signature |

---

## Q) Can finally block skip execution?

### Answer

Usually no.

But may skip in cases like:
- System.exit()
- JVM crash

---

## Q) What is custom exception?

### Answer

User-defined exception created by extending Exception class.

Example:

```java
class InvalidAgeException extends Exception {
}
```

---
```