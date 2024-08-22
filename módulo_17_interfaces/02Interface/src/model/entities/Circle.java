package model.entities;

import enums.Color;

public class Circle extends AbstractShape{
    private Double radius;

    //Builders
    public Circle(){

    }

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Circle(Double radius) {
        this.radius = radius;
    }

    //Encapsulators
    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    //Mathods
    public double area(){
        return Math.PI * radius * radius;
    }
    
}
