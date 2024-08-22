package entities;

public class Employee {
    
    private Integer id;
    private String name;
    private Double salary;

    //Construtor
    public Employee(Integer id, String name, Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    //Encapsulamento
    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Double getSalary(){
        return salary;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void getName(String name){
        this.name = name;
    }

    public void getSalary(Double salary){
        this.salary = salary;
    }

    public void increaseSlary(double percentage){
        salary = salary*(1.0 + percentage/100.0);
    }

    public String toString(){
        return id + ", " + name + ", " + String.format("%.2f", salary);
    }
}
