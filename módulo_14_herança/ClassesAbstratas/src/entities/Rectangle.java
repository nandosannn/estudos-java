package entities;

import entities.enums.Color;

public class Rectangle extends Shape {
    private Double width;
    private Double height;

    //Contrutores
    public Rectangle() {
    }

    public Rectangle(Color color, Double width, Double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    //Encapsuladores
    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }


    //Métodos
    @Override
    public Double area(){
        return width*height;
    }

    
}
