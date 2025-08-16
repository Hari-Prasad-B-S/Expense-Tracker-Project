# expenseTracker
java project expense tracker

# Personal Expense Tracker - Steps and Functionalities

## Project Setup Steps

1. **Create Project Directory**
   - Create a folder named `ExpenseTracker` on your local machine.

2. **Create Java Files**
   - Inside the `ExpenseTracker` folder, create the following Java files:
     - `Main.java`
     - `Person.java`
     - `Expense.java`
     - `ExpenseTracker.java`

3. **Copy Code**
   - Copy the respective code provided below into each file.

### Main.java
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Person");
            System.out.println("2. Add Expense");
            System.out.println("3. Show Expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter person's name: ");
                    String name = scanner.nextLine();
                    tracker.addPerson(name);
                    break;
                case 2:
                    System.out.print("Enter person's name for the expense: ");
                    String personName = scanner.nextLine();
                    System.out.print("Enter expense category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    tracker.addExpense(personName, category, amount);
                    break;
                case 3:
                    tracker.showExpenses();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
```
### Person.java
```java
import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private Map<String, Double> expenses;

    public Person(String name) {
        this.name = name;
        this.expenses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addExpense(String category, double amount) {
        expenses.put(category, expenses.getOrDefault(category, 0.0) + amount);
    }

    public void showExpenses() {
        System.out.println(name + "'s Expenses:");
        for (Map.Entry<String, Double> entry : expenses.entrySet()) {
            System.out.printf("%s - $%.2f%n", entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
```
### Expense.Java
```java
public class Expense {
    private String category;
    private double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}
```
### ExpenseTracker.java
```java
import java.util.HashMap;
import java.util.Map;

public class ExpenseTracker {
    private Map<String, Person> people;

    public ExpenseTracker() {
        people = new HashMap<>();
    }

    public void addPerson(String name) {
        if (!people.containsKey(name.toLowerCase())) {
            people.put(name.toLowerCase(), new Person(name));
            System.out.println("Added person: " + name);
        } else {
            System.out.println("Person " + name + " already exists.");
        }
    }

    public void addExpense(String personName, String category, double amount) {
        Person person = people.get(personName.toLowerCase());
        if (person != null) {
            person.addExpense(category, amount);
            System.out.println("Added expense for " + personName);
        } else {
            System.out.println("Person not found.");
        }
    }

    public void showExpenses() {
        for (Person person : people.values()) {
            person.showExpenses();
        }
    }
}
```
### Execution steps
```bash
javac *.java
java Main
```
