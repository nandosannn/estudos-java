package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import entities.Employee;

public class App {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        
        String path = "D:\\Desenvolvimento Web\\Java\\Módulo 17 Interfaces\\04Comparable\\in.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            
            String employeeCsv = br.readLine();
            while (employeeCsv != null) {
                String[] fields = employeeCsv.split(",");
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeCsv = br.readLine();
            
            }
            //Para que a função Collections.sort funcione para um Objeto é preciso implementar a interface Comparable
            Collections.sort(list);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for(Employee lists : list){
            System.out.printf("%s - %f\n", lists.getNome(), lists.getSalary());
        }
    }
}