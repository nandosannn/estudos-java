package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        int n;
        Integer id;
        String nome;
        Double salary;
        
        System.out.print("How many employees will be registered? ");
        n = input.nextInt();

        for(int i = 0; i < n; i++){
            System.out.printf("Emplyoee #%d:\n", i+1);
            System.out.print("Id: ");
            id = input.nextInt();
            while(hasId(list, id)){
                System.out.println("The id already exists");
                System.out.print("Id: ");
                id = input.nextInt();
            }
            System.out.print("Name: ");
            input.nextLine();
            nome = input.nextLine();
            System.out.print("Salary: ");
            salary = input.nextDouble();
            list.add(i, new Employee(id, nome, salary));
        }

        double percentage;
        System.out.print("Enter the employee id that will have salary increase: ");
        id = input.nextInt();
        while(position(list, id)==null){
            System.out.println("This id does not exist.");
            System.out.print("Enter the employee id again: ");
            id = input.nextInt();
        }

        percentage = input.nextDouble();
        list.get(position(list, id)).increaseSlary(percentage);

        for(Employee campo : list){
            System.out.println(campo);
        }

        input.close();
    }

    public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

    public static Integer position(List<Employee> list, Integer id){
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).getId()==id){
                return i;
            }
        }
        return null;
    }
}
