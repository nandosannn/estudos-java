package model.entities;

public class Vehicle {
    private String model;

    //Builders
    public Vehicle(){

    }
    
    public Vehicle(String model) {
        this.model = model;
    }

    //Encapsulators
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
}
