package model.entities;

import enums.Color;

public class Rectangle extends AbstractShape{
    
    private Double width;
    private Double height;

    //Builders
    public Rectangle(){

    }

    public Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(Color color, Double width, Double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    
    //Encapsulators
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

    //Methods
    public double area(){
        return width * height;
    }
}
