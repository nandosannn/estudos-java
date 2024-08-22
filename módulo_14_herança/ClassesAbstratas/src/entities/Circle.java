package entities;

import entities.enums.Color;

public class Circle extends Shape {
    private Double radius;


    //Construtores
    public Circle() {
    }


    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }


    //Encapsuladores
    public Double getRadius() {
        return radius;
    }


    public void setRadius(Double radius) {
        this.radius = radius;
    }

    //Métodos
    @Override
    public Double area(){
        return Math.PI * radius * radius;
    }
}
