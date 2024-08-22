package entities;

public class Department {
    private String name;

    //Contrutores
    public Department(){

    }

    public Department(String name){
        this.name = name;
    }

    //Encapsuladores
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
