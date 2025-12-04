import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollService {

    private List<Employee> employees;
    private static final String FILE_NAME = "employees.dat";

    public PayrollService() {
        loadFromFile(); // load saved employees when program starts
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        System.out.println("✅ Employee Added Successfully!");
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("⚠ No employees found.");
            return;
        }

        System.out.println("\n--- Employee List ---");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public Employee searchEmployee(int id) {
        for (Employee e : employees) {
            if (e.id == id) {
                return e;
            }
        }
        return null;
    }

    // ---- NEW METHODS BELOW ----

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("💾 Data Saved Successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error saving file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            employees = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("📁 Loaded existing data (" + employees.size() + " records).");
        } catch (Exception e) {
            employees = new ArrayList<>();
        }
    }
}
