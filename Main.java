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
