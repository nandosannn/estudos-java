package entities;

public class Employee implements Comparable<Employee>{
    private String nome;
    private Double salary;
    
    //Contructs
    public Employee(){

    }

    public Employee(String nome, Double salary) {
        this.nome = nome;
        this.salary = salary;
    }

    //Encapsulators
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return salary.compareTo(other.getSalary());
    }
    
}
