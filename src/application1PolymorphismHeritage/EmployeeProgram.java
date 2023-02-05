package application1PolymorphismHeritage;

import Entities1PolymorphismHeritage.Employee;
import Entities1PolymorphismHeritage.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeProgram {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int employees = scanner.nextInt();

        for (int i = 1; i < employees; i++) {
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            char outsourced = scanner.next().charAt(0);
            System.out.print("Name ");
            String name = scanner.nextLine();
            System.out.print("Hours ");
            int hours = scanner.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = scanner.nextDouble();
            if (outsourced == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = scanner.nextDouble();
                employeeList.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
            } else {
                employeeList.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println("PAYMENTS:");

        for (Employee employee : employeeList) {
            System.out.print(employee.getName() + " - $ " + String.format("%.2f", employee.payment()));
        }













        scanner.close();
    }
}