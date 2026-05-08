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