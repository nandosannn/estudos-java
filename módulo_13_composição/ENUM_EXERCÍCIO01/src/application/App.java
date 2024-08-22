
package application;

import java.util.Scanner;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String department = input.nextLine();

        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Level: ");
        String level = input.nextLine();
        System.out.print("Base salary: ");
        Double salary = input.nextDouble();
        Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary, new Department(department));

        System.out.print("How many contracts to this worker? ");
        int n = input.nextInt();

        for(int i = 0; i < n; i++){
            System.out.printf("Enter contract #%d data: \n", i+1);
            
            System.out.print("Date (DD/MM/YYYY): ");
            String data = input.next();
            LocalDate date = LocalDate.parse(data, f1);
            
            System.out.print("Value per hour: ");
            double value = input.nextDouble();

            System.out.print("Duration (hours): ");
            int hour = input.nextInt();

            HourContract contract = new HourContract(date, value, hour);
            worker.addContract(contract);
        }

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        input.nextLine();
        String monthAndYear = input.nextLine();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + worker.income(year, month) + " $.");
        
        input.close();
    }
}

