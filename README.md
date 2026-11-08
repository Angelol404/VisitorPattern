# Visitor Pattern — File System

## 1. Project Description

This project demonstrates the Visitor Design Pattern using a simple file system.

The file system contains two types of elements:
- File
- Directory

The Visitor Pattern allows adding new operations without modifying the existing element classes.

## 2. Project Structure

```text
VisitorPattern/
├── src/
│   ├── element/
│   │   ├── Element.java
│   │   ├── File.java
│   │   └── Directory.java
│   ├── visitor/
│   │   ├── Visitor.java
│   │   ├── SizeCalculatorVisitor.java
│   │   ├── SearchVisitor.java
│   │   └── FileCountVisitor.java
│   └── Main.java
└── README.md
```

## 3. Implemented Visitors

### SizeCalculatorVisitor
Calculates the total size of all files in the file system.

### SearchVisitor
Searches for files by name.

### FileCountVisitor
Counts all files, including files inside nested directories.

## 4. Double Dispatch

Each element implements the `accept()` method and calls the corresponding method of the Visitor interface.

For example:

```java
public void accept(Visitor visitor) {
    visitor.visitFile(this);
}
```

This allows the program to select the correct visitor operation based on the concrete element type.

## 5. Clean Code Principles

- Meaningful names: classes and methods have clear names.
- Single Responsibility Principle: each visitor performs one operation.
- Open/Closed Principle: new visitors can be added without changing existing element classes.
- Encapsulation: file system data is stored in private fields.
- Separation of concerns: elements and visitor operations are placed in separate packages.

## 6. How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure JDK 17 is configured.
3. Open `Main.java`.
4. Run the `main()` method.

## 7. Conclusion

The project demonstrates how the Visitor Pattern separates operations from the objects on which they operate. It also shows the trade-off between extensibility and encapsulation: adding new operations is easy, but adding new element types requires updating the Visitor interface and its implementations.