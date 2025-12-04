import java.io.Serializable;

public abstract class Employee implements Serializable {
    protected int id;
    protected String name;
    protected double basicSalary;

    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}
