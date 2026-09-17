# OOP-Library-System

## Project Description
A Java console application that manages library items, members, borrowing,
returning, catalog listing, and reports.

## OOP Concepts Applied
- Encapsulation
- Inheritance
- Abstraction
- Polymorphism
- Method Overriding
- Constructors
- Static Members
- Collections: List, Map, Set
- Input Validation
- Custom Exceptions
- Clean Code Practices

## Classes
- `LibraryItem`: Abstract parent class for all library items.
- `Book`: Loan period is 21 days.
- `Magazine`: Loan period is 7 days.
- `DVD`: Loan period is 3 days.
- `Member`: Stores member information and borrowed items.
- `LibraryException`: Handles library rule violations.
- `Library`: Manages catalog, members, and borrowing operations.
- `Main`: Console menu.

## How to Compile and Run

Open a terminal in the project folder and run:

```bash
javac *.java
java Main
```

## Menu
1. Add Item
2. Add Member
3. Borrow Item
4. Return Item
5. List Catalog
6. Report
7. Exit
