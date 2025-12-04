public class Main {
    public static void main(String[] args) {

        PayrollService service = new PayrollService();

        // Create sample employees
        Employee e1 = new FullTimeEmployee(1, "Alice", 20000, 5000, 2000);
        Employee e2 = new PartTimeEmployee(2, "Bob", 300, 40);
        Employee e3 = new ContractEmployee(3, "John", 40000);

        // Add to service
        service.addEmployee(e1);
        service.addEmployee(e2);
        service.addEmployee(e3);

        // View and test
        service.viewEmployees();

        // Search example
        Employee found = service.searchEmployee(2);
        if(found != null){
            System.out.println("\nFound Employee: " + found.name);
            System.out.println("Salary: " + found.calculateSalary());
        }
    }
}
