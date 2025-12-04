public class FullTimeEmployee extends Employee {

    private double allowance;
    private double tax;

    public FullTimeEmployee(int id, String name, double basicSalary, double allowance, double tax) {
        super(id, name, basicSalary);
        this.allowance = allowance;
        this.tax = tax;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + allowance - tax;
    }
}
