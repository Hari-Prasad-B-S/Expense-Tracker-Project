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
            System.out.printf("%s - Rs.%.2f%n", entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
