import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
