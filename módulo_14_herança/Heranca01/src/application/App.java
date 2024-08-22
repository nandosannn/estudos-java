
package application;

import entities.Employee;
import entities.OutsourceEmployee;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = input.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced (y/n)? ");
            char outsourced = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Hours: ");
            Integer hours = input.nextInt();
            System.out.print("Value per hour: ");
            Double value = input.nextDouble();

            if (outsourced == 'y') {
                System.out.print("Additional charge: ");
                Double add = input.nextDouble();
                employees.add(new OutsourceEmployee(name, hours, value, add));
            }
            else{
                employees.add(new Employee(name, hours, value));
            }
        }
        System.out.println();
        System.out.println("PAYMENTS: ");
            for(Employee emp : employees){
                System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
            }
        input.close();

    }
}
