import java.util.Scanner;

public class PayrollApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PayrollService service = new PayrollService();

        while (true) {

            System.out.println("\n===== EMPLOYEE PAYROLL SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Calculate Salary");
            System.out.println("5. Exit");
            System.out.print("➡ Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Select Employee Type:");
                    System.out.println("1. Full-Time");
                    System.out.println("2. Part-Time");
                    System.out.println("3. Contract");

                    System.out.print("➡ Enter Type: ");
                    int type = sc.nextInt();

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    if (type == 1) {
                        System.out.print("Basic Salary: ");
                        double basic = sc.nextDouble();
                        System.out.print("Allowance: ");
                        double allowance = sc.nextDouble();
                        System.out.print("Tax: ");
                        double tax = sc.nextDouble();

                        service.addEmployee(new FullTimeEmployee(id, name, basic, allowance, tax));
                    } 
                    else if (type == 2) {
                        System.out.print("Hourly Rate: ");
                        double rate = sc.nextDouble();
                        System.out.print("Hours Worked: ");
                        int hours = sc.nextInt();

                        service.addEmployee(new PartTimeEmployee(id, name, rate, hours));
                    } 
                    else {
                        System.out.print("Contract Amount: ");
                        double amt = sc.nextDouble();

                        service.addEmployee(new ContractEmployee(id, name, amt));
                    }
                    break;

                case 2:
                    service.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Search: ");
                    Employee emp = service.searchEmployee(sc.nextInt());

                    if (emp != null)
                        System.out.println("Employee Found: " + emp);
                    else
                        System.out.println("❌ Employee Not Found!");
                    break;

               case 4:
                   System.out.print("Enter Employee ID: ");
                    Employee e = service.searchEmployee(sc.nextInt());

                   if (e != null)
                      System.out.println("💰 Salary for " + e.name + ": " + e.calculateSalary());
                   else
                   System.out.println("❌ Employee Not Found!");
                   break;


                case 5:
                
                    service.saveToFile();
                   System.out.println("📦 Exiting System... Goodbye!");
                  sc.close();
                   return;


                default:
                    System.out.println("⚠ Invalid Input, please try again.");
            }
        }
    }
}
